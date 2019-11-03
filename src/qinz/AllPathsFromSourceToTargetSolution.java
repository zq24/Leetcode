package qinz;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllPathsFromSourceToTargetSolution {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        allPathsSourceTarget(graph, 0, results, path);
        return results;
    }

    private static void allPathsSourceTarget(int[][] graph, int startNode, List<List<Integer>> result, List<Integer> path) {
        if(startNode == graph.length - 1) {
            result.add(path);
            return;
        }

        for(int i = 0; i < graph[startNode].length; i++) {
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(graph[startNode][i]);
            int currentNode = graph[startNode][i];
            allPathsSourceTarget(graph, currentNode, result, newPath);
        }
    }

    public static void main(String[] args) {
        int[][] test = new int[][] {{1, 2}, {3}, {3}, {}};
        System.out.println(allPathsSourceTarget(test));
    }
}
