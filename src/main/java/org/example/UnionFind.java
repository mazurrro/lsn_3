package org.example;

public class UnionFind {
    private int[] parent;
    private int[] rank;

    // Constructor to initialize the Union-Find data structure
    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i; // each element is its own parent initially
            rank[i] = 0;   // initial rank is zero
        }
    }

    // Find the representative (root) of the set containing x
    // Path compression is used here
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    // Union the sets containing x and y
    // Union by rank is used here
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            // Union by rank
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

}
