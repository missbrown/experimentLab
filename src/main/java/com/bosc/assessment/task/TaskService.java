package com.bosc.assessment.task;

import com.bosc.assessment.enums.TaskOpType;
import com.bosc.assessment.enums.TaskState;
import com.bosc.assessment.enums.TaskTriggerType;
import com.bosc.assessment.util.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.function.Supplier;

@Service
public class TaskService {

    @Autowired
    TaskMapper mapper;

    private SimpleDAG dag;
    private Map<Integer, Task> index2Task;
    private Map<Task, Integer> task2Index;

    public synchronized void load() {
        final List<Task> taskList = mapper.taskList(new TaskDto());
        if(taskList == null || taskList.isEmpty()) {
            throw new BusinessException("task list is empty");
        }
        final List<TaskDependency> dependencyList = mapper.taskDependencyList(new TaskDto());
        int taskNum = taskList.size();
        final SimpleDAG dag = new SimpleDAG(taskNum);
        final Map<Integer, Task> index2Task = new HashMap<>();
        final Map<Task, Integer> task2Index = new HashMap<>();
        for(Task task : taskList) {
            int index = (int) task.getId() % taskNum;
            if(!index2Task.containsKey(index)) {
                dag.setState(index, TaskState.WAIT.getState());
                index2Task.put(index, task);
                task2Index.put(task, index);
            }
        }
        for(TaskDependency dependency: dependencyList) {
            int index = (int) dependency.getTaskId() % taskNum;
            int parentIndex = (int) dependency.getParentId() % taskNum;
            dag.update(parentIndex, index);
        }
        this.dag = dag;
        this.index2Task = Collections.unmodifiableMap(index2Task);
    }

    private boolean hasInitialize() {
        return dag != null;
    }
    private List<Task> getSortedTask() {
        List<Task> taskList = new ArrayList<>();
        final List<Integer> sortedTaskList = this.dag.topologicalSort();
        for(Integer index: sortedTaskList) {
            taskList.add(index2Task.get(index));
        }
        return taskList;
    }

    private boolean isWaiting(Task task) {
        Integer index = task2Index.get(task);
        return this.dag.hasState(index, TaskState.WAIT.getState());
    }

    private void updateState(Task task, Integer state) {
        this.dag.setState(task2Index.get(task), state);
    }

    public void execute() {
        if(!hasInitialize()) {
            throw new BusinessException("dependencies has not yet initialized");
        }
        final List<Task> taskList = getSortedTask();
        for(Task task : taskList) {
            if(isWaiting(task)) {
                try {
                    CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> execute(task));
                    updateState(task, completableFuture.get());
                } catch (Exception ex) {
                    throw new BusinessException();
                }
            }
        }
    }

    public Integer execute(final Task task) {
        return execute(task, TaskTriggerType.AUTO.getType());
    }

    public Integer execute(final Task task, final int triggerType) {
        Long taskId = task.getId();
        Long userId = null; // todo
        // create task instance
        TaskInstance taskInstance = new TaskInstance();
        taskInstance.setTaskId(taskId);
        taskInstance.setCreator(userId); // todo
        taskInstance.setState(TaskState.EXEC.getState());
        taskInstance.setTriggerType(triggerType);
        // get global data time todo
        Date dataTime = null;
        taskInstance.setTaskDate(dataTime);
        // create task log
        TaskLog taskLog = new TaskLog();
        taskLog.setOpTaskId(taskId);
        taskLog.setOpType(TaskOpType.CREATE.getType());
        taskLog.setOpUserId(userId);
        // find the real executor
        // execute task
        mapper.insertTaskLog(taskLog);
        mapper.insertTaskInstance(taskInstance);
        Integer state = null;
        try {
            // Perform a task todo
        } catch (BusinessException ex) {
            // update task instance
            state = TaskState.FAIL.getState();
        } finally {
            // update task instance
            mapper.updateTaskInstance(taskInstance.getId(), state);
            // send message todo
        }
        return state;
    }
}
