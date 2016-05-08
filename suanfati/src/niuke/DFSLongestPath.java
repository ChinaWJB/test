package niuke;
/**
 * 题目

    对于一棵由黑白点组成的二叉树，我们需要找到其中最长的单色简单路径，
    其中简单路径的定义是从树上的某点开始沿树边走不重复的点到树上的另一点结束而形成的路径，而路径的长度就是经过的点的数量(包括起点和终点)。
    而这里我们所说的单色路径自然就是只经过一种颜色的点的路径。你需要找到这棵树上最长的单色路径。
    给定一棵二叉树的根节点(树的点数小于等于300，请做到O(n)的复杂度)，请返回最长单色路径的长度。
    这里的节点颜色由点上的权值表示，权值为1的是黑点，为0的是白点。

 * 深度遍历二叉树，每个结点颜色不同，白色代表0，黑色代表1，找出连续最长的节点数
 * @author wjb
 *
 */
public class DFSLongestPath {
	public int max = 1;
	
	/**
	 * 测试构建二叉查找树
	 * @param root
	 * @param value
	 */
	public void addNode(Node root, int value){
		Node node = new Node(value);
		if(root == null){
			root = node;
			return ;
		}
		Node current = root;
		Node parent;
		while(true){			
			parent = current;
			if(value < current.val){
				current = current.left;
				if(current == null){
					current.left = node;
					return;
				}
			}else{
				current = current.right;
				if(current == null){
					current.right = node;
					return;
				}
			}
		}
		
	}
	
	/**
	 * 测试
	 * 深度优先遍历二叉树
	 * @param node
	 */
	public void deepTravel(Node node){
		System.out.println(node.val);
		if(node.left != null){
			deepTravel(node.left);
		}
		if(node.right != null){
			deepTravel(node.right);
		}
	}
	
	/**
	 * 主要实现方法
	 * @param node
	 * @param color
	 * @param len
	 */
	public void travel(Node node, int val, int len){
		System.out.println(val);
		int l = 1;
		if(node.val == val){
			l = len+1;
		}
		if(max<l){
			max = l;
		}
		if(node.left != null){
			travel(node.left, node.val, l);
		}
		if(node.right != null){
			travel(node.right, node.val, l);
		}
	}	
	
	
	public static void main(String[] args) {
		DFSLongestPath t = new DFSLongestPath();
		Node n1 = new Node(0);
		Node n2 = new Node(1);
		Node n3 = new Node(0);
		Node n4 = new Node(0);
		Node n5 = new Node(0);
		Node n6 = new Node(1);
		Node n7 = new Node(0);
		Node n8 = new Node(1);
		Node n9 = new Node(0);
		Node n10 = new Node(0);
		Node n11 = new Node(0);
		Node n12 = new Node(1);
		Node n13 = new Node(0);
		Node n14 = new Node(0);
		
//		Node n1 = new Node(1);
//		Node n2 = new Node(2);
//		Node n3 = new Node(3);
//		Node n4 = new Node(4);
//		Node n5 = new Node(5);
//		Node n6 = new Node(6);
//		Node n7 = new Node(7);
//		Node n8 = new Node(8);
//		Node n9 = new Node(9);
//		Node n10 = new Node(10);
//		Node n11 = new Node(11);
//		Node n12 = new Node(12);
//		Node n13 = new Node(13);
//		Node n14 = new Node(14);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n4.left = n8;
		n4.right = n9;
		n5.left = n10;
		n5.right = n11;
		n6.left = n12;
		n6.right = n13;
		n7.left = n14;	
		
		t.travel(n1, n1.val, 0);
		System.out.println(t.max);
		
		
//		t.deepTravel(n1);
	}
	
}
class Node {
	int val = 0;
	Node left = null;
	Node right = null;
	Node(int val){
		this.val = val;
	}
}
