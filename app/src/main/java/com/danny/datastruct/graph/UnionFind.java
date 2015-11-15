package com.danny.datastruct.graph;

/**
 * Created by jkl on 15/11/15.
 */
public abstract class UnionFind {
    int[] id;
    int count;
    public UnionFind(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public abstract void union(int p, int q);
    public abstract int find(int p);

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }
}
