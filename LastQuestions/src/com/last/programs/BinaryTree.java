package com.last.programs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
//import java.util.Queue;

public class BinaryTree<E extends Comparable<E>> {
	
	TreeNode<E> root;
	int size;
	
	
	
	public BinaryTree(){
		root=null;
		size=0;
	}
	
	
	
	public void insert(E data){       //Insert in complete binary tree
	
		
		TreeNode<E> node=new TreeNode<E>(data);
		
		if(root==null){
			root=node;
			//System.out.println("First time");
			return;
		}
		
		TreeNode<E> temp=null;
		Queue<TreeNode<E>> q=new Queue<TreeNode<E>>();
		q.enqueue(root);
		while(!q.isEmpty()){
			
			temp=q.dequeue();
			
			if((temp.left==null||temp.right==null)) break;
			else{
				q.enqueue(temp.left);
				q.enqueue(temp.right);
			}
			
		}
		if(temp.left==null) temp.left=node;
		
		else temp.right=node;
		
	}
	
	
	public void bstInsert(E data)throws Exception{
		TreeNode<E> node=new TreeNode<E>(data);
		
		if(root==null){
			root=node;
			System.out.println("First time");
			return;
		}
		
		TreeNode<E> temp=this.root;
		TreeNode<E> parent=this.root;
		while(temp!=null){
				
				//System.out.println("Comparison"+data.compareTo(temp.data));
				if(data.compareTo(temp.data)<0) {parent=temp;temp=temp.left;}
				else if(data.compareTo(temp.data)>0) {parent=temp;temp=temp.right;}
				else throw new Exception("Item already Present!!!");
				
			}
		if(data.compareTo(parent.data)<0) parent.left=node;
		else parent.right=node;
			
	}
		
	
		

	int count=0;
	public void kthLargestInBST(TreeNode<E> root, int k){
	
		if(root!=null){
			kthLargestInBST(root.left, k);
			count++;
			
			if(count==k) {System.out.println(root.data);return;}
			kthLargestInBST(root.right, k);
		}
		//return null;
		
	}
	
	
	public void preorder(TreeNode<E> root){
		
		if(root!=null){
		
			System.out.print(" "+root.data);
			preorder(root.left);
			
			preorder(root.right);
		}
		
	}
	public void postorder(TreeNode<E> root){
		
		if(root!=null){
		
			
			postorder(root.left);
			
			postorder(root.right);
			System.out.print(" "+root.data);
		}
		
	}
	
	public boolean search(TreeNode<E> root, E data){
		
		if(root==null) return false; 
		else{
			if(data.compareTo(root.getData())==0)
				return true;
			else
				return search(root.left,data)||search(root.right,data);
		}
		
	}
	
	public int size(TreeNode<E> root){
		
		if(root==null)
			return 0;
		else
			return size(root.left)+1+size(root.right);
		
	}
	
	public void levelOrder(TreeNode<E> root){
		
		TreeNode<E> temp=null;
		Queue<TreeNode<E>> q=new Queue<TreeNode<E>>();
		q.enqueue(root);
		while(!q.isEmpty()){
			
			temp=q.dequeue();
			System.out.print(" "+temp.getData());
			if(temp.left!=null)
				q.enqueue(temp.left);
			if(temp.right!=null)	
				q.enqueue(temp.right);
			
			
		}
	}
	
	public void levelOrderReverse(TreeNode<E> root){
		
		TreeNode<E> temp=null;
		Queue<TreeNode<E>> q=new Queue<TreeNode<E>>();
		Stack<TreeNode<E>> s=new Stack<TreeNode<E>>();
		q.enqueue(root);
		while(!q.isEmpty()){
			
			temp=q.dequeue();
			//System.out.print(" "+temp.getData());
			if(temp.left!=null)
				q.enqueue(temp.left);
			if(temp.right!=null)	
				q.enqueue(temp.right);
			s.push(temp);
			
		}
		
		while(!s.isEmpty()){
			System.out.print(" "+s.pop().getData());
		}
	}
	
	public int height(TreeNode<E> root){
		
		if(root==null) return 0;
		
		else{
			int leftHeight=height(root.left);
			int rightHeight=height(root.right);
			
			return (leftHeight>rightHeight?leftHeight+1:rightHeight+1);
		}
		
	}
	
	
	public E findMax(TreeNode<E> root){
		E left=null,right=null,rootVal=null,max=null;
		
		if(root!=null){
			rootVal=root.getData();
			if(root.left!=null)
				left=findMax(root.left);
			if(root.right!=null)
				right=findMax(root.right);
			
			if(left.compareTo(right)>0)
				max=left;
			else max=right;
			
			if(rootVal.compareTo(max)>0)
				max=rootVal;
		}
		return max;
	}
	
	int diameter=0;
	
	public int diameter(TreeNode<E> root){
		int left,right;
		
		if(root==null) return 0;
		
		left=diameter(root.left);
		right=diameter(root.right);
		
		if(left+right>diameter) diameter=left+right;
		
		return Math.max(left,right )+1;
	}
	
	
	public int numberOfLevel(TreeNode<E> root){
		
		if(root==null) return 0;
		int level=1;
		
		Queue<TreeNode<E>> q=new Queue<TreeNode<E>>();
		q.enqueue(root);
		q.enqueue(null);
		
		TreeNode<E> temp=null; 
		while(!q.isEmpty()){
			
			temp=q.dequeue();
			
			if(temp==null){
				level++;
				if(!q.isEmpty()){
					q.enqueue(null);
				}
			}
			else{
				if(temp.left!=null) q.enqueue(temp.left);
				if(temp.right!=null) q.enqueue(temp.right);
			}
			
			
			
		}
		return level;
		
		
	}
	
	//root to leaf path
	public void printPath(TreeNode<E> root,String [] path, int pathLength){
		
		if(root==null){
			return;
		}
		path[pathLength]=root.data.toString();
		pathLength++;
		
		if(root.left==null&&root.right==null)
			print(path,pathLength);
		else{
			printPath(root.left,path,pathLength);
			printPath(root.right,path,pathLength);
		}
	}
	
	private void print(String[] path, int pathLength){
		
		for(int i=0;i<pathLength;i++){
			System.out.print(" "+path[i]);
		}
		System.out.println();
	}
	
	
	
	public boolean hasSum(TreeNode<E> root, int sum){
		
		if(root==null) return (sum==0);
		
		else{
			int remainingSum=sum-(Integer)(root.data);
			System.out.print(root.data+"->");
			
			if((root.left!=null&&root.right!=null)||(root.left==null&&root.right==null)){
				//System.out.println("Upper Recursion");
				
				return hasSum(root.right,remainingSum)||hasSum(root.left,remainingSum);
			}
			else if(root.left!=null)return hasSum(root.left,remainingSum);
			else return hasSum(root.right, remainingSum);
				
		}
		
	}
	
	public Integer sumLeftRight(TreeNode<E> root){
		
		
		if(root.left==null&&root.right==null) return (Integer)root.data;
		
		else{
			Integer sum=sumLeftRight(root.left)+sumLeftRight(root.right);
			root.data=(E)sum;
			return (Integer)root.data;
		}
	}
	public int sumAll(TreeNode<E> root){
		if(root==null) return 0;
		else{
			return sumAll(root.left)+(Integer)(root.data)+sumAll(root.right);
		}
	}
	
	/*
	 * The node is the sum of its left sub-tree and right sub-tree not just left node and right node
	 */
	
	public boolean isSumPropertyFollowed(TreeNode<E> root){
		
		if(root==null || (root.left==null && root.right==null)) return true;
		
		int ls=sumAll(root.left);
		int rs=sumAll(root.right);
		
		if((Integer)root.getData()==(ls+rs) && isSumPropertyFollowed(root.left) && isSumPropertyFollowed(root.right))
			return true;
		
		else return false;
	}
	
	
	public TreeNode<E> mirror(TreeNode<E> root){
		if(root!=null){
			mirror(root.left);
			mirror(root.right);
			
			TreeNode<E> temp=root.right;
			root.right=root.left;
			root.left=temp;
		}
		return root;
	}
	
	public boolean isMirror(TreeNode<E> root1, TreeNode<E> root2){
		
		if(root1==null&&root2==null) return true;
		if(root1==null||root2==null) return false;
		
		if(root1.data.compareTo(root2.data)!=0) return false;
		
		else return isMirror(root1.left,root2.right)&&isMirror(root1.right,root2.left);
		
	}
	
	
	public TreeNode<E> LCA(TreeNode<E> root, TreeNode<E> a, TreeNode<E> b){
		
		if(root==null) return root;
		if(root.data.compareTo(a.data)==0||root.data.compareTo(b.data)==0) return root;
		
		TreeNode<E> left=LCA(root.left,a,b);
		TreeNode<E> right=LCA(root.right,a,b);
		
		if(left!=null&&right!=null) return root;
		else return left!=null? left: right;
		
		
	}
	
	public boolean ancestors(TreeNode<E>root,TreeNode<E> node){
		
		if(root==null)return false;
		
		if(root.left.data.compareTo(node.data)==0||root.right.data.compareTo(node.data)==0||ancestors(root.left, node)||ancestors(root.right, node)){
			System.out.print(" "+root.data.toString());
			return true;
		}
		return false;
	}
	
	
	public void zigzag(TreeNode<E> root){
		
		Stack<TreeNode<E>> currentLevel=new Stack<TreeNode<E>>();
		Stack<TreeNode<E>> nextLevel=new Stack<TreeNode<E>>();
		
		Queue<TreeNode<E>> q=new Queue<TreeNode<E>>();
		q.enqueue(root);
		q.enqueue(null);
		
		boolean leftToRight=true;
		currentLevel.push(root);
		currentLevel.push(null);
		
		while(!q.isEmpty()){
			
			TreeNode<E> temp=q.dequeue();
			
			if(temp==null){//level is over
				
				while(currentLevel.peek()!=null){System.out.print(" "+currentLevel.pop().data);}
				System.out.println();
				leftToRight=!leftToRight;
				if(!q.isEmpty()){q.enqueue(null);currentLevel.push(null);}
			}
			else{
				if(leftToRight){
					if(temp.left!=null){q.enqueue(temp.left);currentLevel.push(temp.left);}
					if(temp.right!=null){q.enqueue(temp.right);currentLevel.push(temp.right);}
				}
				
				else {
					if(temp.right!=null){q.enqueue(temp.right);currentLevel.push(temp.right);}
					if(temp.left!=null){q.enqueue(temp.left);currentLevel.push(temp.left);}
					
				}
				
			}
			
		}
		
		
	}
	
	public TreeNode<E> LCAinBST(TreeNode<E> a, TreeNode<E> b){
		
		TreeNode<E> temp=this.root;
		
		while(true){
			if((a.data.compareTo(temp.data)<=0&&b.data.compareTo(temp.data)>=0)||(a.data.compareTo(temp.data)>=0&&b.data.compareTo(temp.data)<=0)){
				return temp;
			}
			if(a.data.compareTo(temp.data)<0){
				temp=temp.left;
				
			}
			else{
				temp=temp.right;
			}
		}
	}
	
	
	public boolean isBST(TreeNode<E> root){
		
		if(root==null){
			return true;
		}
		if(root.left!=null&&root.left.data.compareTo(root.data)>0)
			return false;
		if(root.right!=null&&root.right.data.compareTo(root.data)<0)
			return false;
		
		if(!isBST(root.left)||!isBST(root.right))
			return false;
		
		return true;
		
	}
	
	public boolean newIsBST(TreeNode<E> root){
		
		if(root==null) return true;
		if(root.left==null&&root.right==null) return true;
		
		if(root.left!=null&&root.left.data.compareTo(root.data)>0) return false;
		
		if( root.right!=null&&root.right.data.compareTo(root.data)<0) return false;
		
		if(newIsBST(root.left)&&newIsBST(root.right)) return true;
		return false; 
		
	}
	
	public void printElemInRange(TreeNode<E> root, TreeNode<E> k1, TreeNode<E> k2){
		
		if(root==null) return ;
		
		if(root.data.compareTo(k1.data)>=0) printElemInRange(root.left, k1, k2);
		
		if((root.data.compareTo(k1.data)<0)&&(root.data.compareTo(k2.data)>0)){
			System.out.println(" "+root.data);
		}
		if(root.data.compareTo(k2.data)<=0) printElemInRange(root.right, k1, k2);
		
		
		
	}
	
	public void reverse(String str){
		char[] s=str.toCharArray();
		
		for(int i=0,j=s.length-1;i<s.length/2;i++,j--){
			char temp=s[i];
			s[i]=s[j];
			s[j]=temp;
		}
		int j;
		System.out.println("Reversed: "+new String(s));
		for(int i=0;i<s.length;){
			
			j=i;
			while((s[j]!=' '&&j<s.length))j++;
			
			for(int k=i,l=j-1;k<i+(j-i)/2;k++,l--){
				char temp=s[k];
				s[k]=s[l];
				s[l]=temp;
			}
			i=j+1;
		}
		
		System.out.println("Reversed: "+new String(s));
	}
	
	public TreeNode<E> sortedArrayToBalancedBST(E[] A, int low , int high)throws Exception{
		
		if(low<=high){
			int mid=(low+high)/2;
			bstInsert(A[mid]);
			sortedArrayToBalancedBST(A, low, mid-1);
			sortedArrayToBalancedBST(A, mid+1, high);
		}
		return root;
	}
	
	public void newZigZag(TreeNode<E> root){
		
		if(root==null) return;
		
		Stack<TreeNode<E>> currentLevel=new Stack<TreeNode<E>>();
		Stack<TreeNode<E>> nextLevel=new Stack<TreeNode<E>>();
		
		currentLevel.push(root);
		
		while(!currentLevel.isEmpty()||!nextLevel.isEmpty()){
			
			while(!currentLevel.isEmpty()){
				TreeNode<E> temp=currentLevel.pop();
				if(temp!=null){
					System.out.println(temp.data);
				
					if(temp.right!=null) nextLevel.push(temp.right);
					if(temp.left!=null) nextLevel.push(temp.left);
				}
			}
			while(!nextLevel.isEmpty()){
				TreeNode<E> temp=nextLevel.pop();
				if(temp!=null){
					System.out.println(temp.data);
				
					if(temp.left!=null) currentLevel.push(temp.left);
					if(temp.right!=null) currentLevel.push(temp.right);
				}
			}
			
			
			
			
		}
		
		
	}
	
	
	
	public void inorder(TreeNode<E> root){
		
		
		if(root!=null){	
			inorder(root.left);
			System.out.print(" "+root.data);
			inorder(root.right);
		}
		
		
	}
	int sum=13;

	public boolean pathSum(TreeNode<E> root, int currentSum, int k){
		
		
		if(root!=null){	
			
			currentSum=currentSum+(Integer)root.data;
			System.out.println("Current Sum:"+currentSum);
			
				if(currentSum==k){
					return true;
				}
			
			return pathSum(root.left, currentSum, k)||pathSum(root.right, currentSum, k);
			
			
		}
		return false;
		
		
	}
	

	ArrayList<Integer> path=new ArrayList<Integer>();
	Hashtable<String,ArrayList<Integer>> pathTable=new Hashtable<String,ArrayList<Integer>>();
public boolean pathSumPath(TreeNode<E> root, int currentSum, int k){
		
		
		if(root!=null){	
			
			 
			
			
			
			currentSum=currentSum+(Integer)root.data;
			path.add((Integer)root.data);
			pathTable.put(path.toString(), path);
			System.out.println("Current Sum:"+currentSum);
			
				if(currentSum==k){
					System.out.println(pathTable.get(path.toString()));
					
					return true;
				}
			
				
				
				//if(root.left==null||root.right==null)
				//path.remove(root.data);
				if(root.left!=null){
					path.remove(root.right);
					System.out.println("Reemoving right:"+path.toString());
					
				}
				if(root.right!=null){
					path.remove(root.left);
					System.out.println("Reemoving leftt:"+path.toString());
					
				}
				return pathSumPath(root.left, currentSum, k)|| pathSumPath(root.right, currentSum, k);
			
		}
		
		return false;
		
}
	
	public DoubleLinkedList<E> bstToDLL(TreeNode<E> root, DoubleLinkedList<E> head){
		
		if(root!=null){
			bstToDLL(root.left,head);
			System.out.print(" "+root.data);
			head.addLastElement(root.data);
			bstToDLL(root.right, head);
		}
		return head;
		
	}
	
	private void printPath(int[] A, int n){
		for(int i=0;i<n;i++){
			System.out.print(A[i]+" -> ");
		}
		System.out.println();
	}
	
	public void printRootToLeafPath(TreeNode<E> root, int[] path, int pathLength){
		
		
		if(root==null) return ;
		
			path[pathLength]=(Integer)root.data;
			pathLength++;
			
			if(root.left==null&&root.right==null){
				printPath(path,pathLength);
			}
			
			printRootToLeafPath(root.left, path, pathLength);
			printRootToLeafPath(root.right, path, pathLength);
			
			
		
		
	}
	
	private TreeNode<E> bstToDLLInPlace(TreeNode<E> root){
		
		if(root==null){
			return root;
		}
		
		if(root.left!=null){
			TreeNode<E> left=bstToDLLInPlace(root.left);
			
			for(;left.right!=null;left=left.right);
			
			left.right=root;
			root.left=left;
		}
		if(root.right!=null){
			TreeNode<E> right=bstToDLLInPlace(root.right);
			
			for(;right.left!=null;right=right.left);
			
			right.left=root;
			root.right=right;
		}
		
		return root;
		
		
		
	}
	
	public TreeNode<E> bstToDDLLDriver(TreeNode<E> root){
		
		if(root==null) return root;
		
		root=bstToDLLInPlace(root);
		
		while(root.left!=null) root=root.left;
		
		TreeNode<E> temp=root;
		while(temp!=null){
			System.out.print(temp.data+"->");
			temp=temp.right;
		}
		
		return root;
		
	}
	
	
	
	public boolean isIdentical(TreeNode<E> root1, TreeNode<E> root2){
		
		if(root1==null && root2==null) return true;
		
		else if(root1!=null && root2!=null){
			return root1.data.equals(root2.data) && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
		}
		else return false;
		
	}
	
	public int countLeaves(TreeNode<E> root){
		
		if(root==null) return 0;
		else if(root.left==null && root.right==null) return 1;
		
		else return countLeaves(root.left)+countLeaves(root.right);
		
	}
	
	
	public boolean isSumProperty(TreeNode<E> root){
		
		Integer leftData=0,rightData=0;
		
		if(root==null|| (root.left==null&&root.right==null)){
			return true;
		}
		else{
			if(root.left!=null) leftData=(Integer)root.left.data;
			if(root.right!=null) rightData=(Integer)root.right.data;
			
			if((Integer)root.data==leftData+rightData && isSumProperty(root.left) && isSumProperty(root.right))
				return true;
			else return false;  
		}
		
	}
	
	//convert tree to have children sum property, only incrementing is allowed and structure should not be
	//changed
	
	public void convertToHaveChildrenSumProperty(TreeNode<E> root){
		
		Integer leftData=0,rightData=0;
		
		if(root==null ||(root.left==null && root.right==null)){
			return;
		}
		else{
			convertToHaveChildrenSumProperty(root.left);
			convertToHaveChildrenSumProperty(root.right);
			
			if(root.left!=null) leftData=(Integer)root.left.data;
			if(root.right!=null) rightData=(Integer)root.right.data;
			
			Integer diff=(leftData+rightData)-(Integer)root.data;
			
			if(diff>0){ 
				Integer data=(Integer)root.data+diff;
				root.setData((E)data);
			}
			if(diff<0){
				increment(root,-diff); //-ve sign to make diff a positive difference
			}
		}
	}
	
	private void increment(TreeNode<E> node, Integer diff){
		
		if(node.left!=null){
			
			Integer data=(Integer)node.left.data+diff;
			node.left.setData((E)data);
			increment(node.left, diff);
		}
		else if(node.right!=null){
			
			Integer data=(Integer)node.right.data+diff;
			node.right.setData((E)data);
			increment(node.right, diff);
		}
		
	}
	
	public boolean isBalanced(TreeNode<E> root){
		
		if(root==null) return true;
		else{
			
			int lh=height(root.left);
			int rh=height(root.right);
			
			if(Math.abs(lh-rh)<=1 && isBalanced(root.left) && isBalanced(root.right))
				return true;
			else return false;
		}
	}
	
	public boolean hasSumFromRootToLeaf(TreeNode<E> head, Integer sum){
		
		if(head==null)
			return sum==0;
		
		else{
			boolean ans=false;
			Integer remainingSum=sum-(Integer)root.data;
			
			if(remainingSum==0 &&(head.right==null && head.left==null)){
				return true;
			}
			if(head.left!=null)
				ans= ans|| hasSumFromRootToLeaf(head.left, remainingSum);
			if(head.right!=null)
				ans= ans|| hasSumFromRootToLeaf(head.right, remainingSum);
		
			return ans;
		}
	}
	
	
	/*
	 * 1) Pick an element from Preorder. Increment a Preorder Index Variable (preIndex in below code) 
	 * to pick next element in next recursive call.
		2) Create a new tree node tNode with the data as picked element.
		3) Find the picked element’s index in Inorder. Let the index be inIndex.
		4) Call buildTree for elements before inIndex and make the built tree as left subtree of tNode.
		5) Call buildTree for elements after inIndex and make the built tree as right subtree of tNode.
		6) return tNode.
	 */
	
	int preIndex=0;
	public TreeNode<E> buildTree(String[] in, String[] pre, int inStart, int inEnd){
			
		if(inStart>inEnd) return null;
		
		TreeNode<E> newNode=new TreeNode<E>((E)pre[preIndex++]);
		
		if(inStart==inEnd) return newNode;
		
		int inIndex=searchInInorder(in, inStart, inEnd, newNode.data);
		
		newNode.left=buildTree(in, pre, inStart, inIndex-1);
		newNode.right=buildTree(in, pre, inIndex+1, inEnd);
		
		return newNode;
	}
	
	private int searchInInorder(String[] in, int start, int end, E data){
		
		for(int i=0;i<in.length;i++){
			if(in[i].equals((String)data)) return i;
		}
		return -1;
		
	}
	
	
	public void doubleTree(TreeNode<E> root){
		
		if(root==null) return;
		doubleTree(root.left);
		doubleTree(root.right);
		
		TreeNode<E> oldLeft=root.left;
		TreeNode<E> newLeft=new TreeNode<E>(root.data);
		root.left=newLeft;
		newLeft.left=oldLeft;
	}
	
	/*
	 * Given a binary tree, write a function to get the maximum width of the given tree. 
	 * Width of a tree is maximum of widths of all levels.
	 */
	
	public int getMaxWidth(TreeNode<E> root){
		
		int h=height(root);
		int maxWidth=Integer.MIN_VALUE;
		
		for(int i=1;i<=h;i++){
			
			int width=getWidth(root, i);
			if(width>maxWidth)
				maxWidth=width;
		}
		
		return maxWidth;
	}
	
	private int getWidth(TreeNode<E> root, int level){
		
		if(root==null) return 0;
		
		if(level==1) return 1;
		
		if(level>1)
		return getWidth(root.left,level-1)+getWidth(root.right, level-1);
		
		return 0;
	}
	
	/*
	 * A tree can be folded if left and right subtrees of the tree are structure wise mirror image of each other. 
	 * An empty tree is considered as foldable.
	 */
	public boolean isFoldable(TreeNode<E> root){
		
		if(root==null) return true;
		
		mirror(root.left);
		boolean res=isStructureWiseSame(root.left, root.right);
		mirror(root.left);
		
		return res;
	}
	
	private boolean isStructureWiseSame(TreeNode<E> root1, TreeNode<E> root2){
		
		if(root1==null && root2==null) return true;
		
		if(root1!=null && root2!=null && isStructureWiseSame(root1.left, root2.left) && isStructureWiseSame(root1.right, root2.right))
			return true;
		
		return false;
	}
	
	/*
	 * Print nodes at k distance from root
	 */
	
	public void printNodeAtKDistance(TreeNode<E> root, int k){
		
		if(root==null) return;
		
		if(k==0) {System.out.println(root.getData()); return;}
		
		else{
			printNodeAtKDistance(root.left, k-1);
			printNodeAtKDistance(root.right, k-1);
		}
	}

	public int getLevelOfANode(TreeNode<E> root, E data, int level){
		
		if(root==null) return 0;
		
		if(root.getData().equals(data)) return level;
		
		int downLevel=getLevelOfANode(root.left, data, level+1);
		if(downLevel != 0) return downLevel;
		
		downLevel=getLevelOfANode(root.right, data, level+1);
		return downLevel;
		
	}
	
	
	public boolean isSubtree(TreeNode<E> T, TreeNode<E> S){
		
		if(S==null) return true;
		if(T==null) return false;
		
		if(isIdentical(T, S)) return true;
		
		return isSubtree(T.left, S)||isSubtree(T.right, S);
	}
	
	public void verticalSum(TreeNode<E> root, int horizontalDistance, HashMap<Integer,Integer> hm){
		
		if(root==null) return;
		
		verticalSum(root.left, horizontalDistance-1, hm);
		
		Integer prevSum=hm.get(horizontalDistance)==null?0:hm.get(horizontalDistance);
		hm.put(horizontalDistance, prevSum+(Integer)root.data);
		
		verticalSum(root.right, horizontalDistance+1, hm);
		
		
	}
	
	
	/*
	 * Max root to leaf path: Do a post order traversal, maintain sum
	 */
	Integer maxSum=Integer.MIN_VALUE;
	TreeNode<E> targetNode=null;
	private void getMaxPathTargetNode(TreeNode<E> root, Integer currentSum){
		
		if(root==null) return;
		
		currentSum=currentSum+(Integer)root.data;
			
		if(root.left==null && root.right==null){ // for leaf nodes, if remove this check, any path will be considered
			if(currentSum>maxSum){
				maxSum=currentSum;
				targetNode=root;
				System.out.println("Max Sum: "+maxSum);
				System.out.println("Target Node :"+targetNode.data.toString());
						
			}
		}
		
		getMaxPathTargetNode(root.left, currentSum);
		getMaxPathTargetNode(root.right, currentSum);
	}
	
	private boolean printPathToNode(TreeNode<E> root, TreeNode<E> targetNode){
		
		if(root==null) return false;
		
		System.out.println("root "+root.data.toString());
		
		if(root.equals(targetNode) || printPathToNode(root.left, targetNode)|| printPathToNode(root.right, targetNode)){
			System.out.println(root.data);
			return true;
		}
		return false;
	}
	
	public void maxRootToLeafPath(TreeNode<E> root){
		
		
		//Integer maxSum=Integer.MIN_VALUE;
		Integer currentSum=0;
		
		getMaxPathTargetNode(root, currentSum);
		
		//System.out.println("Max Sum:"+maxSum);
		System.out.println("Target Node :"+targetNode.data.toString());
		printPathToNode(root,targetNode);
		
	}
	
	
	public TreeNode<E> buildSpecialTreeFromInorder(Integer[] inorder, int start, int end){
		
		if(start>end) return null;
		
		int i=maxOf(inorder, start, end);
		
		TreeNode<E> node=new TreeNode<E>((E)inorder[i]);
		
		if(start==end) return root;
		
		buildSpecialTreeFromInorder(inorder, start,i-1);
		buildSpecialTreeFromInorder(inorder, i+1, end);
		
		return root;
	}
	
	
	private int maxOf(Integer[] inorder, int start, int end){
		
		int maxPos=start;
		
		for(int i=start;i<=end;i++){
			if(inorder[maxPos]<inorder[i])
				maxPos=i;
		}
		return maxPos;
	}
	
	int indexOfNodeInPreorder;
	public TreeNode<E> buildTreeFromPreorder(Integer[] pre, char[] stat){
		
		if(indexOfNodeInPreorder==pre.length) return null;
		TreeNode<E> tempNode=new TreeNode<E>((E)pre[indexOfNodeInPreorder]);
		indexOfNodeInPreorder++;
		
		if(stat[indexOfNodeInPreorder]=='N'){
			tempNode.left=buildTreeFromPreorder(pre, stat);
			tempNode.right=buildTreeFromPreorder(pre, stat);
			
		}
		return tempNode;
		
		
	}
	
	public boolean isCompleteBinaryTree(TreeNode<E> root){
		
		java.util.Queue<TreeNode<E>> q=new java.util.LinkedList<TreeNode<E>>();
		boolean flag=false;
		
		q.add(root);
		
		while(!q.isEmpty()){
			
			TreeNode<E> temp=q.remove();
			if(temp.left!=null){
				
				if(flag==true)
					return false;
				q.add(temp.left);
			}
			else flag=true;
			if(temp.right!=null){
				
				if(flag==true)
					return false;
				
				q.add(temp.right);
			}
			else flag=true;
			
			
		}
		
		return true;
	}
	
	private void printLeaves(TreeNode<E> root){
		
		if(root!=null){
			
			printLeaves(root.left);
			if(root.left==null && root.right==null){
				System.out.print(" "+root.data);
			}
			printLeaves(root.right);
		}
	}
	
	private void printLeft(TreeNode<E> root){
		
		if(root!=null){
			
			if(root.left!=null){
				System.out.print(" "+root.data);
				printLeft(root.left);
			}
			else if(root.right!=null){
				System.out.print(" "+root.data);
				printLeft(root.right);
			}
		}
	}
	
	private void printRight(TreeNode<E> root){
		
		if(root!=null){
			
			if(root.right!=null){
				System.out.print(" "+root.data);
				printRight(root.right);
			}
			else if(root.left!=null){
				System.out.print(" "+root.data);
				printRight(root.left);
			}
		}
	}
	
	public void boundaryTraversal(TreeNode<E> root){
		
		if(root!=null){
			
			printLeft(root.left);System.out.println();
			printLeaves(root.left);
			printLeaves(root.right); System.out.println();
			printRight(root.right);
		}
	}
	
	
	// A recursive function to construct Full from pre[] and post[]. 
	// preIndex is used to keep track of index in pre[].
	// l is low index and h is high index for the current subarray in post[]
	
	int index;
	public TreeNode<E> constructFullBinaryTree(Integer[] pre, Integer []post, int low, int high){
		
		if(index>=pre.length|| low>high) return null;
		
		TreeNode<E> newNode=new TreeNode<E>((E)pre[index]);
		index++;
		
		 // If the current subarray has only one element, no need to recur
		if(low==high) return newNode;
		
		int i;
		for(i=low;i<=high;i++)
			if(pre[index].equals(post[i]))
				break;	
		
			newNode.left=constructFullBinaryTree(pre, post, low, i-1);
			newNode.right=constructFullBinaryTree(pre, post, i+1, high);
		
		return newNode;
		
	}
	
	public void morrisTraversalPreorder(TreeNode<E> root){
		
		while(root!=null){
			
			if(root.left==null){
				System.out.print(" "+root.data);
				root=root.right;
			}
			else{
				
				//Find inorder successor
				TreeNode<E> currentNode=root.left;
				while(currentNode.right!=null && currentNode.right!=root) currentNode=currentNode.right;
				
				if(currentNode.right==root){
					currentNode.right=null;
					root=root.right;
				}
				else{
					System.out.print(" "+root.data);
					currentNode.right=root;
					root=root.left;
				}
				
			}
		}
	}
	 
	
	public void insertInCompleteBinaryTree( java.util.Queue<TreeNode<E>> q, E data){
		
		TreeNode<E> newNode=new TreeNode<E>(data);
		
		if(this.root==null) {
			this.root=newNode;
		}
		
		
		else{
			TreeNode<E> front=q.peek();
			
			if(front!=null && front.left==null) front.left=newNode;
			else if(front!=null && front.right==null) front.right=newNode;
			
			if(front!=null && front.right!=null && front.left!=null) q.remove();
			
		}
		
		q.add(newNode);
	}
	
	
	public TreeNode<E> linkedListToCompleteBinaryTree(java.util.LinkedList<E> list){
		
		TreeNode<E> root=null;
		int k=0;
		if(list.isEmpty()){
			root=null;
			return root;
		}
		java.util.Queue<TreeNode<E>> q=new java.util.LinkedList<TreeNode<E>>();
		
		root=new TreeNode<E>(list.get(k++));
		q.add(root);
		
		while(k<list.size()){
			
			TreeNode<E> parent=q.remove();
			TreeNode<E> left=null,right=null;
			
			left=new TreeNode<E>(list.get(k++));
			q.add(left);
			if(k<list.size()){
				right=new TreeNode<E>(list.get(k++));
				q.add(right);
			}
			parent.left=left;
			parent.right=right;
			
		}
		
		return root;
		
	}
	
	
	public boolean isIsomorphic(TreeNode<E> root1, TreeNode<E> root2){
		
		if(root1==null && root2==null) return true;
		if(root1==null || root2==null) return false;
		
		if(!root1.data.equals(root2.data)) return false;
		
		return isIsomorphic(root1.left, root2.left)&&isIsomorphic(root1.right, root2.right)||
				isIsomorphic(root1.left, root2.right)&& isIsomorphic(root1.right, root2.left);
		
	}
	
	 private static final String[] alphabet = {"", "a", "b", "c", "d", "e",
	        "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
	        "s", "t", "u", "v", "w", "x", "v", "z"};
	public static TreeNode<String> createTree(int data, String pString, int[] arr) {
		 
        // Invalid input as alphabets maps from 1 to 26
        if (data > 26) 
            return null;
 
        // Parent String + String for this node
        String dataToStr = pString + alphabet[data];
 
        TreeNode<String> root = new TreeNode<String>(dataToStr);
 
        // if arr.length is 0 means we are done
        if (arr.length != 0) {
            data = arr[0];
 
            // new array will be from index 1 to end as we are consuming 
            // first index with this node
            int newArr[] = Arrays.copyOfRange(arr, 1, arr.length);
 
            // left child
            root.left = createTree(data, dataToStr, newArr);
 
            // right child will be null if size of array is 0 or 1
            if (arr.length > 1) {
 
                data = arr[0] * 10 + arr[1];
 
                // new array will be from index 2 to end as we 
                // are consuming first two index with this node
                newArr = Arrays.copyOfRange(arr, 2, arr.length);
 
                root.right = createTree(data, dataToStr, newArr);
            }
        }
        return root;
    }
 
    // To print out leaf nodes
    public static void printleaf(TreeNode<String> root) {
        if (root == null) 
            return;
 
        if (root.left == null && root.right == null) 
            System.out.print(root.data + "  ");
         
        printleaf(root.left);
        printleaf(root.right);
    }
    
 // The main function that return difference between odd and even level
 // nodes
    
    public Integer getDiffLevel(TreeNode<E> root){
    	
    	if(root==null) return 0;
    	
    	return (Integer)root.data - getDiffLevel(root.left)-getDiffLevel(root.right);
    	
    }
	
 // A recursive function to find depth of the deepest odd level leaf
    public int depthOfOddLevelLeaf(TreeNode<E> root,int level){
    	
    	if(root==null) return 0;
    	
    	if(root.left==null && root.right==null && (level&1)==1){
    		return level;
    	}
    	return Math.max(depthOfOddLevelLeaf(root.left, level+1), depthOfOddLevelLeaf(root.right, level+1));
    }
    
    /* Recursive function which checks whether all leaves are at same level */
    int leafLevel=0;
    public boolean checkUtil(TreeNode<E> root, int level){
    	
    	if(root==null) return true;
    	
    	if(root.left==null && root.right==null){
    		
    		if(leafLevel==0){
    			leafLevel=level;
    			return true;
    		}
    		
    		return level==leafLevel;
    	}
    	
    	return checkUtil(root.left, level+1)&& checkUtil(root.right, level+1);
    	
    }
    
    
    public void printLeftView(TreeNode<E> root, int level, int maxLevelSoFar){
    	
    	if(root==null) return;
    	
    	if(maxLevelSoFar<level){
    		System.out.println(root.data);
    		maxLevelSoFar=level;
    	}
    	printLeftView(root.left, level+1, maxLevelSoFar);
    	printLeftView(root.right, level+1, maxLevelSoFar);
    	
    }
    
    
    /*
     * Given a binary tree, a complete path is defined as a path from root to a leaf. 
     * The sum of all nodes on that path is defined as the sum of that path. 
     * Given a number K, you have to remove (prune the tree) all nodes which don’t lie in any path with sum>=k.
     */
    
    Integer sumOfPathTillHere=0;
    Sum lsum=new Sum();
    Sum rsum=new Sum();
    public TreeNode<E> pruneLessThanK(TreeNode<E> root, int k, Sum sum){
    	
    	//sumOfPathTillHere=sum;
    	System.out.println("Sum:"+sum.sum);
    	if(root==null) return null;
    	
    	lsum.sum=sum.sum+(Integer)root.data;
    	rsum.sum=lsum.sum;
    	
    	root.left=pruneLessThanK(root.left, k,lsum);
    	root.right=pruneLessThanK(root.right, k,rsum);
    	
    	sum.sum=Math.max(lsum.sum, rsum.sum);
    	if(sum.sum<=k){
    		//sum.sum-=(Integer)root.data;
    		System.out.println("Deleting...:"+root.data);
    		root=null;
    	}
    	return root;
    }
    
    public TreeNode<E> addLeavesToDLL(TreeNode<E> root, TreeNode<E> head){
    	
    	if(root==null) return null;
    	
    	if(root.left==null && root.right==null){
    		
    		root.right=head;
    		
    		if(head!=null) head.left=root;
    		head=root;
    		
    		return null;
    		
    	}
    	root.right=addLeavesToDLL(root.right, head);
    	root.left=addLeavesToDLL(root.left, head);
    	
    	return root;
    }
    
    int maxLevelSofar=0;
    public void deepestLeaf(TreeNode<E> root, int level, boolean isLeft, TreeNode<E> deepest){
    	
    	if(root==null) return;
    	
    	if(isLeft && root.left==null && root.right==null && level>maxLevelSofar){
    		deepest=root;
    		maxLevelSofar=level;
    		return;
    	}
    	deepestLeaf(root.left, level+1, true, deepest);
    	deepestLeaf(root.right, level+1, false, deepest);
    }
    
    /*
     * Given a binary tree, where every node value is a Digit from 1-9 .
     * Find the sum of all the numbers which are formed from root to leaf paths.
     */
    
    public Integer rootToLeafNumberSum(TreeNode<E> root, Integer val){
    	
    	if(root==null) return 0;
    	val=val*10+(Integer)root.data;
    	
    	if(root.left==null && root.right==null)
    		return val;
    	
    	return rootToLeafNumberSum(root.left, val)+rootToLeafNumberSum(root.right, val);
    }
    
    
    private TreeNode<E> findDistanceUtil(TreeNode<E> root, Integer n1, Integer n2, Num d1, Num d2, Num dist, int level){
    	
    	if(root==null) return null;
    	
    	if(root.data.compareTo((E)n1)==0){
    		d1.num=level;
    		return root;
    	}
    	if(root.data.compareTo((E)n2)==0){
    		d2.num=level;
    		return root;
    	}
    	
    	TreeNode<E> leftLCA=findDistanceUtil(root.left, n1, n2, d1, d2, dist, level+1);
    	TreeNode<E> rightLCA=findDistanceUtil(root.right, n1, n2, d1, d2, dist, level+1);
        
    	if(leftLCA!=null && rightLCA!=null){
    		dist.num=d1.num+d2.num-2*level;
    		return root;
    	}
    	return leftLCA!=null?leftLCA:rightLCA;
    }
    
    private int findLevel(TreeNode<E> root, Integer data, int level){
    	
    	if(root==null) return -1;
    	
    	if(root.data.compareTo((E)data)==0){
    		return level;
    	}
    	int l=findLevel(root.left, data, level+1);
    	
    	return l==-1?findLevel(root.right, data, level+1):l;
    }
    
    public int findDistance(TreeNode<E> root, int n1, int n2){
    	
    	
    
    	Num dist=new Num();
    	Num d1=new Num();
    	Num d2=new Num();
    	d1.num=-1; d2.num=-1;
    	TreeNode<E> lca=findDistanceUtil(root, n1, n2, d1, d2, dist,1);
    	
    	if(d1.num!=-1 && d2.num!=-1){
    		//System.out.println("D1:"+d1+" D2:"+d2);
    		return dist.num;
    	}
    	
    	if(d1.num!=-1){
    		dist.num=findLevel(lca,n2,0);
    		return dist.num;
    	}
    	if(d2.num!=-1){
    		dist.num=findLevel(lca,n1,0);
    		return dist.num;
    	}
    	
    	return -1;
    }
    
    public void printNodesAtKDistanceFromLeaf(TreeNode<E> root, int[] path, int pathLength,boolean[] visited, int k){
    	
    	if(root==null) return;
    	
    	path[pathLength]=(Integer)root.data;
    	visited[pathLength]=false;
    	pathLength++;
    	
    	if(root.left==null && root.right==null && pathLength-k-1>=0 && visited[pathLength-k-1]==false ){
    		System.out.println(path[pathLength-k-1]);
    		visited[pathLength-k-1]=true;
    		return;
    	}
    	
    	printNodesAtKDistanceFromLeaf(root.left, path, pathLength, visited, k);
    	printNodesAtKDistanceFromLeaf(root.right, path, pathLength, visited, k);
        
    }
    
    private void printNodes(TreeNode<E> root, int k){
    	
    	if(root==null|| k<0) return;
    	
    	if(k==0){
    		System.out.println(root.data);
    		return;
    	}
    	printNodes(root.left, k-1);
    	printNodes(root.right, k-1);
    	
    }
    
    public int printNodeAtKDistanceFromNode(TreeNode<E> root, TreeNode<E> target, int k){
    	
    	if(root==null)
    		return -1;
    	
    	if(root==target){
    		printNodes(root, k);
    		return 0;
    	}
    	int dl=printNodeAtKDistanceFromNode(root.left, target, k);
    	if(dl!=-1){
    		if(dl+1==k) System.out.println(root.data);
    		else 
    			printNodes(root, k-dl-2);
    		
    		return 1+dl;
    	}
    	
    	int dr=printNodeAtKDistanceFromNode(root.right, target, k);
    	if(dr!=-1){
    		if(dr+1==k) System.out.println(root.data);
    		else 
    			printNodes(root, k-dr-2);
    		
    		return 1+dr;
    	}
    	
    	return -1;
    	
    }
    
    public int largestBSTInBT(TreeNode<E> root){
    	
    	if(isBST(root)) return size(root);
    	
    	else
    		return Math.max(largestBSTInBT(root.left), largestBSTInBT(root.right));
    }
    
    
    /*
     * Given two arrays which represent a sequence of keys.
     *  Imagine we make a Binary Search Tree (BST) from each array. 
     * We need to tell whether two BSTs will be identical or not without actually constructing the tree.
     */
    
    public boolean isIdenticalWithoutMakingBST(int[] a, int[] b, int i1, int i2, int min, int max){
    	int  j,k;
    	for(j=i1;j<a.length;j++){
    		if(a[j]>min && a[j]<max) break;
    	}
    	for(k=i2;k<b.length;k++){
    		if(b[k]>min && b[k]<max) break;
    	}
    	
    	if(j==a.length&&k==b.length) return true;
    	
    	if(((j==a.length)^(k==b.length))||(a[j]!=b[k])) return false;
    	
    	return isIdenticalWithoutMakingBST(a, b, j+1, k+1, a[j],max)&&
    			isIdenticalWithoutMakingBST(a, b, j+1, k+1, min, a[j]);
    	
    }
    
    //Add to node all the values greater than it
    Integer sumSoFar=0;
    public void addGreaterValueToNode(TreeNode<E> root){
    	
    	if(root==null) return;
    	
    	addGreaterValueToNode(root.right);
    	
    	sumSoFar=sumSoFar+(Integer)root.data;
    	//root.setData((E)sumSoFar);
    	root.data=(E)sumSoFar;
    	//if(root.left!=null)
    	addGreaterValueToNode(root.left);
    	
    }
    
    public TreeNode<E> removeOutsideRangeInBST(TreeNode<E> root, Integer min, Integer max){
    	
    	if(root==null) return null;
    	
    	root.left=removeOutsideRangeInBST(root.left, min, max);
    	root.right=removeOutsideRangeInBST(root.right, min, max);
    	
    	if(root.data.compareTo((E)min)<0){
    		TreeNode<E> right=root.right;
    		//root=null;
    		return right;
    	}
    	if(root.data.compareTo((E)max)>0){
    		TreeNode<E> left=root.left;
    		//root=null;
    		return left;
    	}
    	return root;
    }
    
    
    public boolean hasOnlyOneRightChild(int[] pre){
    	
    	int nextPreorderSuccessorDiff;
    	int lastPreorderSuccessorDiff;
    	for(int i=0;i<pre.length-1;i++){
    		
    		nextPreorderSuccessorDiff=pre[i]-pre[i+1];
    		lastPreorderSuccessorDiff=pre[i]-pre[pre.length];
    		
    		if(nextPreorderSuccessorDiff*lastPreorderSuccessorDiff<0)return false;
    	}
    	return true;
    }
    
    public void swap(TreeNode<E> a , TreeNode<E> b){
    	E temp=a.data;
    	a.data=b.data;
    	b.data=temp;
    }
    
    private boolean isPresentInDLL(DoubleLinkedList<E> dll, Integer t){
    	
    	DLLNode<E> head=dll.head;
    	DLLNode<E> tail=dll.head;
    	DLLNode<E> temp=dll.head;
    	while(temp.next!=null){
    		temp=temp.next;
    	}
    	tail=temp;
    	System.out.println("tail:"+tail.toString());
    	
    	while(head!=tail){
    		
    		Integer sum=(Integer)head.data+(Integer)tail.data;
    		if(sum==t) return true;
    		else if(sum>t)
    			tail=tail.prev;
    		else
    			head=head.next;
    	}
    	return false;
    	
    }
    
    public boolean isTripletSumZeroPresent(TreeNode<E> root){
    	
    	if(root==null) return false;
    	
    	DoubleLinkedList<E> dll=new DoubleLinkedList<E>();
    	dll=bstToDLL(root, dll);
    	
    	
    	System.out.println(dll.head);
    	
    	DLLNode<E> head=dll.head;
    	while(head!=null && head.data.compareTo((E)new Integer(0))<0){
    		System.out.println(head.toString());
    		Integer t= (Integer)head.data;
    		if(isPresentInDLL(dll, -t)) return true;
    		else
    			head=head.next;
    		
    	}
    	return false;
    }
    
    
    public void mergeBSTs(TreeNode<E> root1, TreeNode<E> root2){
    	java.util.Stack<TreeNode<E>> s1=new java.util.Stack<TreeNode<E>>();
    	java.util.Stack<TreeNode<E>> s2=new java.util.Stack<TreeNode<E>>();
    	
    	TreeNode<E> cur1=root1;
    	TreeNode<E> cur2=root2;
    	
    	if(root1==null) {
    		inorder(root2);
    		return;
    	}
    	if(root2==null) {
    		inorder(root1);
    		return;
    	}
    	
    	while(cur1!=null || !s1.isEmpty()|| cur2!=null || !s2.isEmpty()){
    		
    		if(cur1!=null || cur2!=null){
    			
    			if(cur1!=null){
    				s1.push(cur1);
    				cur1=cur1.left;
    			}
    			if(cur2!=null){
    				s2.push(cur2);
    				cur2=cur2.left;
    			}
    		}
    		else{
    			if(s1.isEmpty()){
    				
    				while(!s2.isEmpty()){
    					cur2=s2.pop();
    					cur2.left=null;
    					inorder(cur2);
    				}
    				return;
    			}
    			if(s2.isEmpty()){
    				
    				while(!s1.isEmpty()){
    					cur1=s1.pop();
    					cur1.left=null;
    					inorder(cur1);
    				}
    				return;
    			}
    		}
    		cur1=s1.pop();
    		cur2=s2.pop();
    		
    		if((Integer)cur1.data < (Integer)cur2.data){
    			System.out.print(" "+cur1.data);
    			cur1=cur1.right;
    			s2.push(cur2);
    			cur2=null;
    		}
    		else{
    			System.out.print(" "+cur2.data);
    			cur2=cur2.right;
    			s1.push(cur1);
    			cur1=null;
    		}
    		
    	}
    	
    }
    
    
    public E ceil(TreeNode<E> root, E data){
    	
    	if(root==null) return null;
    	
    	if(root.data.equals(data)) return root.data;
    	if(root.data.compareTo(data)<0)
    		return ceil(root.right, data);
    	
    	E ceil= ceil(root.left, data);
    	
    	return ceil.compareTo(data)>=0?ceil:root.data;
    	//else return root.data;
    }
    //int preIndex=0;
    public TreeNode<E> buildTreeFromPreorder(Integer[] pre, Integer key,Integer min, Integer max){
    	
    	if(preIndex>=pre.length) return null;
    	TreeNode<E> root=null;
    	if(key> min && key < max){
    		
    		root=new TreeNode<E>((E)pre[preIndex]);
    		System.out.println(root.data.toString());
    		preIndex++;
    		
    		if(preIndex<pre.length){
    			root.left=buildTreeFromPreorder(pre, pre[preIndex], min, key);
    			root.right=buildTreeFromPreorder(pre, pre[preIndex], key, max);
    		}
    	}
    	return root;
    	
    }
    
    private void correctBSTUTil(TreeNode<E> root, List<TreeNode<E>> l){
    	
    	if(root!=null){
    		correctBSTUTil(root.left, l);
    		
    		if(l.get(3)!=null && (Integer)root.data < (Integer)l.get(3).data){
    			
    			if(l.get(0)==null){
    				//l.get(0)=l.get(3);
    				l.add(0,l.get(3));
    				l.add(1,root);
    			}
    			else l.add(2,root);
    		}
    		l.add(3,root);
    		correctBSTUTil(root.right, l);
    	}
    }
    
    public void correctBST(TreeNode<E> root){
    	
    	TreeNode<E> first=null, middle=null, last=null, prev=null;
    	List<TreeNode<E>> l=new ArrayList<TreeNode<E>>(10);
    	l.add(first);
    	l.add(middle);
    	l.add(last);
    	l.add(prev);
    	//correctBSTUTil(root, first l(0), middle l(1), last l(2), prev l(3));
    	correctBSTUTil(root, l);
    	
    	System.out.println(l.get(0));
    	
    	if(l.get(0) != null && l.get(2) != null){
    		System.out.println("Swapping first and last");
    		swap(first, last);
    	}
    	else if (l.get(0)!=null && l.get(1) != null)
    		swap(first,middle);
    }
    
    
    public TreeNode<E> sortedLinkedListToBST(Node<E> head, int size){
    	
    	if(size<=0 ) return null;
    	
    	TreeNode<E> left= sortedLinkedListToBST(head, size/2);
    	
    	TreeNode<E> root=new TreeNode<E>(head.getData());
    	root.left=left;
    	
    	head=head.next;
    	
    	root.right=sortedLinkedListToBST(head, size-size/2-1);
    	
    	return root;
    	
    }
    
    
public TreeNode<E> sortedDLLToBST(DLLNode<E> head, int size){
    	
    	if(size<=0 ) return null;
    	
    	TreeNode<E> left= sortedDLLToBST(head, size/2);
    	
    	TreeNode<E> root=new TreeNode<E>(head.getData());
    	root.left=left;
    	
    	head=head.next;
    	
    	root.right=sortedDLLToBST(head, size-size/2-1);
    	
    	return root;
    	
    }
    
	public static void main(String...arr)throws Exception{
		BinaryTree<Integer> bt=new BinaryTree<Integer>();
		BinaryTree<Integer> bt1=new BinaryTree<Integer>();
		
		DoubleLinkedList<Integer> dll=new DoubleLinkedList<Integer>();
		//Integer [] A={1,2,3,4,5};
		java.util.Queue<TreeNode<Integer>> q=new java.util.LinkedList<TreeNode<Integer>>();
		
		java.util.LinkedList<Integer> l=new java.util.LinkedList<Integer>();
		
		l.add(12);
		l.add(13);
		l.add(14);
		l.add(15);
		
		
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		
		//String in[] = {"D", "B", "E", "A", "F", "C"};
		//String pre[] = {"A", "B", "D", "E", "C", "F"};
		
		Integer pre[] = {1, 2, 4, 8, 9, 5, 3, 6, 7};
	    Integer post[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};
		
		bt.bstInsert(8);
		bt.bstInsert(5);
		bt.bstInsert(6);
		bt.bstInsert(9);
		bt.bstInsert(4);
		
		bt.correctBST(bt.root);
		//bt.bstInsert(10);
		//bt.bstInsert(3);
		//bt.bstInsert(7);
		/*
		BinaryTree<Integer> bt2=new BinaryTree<Integer>();
		bt2.preIndex=0;
		bt2.root=bt2.buildTreeFromPreorder(pre, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
		bt2.preorder(bt2.root);
		
		bt1.bstInsert(7);
		bt1.bstInsert(3);
		bt1.bstInsert(2);
		bt1.bstInsert(1);
		bt1.bstInsert(10);
		//bt1.bstInsert(10);
		//bt1.bstInsert(3);
		*/
		//System.out.println(bt.ceil(bt.root,new Integer(7)));
		
		//bt.inorder(bt.root);
		//bt.mergeBSTs(bt.root, bt1.root);
		
		//System.out.println(bt.isTripletSumZeroPresent(bt.root));
		//bt.addGreaterValueToNode(bt.root);
		
		//bt.removeOutsideRangeInBST(bt.root, 5, 8);
		
		System.out.println();
		//bt.inorder(bt.root);
		//BinaryTree<String> bt=new BinaryTree<String>();
		//BinaryTree<Integer> bt1=new BinaryTree<Integer>();
		
		int a[] = {8, 3, 6, 1, 4, 7, 10, 14, 13};
		int b[] = {8, 10, 14, 3, 6, 4, 1, 7, 13};
		
		//System.out.println(bt.isIdenticalWithoutMakingBST(a, b, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		//bt1.insert(5);
		//bt1.insert(4);
		//bt1.insert(6);
		//bt1.insert(3);
		
		//bt.levelOrder(bt.root);
		//System.out.println(bt.countLeaves(bt.root));
		
		//bt.root=bt.buildTree(in, pre, 0, in.length-1);
		/*
	    bt.insertInCompleteBinaryTree( q, 12);
	    bt.insertInCompleteBinaryTree( q, 13);
	    bt.insertInCompleteBinaryTree( q, 14);
	    bt.insertInCompleteBinaryTree( q, 15);
	    bt.insertInCompleteBinaryTree( q, 16);
	    bt.insertInCompleteBinaryTree( q, 17);
	    bt.insertInCompleteBinaryTree( q, 18);
	    bt.insertInCompleteBinaryTree( q, 19);
	    
	    */
		//bt.levelOrder(bt.root);
		//bt.preorder(bt.root);
		System.out.println();
		
		//int[] path=new int[1024];
		//boolean[] visited=new boolean[1024];
		//System.out.println(bt.findDistance(bt.root, 4, 10));
		
		//bt.printNodesAtKDistanceFromLeaf(bt.root, path, 0, visited, 2);
		//System.out.println(bt.rootToLeafNumberSum(bt.root, 0));
		//bt.pruneLessThanK(bt.root, 20, new Sum());
		//BinaryTree<Integer> dLL=new BinaryTree<Integer>();
		//bt.addLeavesToDLL(bt.root, dLL.root);
		//bt.inorder(bt.root);
		//System.out.println(bt.checkUtil(bt.root, 0));
		
		//bt.printLeftView(bt.root, 1, 0);
		//bt.inorder(bt.linkedListToCompleteBinaryTree(l));
		//bt.morrisTraversalPreorder(bt.root);
		//System.out.println(bt.getMaxWidth(bt.root));
		//System.out.println(bt.isFoldable(bt.root));
		
		//BinaryTree<Integer> full=new BinaryTree<Integer>();
		//full.index=0;
		//full.root=full.constructFullBinaryTree(pre, post, 0, pre.length-1);
		
		//full.inorder(full.root);
		//full.levelOrder(full.root);
		//bt.verticalSum(bt.root,0, hm);
		//System.out.println(hm.toString());
		
		//bt.maxRootToLeafPath(bt.root);
		//System.out.println(bt1.isCompleteBinaryTree(bt1.root));
		
		//bt.boundaryTraversal(bt.root);
		
		//System.out.println(bt.isSubtree(bt.root, bt1.root));
		//System.out.println(bt.printNodeAtKDistance(bt.root, 2));
		//bt.bstToDDLLDriver(bt.root);
		
		//bt.convertToHaveChildrenSumProperty(bt.root);
		
		//bt.levelOrder(bt.root);
		//bt.printRootToLeafPath(bt.root, new int[100], 0);
		//bt.sumLeftRight(bt.root);
		//bt.levelOrder(bt.root);
		//bt.bstToDLL(bt.root, dll);
		
		//System.out.println(bt.hasSum(bt.root, 13));
		
		//System.out.println(bt.pathSumPath(bt.root, 0,26));
		
		//dll.printDLL();
		//bt.inorder(bt.root);
		//bt.kthLargestInBST(bt.root, 2);
		/*
		bt.insert(1);
		bt.insert(2);
		bt.insert(4);
		bt.insert(6);
		bt.insert(7);
		bt.insert(14);
		bt.insert(9);
		bt.insert(15);
		*/
		
		//System.out.println(bt.isBST(bt.root));
		//System.out.println(bt.newIsBST(bt.root));

		/*
		bt.bstInsert(8);
		bt.bstInsert(5);
		
		bt.bstInsert(1);
		bt.bstInsert(2);
		bt.bstInsert(4);
		bt.bstInsert(6);
		bt.bstInsert(7);
		bt.bstInsert(14);
		bt.bstInsert(9);
		bt.bstInsert(15);
		
		//bt.bstInsert(7;
		//bt.bstInsert(14);
		
		*/
		/*
		bt.inorder(bt.root);
		//System.out.println("Max Value:"+bt.findMax(bt.root));
		//System.out.println("Find Value:"+bt.search(bt.root,90));
		System.out.println("Size:"+bt.size(bt.root));
		bt.levelOrder(bt.root);
		System.out.println();
		bt.levelOrderReverse(bt.root);
		System.out.println("height:"+bt.height(bt.root));
		bt.diameter(bt.root);
		System.out.println("Diamteter:"+bt.diameter);
		System.out.println("Level:"+bt.numberOfLevel(bt.root));
		
		String[] path=new String[100];
		int pathLength=0;
		bt.printPath(bt.root, path, pathLength);
		
		System.out.println("Has Sum 26:"+bt.hasSum(bt.root,3));
		System.out.println("SumAll:"+bt.sumAll(bt.root));
		System.out.println("Mirror:");
		bt.inorder((bt.mirror(bt.root)));
		System.out.println("Is Mirror:"+bt.isMirror(bt.root, bt.mirror(bt.root)));
		TreeNode<Integer> d= new TreeNode<Integer>(4);
		TreeNode<Integer> b= new TreeNode<Integer>(6);
		
		System.out.println("LCA:"+bt.LCA(bt.root,d,b).data);
		System.out.println("Ancestors:");
		
		//bt.ancestors(bt.root, d);
		
		
		System.out.println("LCA:"+bt.LCAinBST(d,b).data);
		System.out.println("isBST:"+bt.isBST(bt.root));
		
		bt.reverse(" My Name is Ayubi");
		*/
		
		//System.out.println("Zigzag");
		//bt.newZigZag(bt.root);
	}


}
/*
class DoubleLinkedList<E extends Comparable<E>> {

	DLLNode<E> head;
	
	public DoubleLinkedList(){
		head=null;
	}
	
	public DLLNode<E> addLastElement(E data){
		DLLNode<E> newNode=new DLLNode<E>(data);
		if(head == null){
			head=newNode;
		}
		else{
			DLLNode<E> temp=this.head;
			while(temp.next != null)temp=temp.next;
			
			temp.setLastNode(newNode);
		}
		return head;
	}
	
	
	public DLLNode<E> addFirstElement(E data){
		DLLNode<E> newNode=new DLLNode<E>(data);
		
		newNode.next=this.head;
		this.head.prev=newNode;
		this.head=newNode;
		
		return this.head;
	}
	
	public void printReverse(){
		DLLNode<E> temp=this.head;
		System.out.println("Reverse");
		while(temp.next != null) temp=temp.next;
		
		while(temp != null) {
			System.out.print(" "+temp.data);
			temp=temp.prev;
		
		}
	}
	
	public void printDLL(){
		DLLNode<E> temp=this.head;
		while(temp != null){
			System.out.print(" "+temp.data);
			temp=temp.next;
		}
	}
	

	public static void main(String...a){
		DoubleLinkedList<String> dll= new DoubleLinkedList<String>();
		
		dll.addLastElement("Hello1");
		dll.addLastElement("Hello2");
		dll.addLastElement("Hello3");
		dll.addLastElement("Hello4");
		
		dll.addFirstElement("Hello0");
		dll.addFirstElement("Hello-1");
		dll.addLastElement("Hello5");
		
		dll.printDLL();
		dll.printReverse();
	}

	@Override
	public String toString() {
		return "DoubleLinkedList [head=" + head + "]";
	}

	public DLLNode<E> getHead() {
		return head;
	}

	public void setHead(DLLNode<E> head) {
		this.head = head;
	}
	
}


class DLLNode<E> {

	E data;
	DLLNode<E> next;
	DLLNode<E> prev;
	
	public DLLNode(E data, DLLNode<E> next, DLLNode<E> prev) {
		super();
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	
	@Override
	public String toString() {
		return "DLLNode [data=" + data + ", next=" + next + ", prev=" + prev
				+ "]";
	}
	
	
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public DLLNode<E> getNext() {
		return next;
	}
	public void setNext(DLLNode<E> next) {
		this.next = next;
	}
	public DLLNode<E> getPrev() {
		return prev;
	}
	public void setPrev(DLLNode<E> prev) {
		this.prev = prev;
	}
	public DLLNode(E data){
		this.data=data;
		this.next=null;
		this.prev=null;
	}
	public void setPreviousNode(DLLNode<E> newNode){
		this.prev=newNode.prev;
		this.next=newNode;
		newNode.prev.next=this;
		newNode.prev=this;
		
	}
	public void setNextNode(DLLNode<E> newNode){
		newNode.next=this.next;
		this.next.prev=newNode;
		newNode.prev=this;
		this.next=newNode;
	}
	public void setLastNode(DLLNode<E> newNode){
		this.next=newNode;
		newNode.next=null;
		newNode.prev=this;
	}
	
}
*/

class Sum{
	int sum=0;
}

class Num{
	int num=0;
}