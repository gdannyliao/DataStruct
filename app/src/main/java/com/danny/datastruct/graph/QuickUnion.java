package com.danny.datastruct.graph;

/**
 * Created by jkl on 15/11/15.
 */
public class QuickUnion extends UnionFind {
    public QuickUnion(int n) {
        super(n);
    }

    @Override
    public void union(int p, int q) {
        int idp = find(p);
        int idq = find(q);
        if (idp == idq) return;

        id[p] = idq;
        count--;

    }

    @Override
    public int find(int p) {
        while (id[p] != p)
            p = id[p];
        return p;
    }
}
