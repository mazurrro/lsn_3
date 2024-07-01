package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnionFindHelper {

    public static int getSeperatedGraphsNumber(Set<Integer> vertices, UnionFind uf) {
        // Determine the number of connected components
        Set<Integer> uniqueComponents = new HashSet<>();
        for (int vertex : vertices) {
            uniqueComponents.add(uf.find(vertex));
        }
        return uniqueComponents.size();
    }

    public static void createUnions(List<int[]> connections, UnionFind uf) {
        for(int[] connection: connections) {
            uf.union(connection[0], connection[1]);
        }
    }
}
