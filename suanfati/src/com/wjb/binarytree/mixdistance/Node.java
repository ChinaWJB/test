package com.wjb.binarytree.mixdistance;

public class Node {
	public int data;
	public Node left;
	public Node right;
	public int leftMaxDistance;	//左子树距根节点的 最大距离
	public int rightMaxDistance;//右子树距根节点的最大距离
	public Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
