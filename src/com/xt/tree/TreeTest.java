package com.xt.tree;

public class TreeTest {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.add(10);
		bst.add(15);
		bst.add(5);
		bst.add(7);
		bst.add(2);
		bst.add(6);
		Integer max = bst.getMax();
		Integer min = bst.getMin();
		bst.remove(5);
		
		bst.printTree();
	}

}
