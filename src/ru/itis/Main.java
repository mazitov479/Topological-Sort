package ru.itis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception {
//        Random random = new Random();
//        int minCountOfGraphs = 50;
//        int maxCountOfGraps = 100;
//        FileWriter writer = new FileWriter("Graphs");
//        int countOfGraphs = minCountOfGraphs + random.nextInt(maxCountOfGraps - minCountOfGraphs + 1);
//        writer.write(String.valueOf(countOfGraphs) + "\n");
//        for (int i = 0; i < countOfGraphs; i++) {
//            int minCountOfV = 100;
//            int maxCountOfV = 10000;
//            int countOfV = minCountOfV + random.nextInt(maxCountOfV - minCountOfV + 1);
//            int countOfArcs = minCountOfV + random.nextInt(countOfV * 2);
//            Graph graph = new Graph(countOfV);
//            for (int j = 0; j < countOfArcs; j++) {
//                int v1 = random.nextInt(countOfV);
//                int v2 = random.nextInt(countOfV);
//                while (v1 == v2) {
//                    v2 = random.nextInt(countOfV);
//                }
//                graph.addEdge(v1, v2);
//            }
//            graph.topologicalSort();
//            if (!graph.isCycle()) {
//                writer.write(countOfV + "\n");
//                writer.write(countOfArcs + "\n");
//                for (int j = 0; j < countOfV; j++) {
//                    Integer k;
//                    Iterator<Integer> it = graph.getAdj()[j].iterator();
//                    while (it.hasNext()) {
//                        k = it.next();
//                        writer.write(j + "," + k + "\n");
//                    }
//                }
//
//            } else i--;
//
//
//        }
//        writer.close();


        BufferedReader reader = new BufferedReader(new FileReader("Graphs"));
        FileWriter wr = new FileWriter("GraphSort");
        int countOfGraphs1 = Integer.parseInt(reader.readLine());
        for (int i = 0; i < countOfGraphs1; i++) {

            int v = Integer.parseInt(reader.readLine());
            int numberOfArcs = Integer.parseInt(reader.readLine());
            Graph graph = new Graph(v);
            for (int j = 0; j < numberOfArcs; j++) {
                String[] arc = reader.readLine().split(",");
                graph.addEdge(Integer.parseInt(arc[0]), Integer.parseInt(arc[1]));
            }
            wr.write("Number of graph " + (i + 1) + "\n");
            wr.write("Count of Vertex " + v + "\n");
            wr.write("Following is a Topological Sort" + "\n");
            long beforeNan = System.nanoTime();
            long beforeSec = System.currentTimeMillis();
            graph.topologicalSort();
            wr.write(String.valueOf(System.nanoTime() - beforeNan) + " нан" + "\n");
            wr.write(String.valueOf(System.currentTimeMillis() - beforeSec) + " сек" + "\n");
            graph.writeSortGraphToFile(wr);
            wr.write("\n");
            wr.write(String.valueOf(graph.getCountOfIt()));
            wr.write("\n\n");


        }
        wr.close();
        reader.close();
    }
}
