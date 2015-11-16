package com.danny.datastruct.graph;

/**
 * Created by jkl on 15/11/15.
 */
public class WeightedQuickUnion extends UnionFind {
    /*
    使用size来表示该树的大小
     */
    private int[] size;
    public WeightedQuickUnion(int n) {
        super(n);
        size = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int idp = find(p);
        int idq = find(q);
        if (idp == idq) return;

        //将较小的树的索引指向较大的树，这样就避免了一棵树太高（如果总是把大树并向小树，相当于此时树的高度被大树撑高了，而有许多空间是浪费的）
        if (size[idp] > size[idq]) {
            id[idq] = idp;
            size[idp] += size[idq];
        } else {
            id[idp] = idq;
            size[idq] += size[idp];
        }
        count--;
    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
}
