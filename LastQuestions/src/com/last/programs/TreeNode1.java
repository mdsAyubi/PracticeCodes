package com.last.programs;

public class TreeNode1<E> {

	E data;
	TreeNode1<E> left;
	TreeNode1<E> right;
	
	public TreeNode1(E data){
		this.data=data;
		left=right=null;
	}
	
	public TreeNode1(E data, TreeNode1<E> left){
		this(data);
		this.left=left;
		
	}

	public TreeNode1(E data,TreeNode1<E> left,TreeNode1<E> right){
		this(data,left);
		this.right=right;
	}
	public E getData(){
		return this.data;
	}
	public void setData(E data){
		this.data=data;
	}
	public TreeNode1<E> getLeft(){
		return this.left;
	}
	public TreeNode1<E> getRight(){
		return this.right;
	}
	public void setLeft(TreeNode1<E> left){
		this.left=left;
	}
	public void setRight(TreeNode1<E> right){
		this.right=right;
	}
	

	
	
}
