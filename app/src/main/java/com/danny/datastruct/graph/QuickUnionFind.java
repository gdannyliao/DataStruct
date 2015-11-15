package com.danny.datastruct.graph;

/**
 * Created by jkl on 15/11/15.
 */
public class QuickUnionFind extends UnionFind {
    public QuickUnionFind(int n) {
        super(n);
    }

    /**
     * 使用id[]来存贮每个节点之间的连通性，若id[i]与id[j]相同，则表示他们相互连通
     * @param p
     * @param q
     */
    @Override
    public void union(int p, int q) {
        int idp = id[p];
        int idq = id[q];
        if (idp == idq) return;
        //如果idp与idq不同，则把他们设置成相同的值，以表示相互连通
        for (int i = 0; i < id.length; i++) {
            if (id[i] == idp)
                id[i] = idq;
        }
        count--;
    }

    @Override
    public int find(int p) {
        return id[p];
    }
}
