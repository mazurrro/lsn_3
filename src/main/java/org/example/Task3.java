package org.example;

import org.example.UnionFind;

import java.util.*;

public class Task3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = getConnectionsNumber(sc);

        int maxVertex = 0;
        List<int[]> connections = new ArrayList<>();
        Set<Integer> vertices = new HashSet<>();
        for (int i = 0; i<n; i++) {
            System.out.println("Define connection between two vertices in a graph: ");
            int[] arr;
            do {
                arr = getConnections(sc);
            } while (arr.length != 2);
            vertices.add(arr[0]);
            vertices.add(arr[1]);
            connections.add(arr);
        }

        sc.close();

        maxVertex = Collections.max(vertices);

        UnionFind uf = new UnionFind(maxVertex+1);
        UnionFindHelper.createUnions(connections, uf);

        // Determine the number of connected components
        int seperatedGraphsNumber = UnionFindHelper.getSeperatedGraphsNumber(vertices, uf);
        System.out.println(seperatedGraphsNumber);

    }

    private static int getConnectionsNumber(Scanner sc) {
        int n = 0;
        do{
            System.out.println("Provide number of connections: ");
            try {
                n = sc.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Incorrect input!");
                sc.next();
            }
        } while (n < 1);

        return n;
    }

    private static int[] getConnections(Scanner sc) {
        try {
            System.out.println("Provide first vertex (integer):");
            int a = sc.nextInt();
            System.out.println("Provide second vertex (integer):");
            int b = sc.nextInt();
            return new int[]{a, b};
        } catch (NumberFormatException ex) {
            System.out.println("Incorrect input!");
        }
        return new int[0];
    }
}
