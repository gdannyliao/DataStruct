package com.danny.datastruct.graph;

/**
 * Created by jkl on 15/11/15.
 */
public abstract class UnionFind {
    /**
     * 用于存储节点之间关系的数组，它的意义由具体实现定义
     */
    int[] id;
    /**
     * 存储链接的个数
     */
    int count;

    /**
     * 初始化时，每个节点各自为一个链接，所以count=n。另外用id[i] = i表示它自己指向自己
     * @param n
     */
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
