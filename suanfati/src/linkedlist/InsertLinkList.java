package linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InsertLinkList {
	
	private static LinkNode head = null;
	
	public void addNode(int d){
		LinkNode newNode = new LinkNode(d);
		if(head == null){
			head = newNode;
			return;
		}
		LinkNode tempNode = head;
		while(tempNode.next!=null){
			tempNode = tempNode.next;
		}
		tempNode.next = newNode;			
	}
	
	public void printNode(LinkNode headNode){
		while(headNode.next!=null){
			System.out.println("linkNode " + headNode.data); 
			headNode = headNode.next;
		}
		System.out.println("linkNode " + headNode.data);
	}
	
	public void insertNode(int index, int d){
		if(index < 0){
			throw new RuntimeException("无效的下标！");
		}
		LinkNode newNode = new LinkNode(d);
		LinkNode tmp = head;
		for(int i=1; i<index; i++){
			tmp = tmp.next;
			if(tmp == null){
				throw new RuntimeException("无效的下标！");
			}
		}
		newNode.next = tmp.next;
		tmp.next = newNode;
	}
	
	public void deleteNode(int index, LinkNode temphead){
		if(index < 0){
			throw new RuntimeException("无效的下标！");
		}
		if(index == 0){
			throw new RuntimeException("不删除！");
		}
		if(index == 1){
			head = head.next;
		}
		for(int i=1; i<index-1; i++){
			temphead = temphead.next;
		}
		if(temphead.next.next == null){
			temphead.next = null;
		}else{
			temphead.next = temphead.next.next;
		}		
	}
	
	/**
	 * 链表排序
	 * @param temphead
	 */
	public void orderNode(LinkNode temphead){
		LinkNode head0 = temphead;
		LinkNode tail0 = temphead.next;
		int min = head0.data;
		while(head0.next != null){
			while(tail0 != null){
				if(min > tail0.data){					
					head0.data = tail0.data;
					tail0.data = min;
					min = head0.data;
				}
				tail0 = tail0.next;
			}

			head0 = head0.next;
			tail0 = head0.next;
			min = head0.data;
		}

	}
	
	/**
	 * 删除链表中重复的数据
	 * 需要额外的空间存储遍历的值
	 * @param head
	 */
	public void deleteDuplecate(LinkNode head){
		Map<Integer, Integer> map = new HashMap();
		LinkNode temp = head;
		LinkNode temp0 = head;
		while(temp != null){			
			if((map.get(temp.data) != null) && (temp.next != null)){				
				temp0.next = temp.next;
				temp = temp0.next;
			}else if((map.get(temp.data) != null) && (temp.next == null)){
				temp0.next = temp.next;
				return;
			}else{
				map.put(temp.data, 1);
				temp0 = temp;
				temp = temp.next;
			}
		}		
	}
	
	/**
	 * 删除链表中重复的数据
	 * 不增加额外的存储空间
	 * 时间复杂度较高
	 * @param head
	 */
	public void deleteDuplecate2(LinkNode head){
		LinkNode p = head;
		LinkNode q = head;
		while(p != null){
			q = p;
			while(q.next != null){
				if(q.next.data == p.data){
					q.next = q.next.next;
				}else{
					q = q.next;
				}
			}
			p = p.next;
		}
	}
	
	/**
	 * 找出链表倒数第K个元素
	 * @param headtemp
	 * @param index
	 * @return
	 */
	public LinkNode findLastKNode(LinkNode headtemp, int index){
		LinkNode kheadtemp = headtemp;
		if (index < 1){
			throw new RuntimeException("给定的index无效");
		}
		for(int i=0; i<index-1; i++){			
			if(kheadtemp.next == null){
				throw new RuntimeException("链表长度小于给定的值"); 
			}
			kheadtemp = kheadtemp.next;
		}
		while(kheadtemp.next != null){
			headtemp = headtemp.next;
			kheadtemp = kheadtemp.next;
		}
		return headtemp;
	}
	
	/**
	 * 实现链表的反转
	 * @param temphead
	 * @return
	 */
	public LinkNode reverseNode(LinkNode temphead){
		LinkNode p = temphead;
		LinkNode q = temphead.next;
		if(temphead.next == null){
			throw new RuntimeException("只有一个节点！！！");
		}
		while(q != null){
			temphead.next = q.next;
			q.next = p;
			p = q;
			q = temphead.next;						
		}
		return p;
	}
	
	/**
	 * 从尾到头输出单链表
	 * 递归方式实现
	 * 通过递归方式实现栈的功能
	 * @param head
	 */
	public void printListReversely(LinkNode head){
		if(head == null){
			return;
		}
		printListReversely(head.next);
		System.out.println(head.data);
	}
	
	/**
	 * 输出链表的中间节点
	 * 		奇数时，输出一个
	 * 		偶数时，输出两个
	 * @param head
	 * @return
	 */
	public ArrayList<LinkNode> SearchMid(LinkNode head){
		LinkNode p = head;
		LinkNode q = head;
		ArrayList<LinkNode> al = new ArrayList<>();
		while(q != null && q.next != null && q.next.next != null){
			p = p.next;
			q = q.next.next;
		}
		if(q.next == null){
			al.add(p);
		}else if((q.next != null) && (q.next.next == null)){
			al.add(p);
			al.add(p.next);
		}
		return al;	
	}
	
	/**
	 * 判断一个链表是否有环
	 * @param head
	 * @return
	 */
	public boolean IsLoop(LinkNode head){
		LinkNode fast = head;
		LinkNode slow = head;
		if(fast == null || fast.next == null){
			return false;
		}
		while((fast != null) &&(fast.next != null)){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				return true;
			}
		}
		return !((fast == null)||(fast.next == null));
	}
	
	/**
	 * 在不知道头结点的情况下删除一个节点
	 * 如果该节点是尾节点，那无法删除
	 * @param node
	 * @return
	 */
	public boolean deleteNode2(LinkNode node){
		if(node == null && node.next == null){
			return false;
		}
		int temp = 0;
		temp = node.data;
		node.data = node.next.data;
		node.next.data = temp;
		node.next = node.next.next;
		return true;
	}
	
	public static void main(String[] args) {
		InsertLinkList ill = new InsertLinkList();
		int num = 0;
		
		ill.addNode(5);
		ill.addNode(2);
		ill.addNode(9);
		ill.addNode(18);
		ill.addNode(45);
		ill.addNode(3);
		ill.addNode(1);
		ill.addNode(14);
		
		ill.printNode(head);
				
//		System.out.println("————————插入index之后————————");
//		ill.insertNode(6, 13);
//		ill.printNode(head);
		
//		System.out.println("————————删除index之后————————");
//		ill.deleteNode(8, head);
//		ill.printNode(head);
		
//		System.out.println("————————删除重复的节点之后————————");
//		ill.deleteDuplecate2(head);
//		ill.printNode(head);
		
		System.out.println("————————排序之后————————");
		ill.orderNode(head);
		ill.printNode(head);
		
		System.out.println("————————输出倒数第index个————————");
		LinkNode temp = ill.findLastKNode(head, 2);
		System.out.println(temp.data);
		
//		System.out.println("————————反转之后————————");
//		head = ill.reverseNode(head);
//		ill.printNode(head);
//		
//		System.out.println("————————从尾到头输出————————");
//		ill.printListReversely(head);
//		
//		System.out.println("————————输出中间值————————");
//		ArrayList<LinkNode> all = new ArrayList<>();
//		all = ill.SearchMid(head);
//		for(int i=0; i<all.size(); i++){
//			LinkNode node = (LinkNode)all.get(i);
//			System.out.println(node.data);
//		}
//		
//		System.out.println("————————判断链表是否有环————————");
//		System.out.println(ill.IsLoop(head));
		
		System.out.println("————————不知道头结点的情况下删除节点————————");
		boolean b = ill.deleteNode2(temp);
		System.out.println(b);
		ill.printNode(head);
		
	}
}
