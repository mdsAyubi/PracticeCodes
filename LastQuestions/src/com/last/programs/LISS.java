package com.last.programs;


import java.util.Hashtable;

public class LISS {
	
	/*
	 * LISS(X) = MAX { (1 + sum of LISS for all grandchildren of X),
                     (sum of LISS for all children of X) }
	 */
	
	public int liss(TreeNode<Integer> root){
		
		if(root==null) return 0;
		
		int sizeExludingCurrentNode=liss(root.left)+liss(root.right);
		
		int sizeIncludingCurrentNode=1;
		
		if(root.left!=null){
			sizeIncludingCurrentNode+=liss(root.left.left)+liss(root.left.right);
		}
		if(root.right!=null){
			sizeIncludingCurrentNode+=liss(root.right.left)+liss(root.right.right);
		}
		
		return Math.max(sizeExludingCurrentNode, sizeIncludingCurrentNode);
		
	}
	
	Hashtable<TreeNode, Integer> lis=new Hashtable<TreeNode, Integer>();
	public int LISSWithDP(TreeNode<Integer> root){
		
		if(root==null) return 0;
		if(lis.get(root)!=null) return lis.get(root);
		if(root.left==null && root.right==null){
			lis.put(root, 1);
			return 1;
		}
		
		int sizeExcludingCurrentNode=LISSWithDP(root.left)+LISSWithDP(root.right);
		int sizeIncludingCurrentNode=1;
		
		if(root.left!=null)
			sizeIncludingCurrentNode+=LISSWithDP(root.left.left)+LISSWithDP(root.left.right);
		if(root.right!=null)
			sizeIncludingCurrentNode+=LISSWithDP(root.right.left)+LISSWithDP(root.right.right);
		
		return Math.max(sizeExcludingCurrentNode, sizeIncludingCurrentNode);
	}
	
	public int fact(int n){
		if(n==1) return 1;
		else
			return n*fact(n-1);
	}
	
	public static void main(String...a)throws Exception{
		LISS ls=new LISS();
		BinaryTree<Integer> tree=new BinaryTree<Integer>();
		
		tree.bstInsert(30);
		tree.bstInsert(50);
		tree.bstInsert(20);
		tree.bstInsert(10);
		tree.bstInsert(40);
		tree.bstInsert(25);
		tree.bstInsert(55);
		
		System.out.println(ls.fact(6));
		
		/*
		long start=System.currentTimeMillis();
		System.out.println(ls.LISSWithDP(tree.root));
		long end=System.currentTimeMillis();
		
		System.out.println("With DP: "+(end-start));
		
		long start1=System.currentTimeMillis();
		System.out.println(ls.LISS(tree.root));
		long end1=System.currentTimeMillis();
		System.out.println("Without DP: "+(end1-start1));
		*/
	}

}
