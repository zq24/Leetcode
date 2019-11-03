package qinz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfConnectedComponentsInAnUndirectedGraphSolution {
    public int countComponents(int n, int[][] edges) {
        List<Set<Integer>> union = new ArrayList<>();
        List<int[]> listOfEdges = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            listOfEdges.add(edges[i]);
        }
        for (int i = 0; i < n; i++) {
            boolean connected = false;
            int j;
            for (j = 0; j < union.size(); j++) {
                connected = union.get(j).contains(i);
                if (connected) break;
            }
            if (!connected) {
                Set<Integer> newUnion = new HashSet<>();
                newUnion.add(i);
                union.add(newUnion);
                countComponents(listOfEdges, union.get(j), i);
            }
        }
        return union.size();
    }

    private void countComponents(List<int[]> edges, Set<Integer> union, int search) {

        for (int i = 0; i < edges.size(); i++) {
            int node1 = edges.get(i)[0];
            int node2 = edges.get(i)[1];
            if (node1 == search || node2 == search) {
                union.add(node1);
                union.add(node2);
                edges.remove(i);
                countComponents(edges, union, node1);
                countComponents(edges, union, node2);
            }
        }
    }
}
