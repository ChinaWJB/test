package com.wjb.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	private Node root;
	public BinaryTree(){
		root = null;
	}
	/**
	 * 循环插入法，构建二叉查找树
	 * @param data
	 */
	public void insert(int data){
		Node newNode = new Node(data);
		if(root == null){
			root = newNode;
		}else{
			Node current = root;
			Node parent;		//为了给newNode赋值用的，每次经过while时parent都是current的父节点
			while(true){
				parent = current;	//很关键，在遍历某节点的左右孩子时，父节点可以随时备用
				if(data<current.data){
					current = current.left;
					if(current == null){	//因为curent用于判断是否为空了，此时parent为current的父节点
						parent.left = newNode;
						return;
					}
				}else{
					current = current.right;
					if(current == null){
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}
	
    /** 
     * 递归创建二叉查找树 
     * @param node 
     * @param data 
     */  
    public void buildTree(Node node,int data){  
        if(root == null){  
            root = new Node(data);  
        }else{  
            if(data < node.data){  
                if(node.left == null){  
                    node.left = new Node(data);  
                }else{  
                    buildTree(node.left,data);  
                }  
            }else{  
                if(node.right == null){  
                    node.right = new Node(data);  
                }else{  
                    buildTree(node.right,data);  
                }  
            }  
        }  
    }
	
	/**
	 * 将数值输入构建二叉树，
	 * 创建二叉查找树
	 * @param data
	 */
	public void buildTree(int[] data){
		for(int i=0; i<data.length; i++){
			insert(data[i]);
		}
	}
	
	/**
	 * 先序遍历，递归实现
	 * @param localRoot
	 */
	public void preOrder(Node localRoot){
		if(localRoot != null){
			System.out.print(localRoot.data + " ");
			preOrder(localRoot.left);
			preOrder(localRoot.right);
		}
	}
	public void preOrder(){
		this.preOrder(this.root);
	}
	
	/**
	 * 中序遍历，递归实现
	 * @param localRoot
	 */
	public void inOrder(Node localRoot){
		if(localRoot != null){			
			inOrder(localRoot.left);
			System.out.print(localRoot.data + " ");
			inOrder(localRoot.right);
		}
	}
	public void inOrder(){
		this.inOrder(this.root);
	}
	
	/**
	 * 后序遍历，递归实现
	 * @param localRoot
	 */
	public void postOrder(Node localRoot){
		if(localRoot != null){
			postOrder(localRoot.left);
			postOrder(localRoot.right);
			System.out.print(localRoot.data + " ");
		}
	}
	public void postOrder(){
		this.postOrder(this.root);
	}
	
	/**
	 * 逐层遍历一颗二叉树，利用队列。
	 * 先将根节点插入队列，然后进入while循环，每pull一个出来，就将其左右孩子添加到队列
	 */
	public void layerTranverse(){
		if(this.root == null){
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(this.root);
		while(!q.isEmpty()){
			Node n = q.poll();
			System.out.print(n.data);
			System.out.print(" ");
			if(n.left != null){
				q.add(n.left);
			}
			if(n.right != null){
				q.add(n.right);
			}
		}
	}
	
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
//		int[] data = {15,4,3,10,45,13,24};
		int[] data = {2,8,7,4,9,3,1,6,7,5};
		bt.buildTree(data);
		bt.preOrder();
		bt.layerTranverse();
	}
}
