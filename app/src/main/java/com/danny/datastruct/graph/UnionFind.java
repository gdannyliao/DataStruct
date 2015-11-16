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

    /**
     * 连接两个节点
     * @param p
     * @param q
     */
    public abstract void union(int p, int q);

    public abstract int find(int p);

    /**
     * 判断两个节点是否已连接
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 返回连通量
     * @return
     */
    public int count() {
        return count;
    }
}
