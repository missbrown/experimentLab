package com.bosc.assessment.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public final class SimpleDAG {

    private final int N;
    private final byte[][] dag;
    private final byte[] state;

    public SimpleDAG(int n) {
        this.N = n;
        this.dag = new byte[n][n];
        this.state = new byte[n];
    }

    public synchronized void update(int i, int j) {
        this.dag[i][j] = 1;
    }

    public synchronized void setState(int i, int code) {
        this.state[i] = (byte) code;
    }

    public boolean hasState(int i, int code) {
        return this.state[i] == (byte) code;
    }

    /**
     * topological sorting algorithm
     */
    public List<Integer> topologicalSort() {
        List<Integer> resultList = new ArrayList<>();
        int n = size();
        int[] inDegree = new int[n];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                inDegree[j] += dag[i][j];
            }
        }
        Stack<Integer> sourceNodes = new Stack<>();
        for(int ind = 0; ind < inDegree.length; ind++) {
            if(inDegree[ind] == 0) {
                sourceNodes.push(ind);
            }
        }
        int removeCount = 0;
        while(sourceNodes.size() > 0) {
            removeCount++;
            int sourceIndex = sourceNodes.pop();
            resultList.add(sourceIndex);
            for(int i = 0; i < N; i++) {
                if(dag[sourceIndex][i] == 1) {
                    inDegree[i] -= 1;
                    if(inDegree[i] == 0) {
                        sourceNodes.push(i);
                    }
                }
            }
        }
        if(removeCount != N) {
            throw new RuntimeException("not a DAG");
        }
        return resultList;
    }

    public int size() {
        return N;
    }

}
