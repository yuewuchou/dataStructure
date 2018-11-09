package com.xt.tree;

/**
 * 二叉查找树
 * @author hp
 *
 * @param <E>
 */
public class BinarySearchTree<E extends Comparable<? super E>> {
	
	private BinaryNode<E> root;
    
	public BinarySearchTree() {
		root = null;
	}

	private static class BinaryNode<E>{
		E element;
		BinaryNode<E> leftNode;
		BinaryNode<E> rightNode;

		BinaryNode(E element) {
			this(element,null,null);
		}
		
		BinaryNode(E element, BinaryNode<E> ln, BinaryNode<E> rn) {
			this.element = element;
			this.leftNode = ln;
			this.rightNode = rn;
		}
	}
	
	public Boolean contains(E e) {
		return this.contains(e, root);
	}
	
	private Boolean contains(E e,BinaryNode<E> binaryNode) {
		if(binaryNode == null) {
			return false;
		}
		
		E binaryNodeElement = binaryNode.element;
		int i = e.compareTo(binaryNodeElement);
		if(i<0) {
			return this.contains(e, binaryNode.leftNode);
		}else if(i>0) {
			return this.contains(e, binaryNode.rightNode);
		}else {
			return true;
		}
	}
	
	public void add(E e) {
		root = this.add(e, root);
	}
	
	private BinaryNode<E> add(E e,BinaryNode<E> binaryNode) {
		if(binaryNode == null) {
			return new BinaryNode<E>(e);
		}
		
		E binaryNodeElement = binaryNode.element;
		int i = e.compareTo(binaryNodeElement);
		if(i<0) {
			binaryNode.leftNode =  this.add(e, binaryNode.leftNode);
		}else if(i>0) {
			binaryNode.rightNode = this.add(e, binaryNode.rightNode);
		}
		return binaryNode;
	}
	
	public E getMax() {
		return this.getMax(root);
	}
	
	private E getMax(BinaryNode<E> binaryNode) {
		if(binaryNode == null) {
			return null;
		}
		
		if(binaryNode.rightNode == null) {
			return binaryNode.element;
		}
		
		return getMax(binaryNode.rightNode);
	}
	
	public E getMin() {
		return this.getMin(root);
	}
	
	private E getMin(BinaryNode<E> binaryNode) {
		if(binaryNode == null) {
			return null;
		}
		
		if(binaryNode.leftNode == null) {
			return binaryNode.element;
		}
		
		return getMin(binaryNode.leftNode);
	}
	
	public void remove(E e) {
		root = this.remove(e, root);
	}
	
	private BinaryNode<E> remove(E e,BinaryNode<E> binaryNode) {
		if(binaryNode == null) {
			return binaryNode;
		}
		
		E binaryNodeElement = binaryNode.element;
		int i = e.compareTo(binaryNodeElement);
		if(i<0) {
			binaryNode.leftNode = this.remove(e, binaryNode.leftNode);
		}else if(i>0) {
			binaryNode.rightNode = this.remove(e, binaryNode.rightNode);
		}else if(binaryNode.leftNode==null && binaryNode.rightNode==null){//叶子,把他置空
			binaryNode = null;
		}else if(binaryNode.leftNode==null || binaryNode.rightNode==null) {//只有一个子树,用子树替换他
			binaryNode = binaryNode.leftNode == null ? binaryNode.rightNode : binaryNode.leftNode;
		}else {//有两个子树,用右子树的最小值替换他
			E rnMin = this.getMin(binaryNode.rightNode);
			binaryNode.element = rnMin;
			binaryNode.rightNode = this.remove(rnMin, binaryNode.rightNode);
		}
		return binaryNode;
	}
	
	public void printTree() {
		this.printTree(root);
	}
	
	private void printTree(BinaryNode<E> binaryNode) {
		if(binaryNode != null) {
			printTree(binaryNode.leftNode);
			System.out.println(binaryNode.element.toString());
			printTree(binaryNode.rightNode);
		}
	}
}
