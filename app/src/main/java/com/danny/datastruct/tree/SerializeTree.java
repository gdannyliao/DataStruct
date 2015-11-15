package com.danny.datastruct.tree;

public class SerializeTree {
    String toString(TreeNode node, String res) {
        if (node == null) return res;
        res += node.val;
        res += toString(node.left, res);
        res += toString(node.right, res);
        return res;
    }
    public String serialize(TreeNode root) {
        return toString(root, "");
    }

    TreeNode fromString(String data) {
        if (data == null || data.length() < 1) return null;
        TreeNode node = new TreeNode(data.charAt(0) - '0');

        if (data.length() > 2) {
            node.left = new TreeNode(data.charAt(1) - '0');
            node.right = new TreeNode(data.charAt(2) - '0');
        }
        else if (data.length() > 1) {
            node.left = new TreeNode(data.charAt(1) - '0');
        }
        String subString = data.substring(1);
        node.left = fromString(subString);
        if (subString.length() > 0)
            node.right = fromString(subString.substring(1));
        return node;
    }
    public TreeNode deserialize(String data) {
        return fromString(data);
    }

}

