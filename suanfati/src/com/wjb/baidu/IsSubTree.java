package com.wjb.baidu;

/**
 * 判断一棵二叉树是否是另一棵的完全子树；
 * 注意：完全子树是要：每一个结点的值和左右孩子的值都得相等。
 * 判断标准是：判断每个节点的值是否相等
 * 两个递归方法，
 * 第一个递归：遍历第一棵树，找出和第二棵树的根节点相等的节点
 * 第二个递归：以第一棵树的当前节点为子树根节点进行判等操作
 * @author wjb
 *
 */
public class IsSubTree {
	/**
	 * 初步判断，遍历root1中的所有结点，如果有满足要求的，则终止遍历
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static int isSubTree(Node root1, Node root2){
		int value = -1;
		if(root1 == null){
			
		}else if(root2 == null){
			value = 1;
		}else{
			//遍历root1树种的所有结点，每个和root2.data相等的结点都查看一下是有是子树
			if(root1.data == root2.data){
				value = test(root1, root2);
			}
			if(root1.left != null && value != 1){
				value = isSubTree(root1.left, root2);
			}
			if(root1.right != null && value != 1){
				value = isSubTree(root1.right, root2);
			}

		}
		return value;
	}
	
	/**
	 * 对于root1中的每一个和root2相等的结点，进行一次判断子树的遍历
	 * 最终返回这个相等的结点是否满足和root2是一棵值相等二叉树
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static int test(Node root1, Node root2){
		int left = 0;
		int right = 0;
		if(root1 != null && root2 != null){
			if(root1.data == root2.data){
				left = test(root1.left, root2.left);
				right = test(root1.right, root2.right);
				if((left+right) == 2){
					return 1;
				}
			}	
		}else if(root1 == null && root2 == null ){
			return 1;
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		
		Node node1 = new Node(3);
		Node node2 = new Node(8);
//		Node node3 = new Node(7);
//		Node node4 = new Node(8);
		
		node1.left = node2;
//		node1.right = node3;
//		node2.left = node4;
		
		int value = isSubTree(n1, node1);
		System.out.println(value);
		
	}
	
}
class Node {
	public int data;
	public Node left = null;
	public Node right = null;
	public Node(int data){
		this.data = data;
	}
}
