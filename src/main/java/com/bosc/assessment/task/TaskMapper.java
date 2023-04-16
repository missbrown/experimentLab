package com.bosc.assessment.task;

import java.util.List;

public interface TaskMapper {

    List<Task> taskList(TaskDto query);
    List<TaskGroup> taskGroupList(TaskDto query);
    List<TaskDependency> taskDependencyList(TaskDto query);
    List<TaskInstance> taskInstanceList(TaskDto query);
    List<TaskLog> taskLogList(TaskDto query);

    void insertTask(Task entity);
    void insertTaskGroup(TaskGroup entity);
    void insertTaskDependency(TaskDependency entity);
    void insertTaskInstance(TaskInstance entity);
    void insertTaskLog(TaskLog entity);

    void updateTask(Task entity);
    void updateTaskGroup(TaskGroup entity);
    void updateTaskInstance(Long id, Integer state);

    void deleteTask(Long id);
    void deleteTaskGroup(Long id);
    void deleteTaskDependency(Long id);
    int countTask();
}
