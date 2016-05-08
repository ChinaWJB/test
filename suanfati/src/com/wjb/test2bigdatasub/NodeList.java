package com.wjb.test2bigdatasub;

import linkedlist.InsertLinkList;
import linkedlist.LinkNode;

public class NodeList {
	public static Node head = null;
	public NodeList(){
		
	}
	public NodeList(Node head){
		this.head = head;
	}
	
	public void addTailNode(char d){
		Node newNode = new Node(d);
		if(head == null){
			head = newNode;
			return;
		}
		Node tempNode = head;
		while(tempNode.next!=null){
			tempNode = tempNode.next;
		}
		tempNode.next = newNode;	
		
	}
	
	public void addHeadNode(char d){
		Node newNode = new Node(d);
		if(head == null){
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;			
	}
	
	public static void main(String[] args) {
		NodeList nl = new NodeList();
		int num = 0;
		
		nl.addHeadNode('5');
		nl.addHeadNode('2');
		nl.addHeadNode('9');
		nl.addHeadNode('1');
		nl.addHeadNode('6');
		nl.addHeadNode('3');

		nl.printNode(head);
	}
	
	public static void printNode(Node headNode){
		while(headNode.next!=null){
			System.out.println("linkNode " + headNode.data); 
			headNode = headNode.next;
		}
		System.out.println("linkNode " + headNode.data);
	}
}
