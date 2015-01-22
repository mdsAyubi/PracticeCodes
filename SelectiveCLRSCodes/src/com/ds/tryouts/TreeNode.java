package com.ds.tryouts;

public class TreeNode<E> {

	E data;
	TreeNode<E> left;
	TreeNode<E> right;
	
	public TreeNode(E data){
		this.data=data;
		left=right=null;
	}
	
	public TreeNode(E data, TreeNode<E> left){
		this(data);
		this.left=left;
		
	}

	public TreeNode(E data,TreeNode<E> left,TreeNode<E> right){
		this(data,left);
		this.right=right;
	}
	public E getData(){
		return this.data;
	}
	public void setData(E data){
		this.data=data;
	}
	public TreeNode<E> getLeft(){
		return this.left;
	}
	public TreeNode<E> getRight(){
		return this.right;
	}
	public void setLeft(TreeNode<E> left){
		this.left=left;
	}
	public void setRight(TreeNode<E> right){
		this.right=right;
	}
	

	
	
}
