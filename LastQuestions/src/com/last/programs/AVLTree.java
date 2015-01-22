package com.last.programs;

public class AVLTree {
	
	AVLTreeNode root;
	
	public AVLTree(){
		root=null;
	}
	
	public AVLTreeNode rightRotate(AVLTreeNode y){
		
		AVLTreeNode x= y.left;
		AVLTreeNode T2= x.right;
		
		x.right=y;
		y.left=T2;
		
		y.height= Math.max(height(y.left),height(y.right))+1;
		x.height= Math.max(height(x.left),height(x.right))+1;
		
		return x;
	}
	
	public AVLTreeNode leftRotate(AVLTreeNode x){
		
		AVLTreeNode y = x.right;
		AVLTreeNode T1 = y.left;
		
		y.left = x;
		x.right = T1;
		
		y.height= Math.max(height(y.left),height(y.right))+1;
		x.height= Math.max(height(x.left),height(x.right))+1;
	
		return y;
	}
	
	public int height(AVLTreeNode x){
		if(x==null) return 0;
		else
		return x.height;
	}
	
	public int getBalance(AVLTreeNode node){
		
		if(node==null) return 0;
		else
		return height(node.left)-height(node.right);
	}
	
	public AVLTreeNode insert( AVLTreeNode root,Integer key){
		
		if(root==null){
			root = new AVLTreeNode(key);
			return root;
		}
		if(key<root.value)
			root.left=insert( root.left,key);
		else
			root.right=insert(root.right,key);
		
		root.height=Math.max(height(root.right), height(root.left))+1;
		
		int balance = getBalance(root);
		
		// Left Left Case
	    if (balance > 1 && key < root.left.value)
	        return rightRotate(root);
	 
	    // Right Right Case
	    if (balance < -1 && key > root.right.value)
	        return leftRotate(root);
	 
	    // Left Right Case
	    if (balance > 1 && key > root.left.value)
	    {
	        root.left =  leftRotate(root.left);
	        return rightRotate(root);
	    }
	 
	    // Right Left Case
	    if (balance < -1 && key < root.right.value)
	    {
	        root.right = rightRotate(root.right);
	        return leftRotate(root);
	    }
	 
	    /* return the (unchanged) node pointer */
	    return root;
		
	}
	
	void preOrder(AVLTreeNode root)
	{
	    if(root != null)
	    {
	        System.out.printf("%d ", root.value);
	        preOrder(root.left);
	        preOrder(root.right);
	    }
	}
	
	public static void main(String...a){
		
		AVLTree av=new AVLTree();
		  av.root = av.insert(av.root, 10);
		  av.root = av.insert(av.root, 20);
		  av.root = av.insert(av.root, 30);
		  av.root = av.insert(av.root, 40);
		  av.root = av.insert(av.root, 50);
		  av.root = av.insert(av.root, 25);
		 
		  /* The constructed AVL Tree would be
		            30
		           /  \
		         20   40
		        /  \     \
		       10  25    50
		  */
		 
		  System.out.printf("Pre order traversal of the constructed AVL tree is \n");
		  av.preOrder(av.root);
	}

}


class AVLTreeNode{
	
	Integer value;
	AVLTreeNode left;
	AVLTreeNode right;
	Integer height;
	
	public AVLTreeNode(Integer v) {
		// TODO Auto-generated constructor stub
		value=v;
		height=1;
	}
}