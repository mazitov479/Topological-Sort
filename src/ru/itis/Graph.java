package ru.itis;

import java.io.*;
import java.util.*;

class Graph {
    private int V;
    private LinkedList<Integer> adj[];
    private boolean cycle;
    private Stack stack;
    private int countOfIt;

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    private boolean topologicalSortUtil(int v, byte visited[],
                                        Stack stack) {
        countOfIt++;
        if (visited[v] == 1) return true;
        if (visited[v] == 2) return false;
        visited[v] = 1;
        Integer i;

        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();
            cycle = topologicalSortUtil(i, visited, stack);
            if (cycle) return true;
        }

        stack.push(new Integer(v));
        visited[v] = 2;
        return false;
    }

    void topologicalSort() {
        stack = new Stack();
        countOfIt = 0;

        byte visited[] = new byte[V];
        for (int i = 0; i < V; i++)
            visited[i] = 0;

        for (int i = 0; i < V; i++) {
            cycle = topologicalSortUtil(i, visited, stack);
            if (cycle) {
                return;
            }

        }
    }

    void writeSortGraphToFile(FileWriter writer) throws IOException {
        while (!stack.empty())
            writer.write(String.valueOf(stack.pop()) + " ");
    }


    LinkedList<Integer>[] getAdj() {
        return adj;
    }

    boolean isCycle() {
        return cycle;
    }

    public int getCountOfIt() {
        return countOfIt;
    }
}