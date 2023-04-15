package org.example.demo;

import com.bosc.assessment.task.SimpleDAG;
import com.bosc.assessment.task.TaskDependency;
import org.ejml.data.DMatrix3x3;
import org.ejml.dense.fixed.CommonOps_DDF3;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MatrixTest {

    @Test
    public void arrayTest() {
        SimpleDAG simpleDAG = new SimpleDAG(5);
        List<TaskDependency> taskDependencyList = new ArrayList<>();
        taskDependencyList.add(new TaskDependency(2,1));
        taskDependencyList.add(new TaskDependency(3,1));
        taskDependencyList.add(new TaskDependency(5,1));
        taskDependencyList.add(new TaskDependency(3,2));
        taskDependencyList.add(new TaskDependency(1,4));
        taskDependencyList.add(new TaskDependency(2,4));
        taskDependencyList.add(new TaskDependency(3,5));
        for(TaskDependency taskDependency : taskDependencyList) {
            simpleDAG.update((int) taskDependency.getParentId() - 1, (int) taskDependency.getTaskId() - 1);
        }
        List<Integer> sortedList = simpleDAG.topologicalSort();
        System.out.println(sortedList);
    }

    @Test
    public void mTest() {
        // declare the matrix
        DMatrix3x3 a = new DMatrix3x3();
        DMatrix3x3 b = new DMatrix3x3();

        // Can assign values the usual way
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a.set(i, j, i + j + 1);
            }
        }

        // Direct manipulation of each value is the fastest way to assign/read values
        a.a11 = 12;
        a.a23 = 64;

        // can print the usual way too
        a.print();

        // most of the standard operations are support
        CommonOps_DDF3.transpose(a, b);
        b.print();

        System.out.println("Determinant = " + CommonOps_DDF3.det(a));
    }
}
