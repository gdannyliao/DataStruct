package com.danny.datastruct.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Tree {
	public class Node {
		String name;
		Node[] childs;
	}
	
	public Node findCommonParent(Node tree, Node node1, Node node2) {
		Stack<Node> stack = new Stack<Tree.Node>();
		
		boolean node1Found = findSubTree(node1, tree, stack);
		if (node1Found) {
			
		}
			
		return null;
	}
	
	private boolean findSubTree(Node nodeTofound, Node tree, Stack<Node> stack) {
		stack.push(tree);
		if (tree == nodeTofound)
			return true;
		
		for (int i=0;i<tree.childs.length; i++) {
			if (findSubTree(nodeTofound, tree.childs[i], stack)) {
				return true;
			}
		}
		
		stack.pop();
		return false;
	}
}
