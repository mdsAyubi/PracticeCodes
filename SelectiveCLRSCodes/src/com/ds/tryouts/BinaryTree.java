package com.ds.tryouts;

import java.util.ArrayList;
import java.util.Hashtable;


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
			inorder(root.left);
			
			inorder(root.right);
		}
		
	}
	public void postorder(TreeNode<E> root){
		
		if(root!=null){
		
			
			inorder(root.left);
			
			inorder(root.right);
			System.out.print(" "+root.data);
		}
		
	}
	
	public boolean search(TreeNode<E> root, E data){
		
		if(root==null) return false; 
		else{
			if(data.compareTo(root.getData())==0){
				return true;
			}
			else{
				return search(root.left,data)||search(root.right,data);
			}
		}
		
	}
	
	public int size(TreeNode<E> root){
		
		if(root==null){
			return 0;
		}
		else{
			return size(root.left)+1+size(root.right);
		}
		
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
	
	public void bstToDLL(TreeNode<E> root, DoubleLinkedList<E> head){
		
		if(root!=null){
			bstToDLL(root.left,head);
			System.out.print(" "+root.data);
			head.addLastElement(root.data);
			bstToDLL(root.right, head);
		}
		
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
	
	public static void main(String...a)throws Exception{
		BinaryTree<Integer> bt=new BinaryTree<Integer>();
		DoubleLinkedList<Integer> dll=new DoubleLinkedList<Integer>();
		Integer [] A={1,2,3,4,5};
		
		bt.bstInsert(8);
		bt.bstInsert(5);
		bt.bstInsert(6);
		bt.bstInsert(9);
		bt.bstInsert(4);
		//bt.bstInsert(10);
		//bt.bstInsert(3);
		//bt.bstInsert(7);
		
		bt.bstToDDLLDriver(bt.root);
		
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
