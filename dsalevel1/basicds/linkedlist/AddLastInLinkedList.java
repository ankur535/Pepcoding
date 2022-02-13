package dsalevel1.basicds.linkedlist;

import java.io.*;

public class AddLastInLinkedList {

	public static class Node {
	    int data;
	    Node next;
	  }

	  public static class LinkedList {
	    Node head;
	    Node tail;
	    int size;

	    void addLast(int val) {
	    	Node temp = new Node();
	    	temp.data = val;
	    	
	    	if (size == 0) { // means head and tail is null
	    		//if No node is present, create 1 and assign head and tail to it
	    		head = temp;
	    		tail = temp;
	    	} else {
	    		//if nodes are present, create a new one and assign tail next to it and
				//then tail to the last node.
	    		tail.next = temp;
	    		tail = temp;
	    	}
	    	size++;
	    }
	  }

	  public static void testList(LinkedList list) {
	    for (Node temp = list.head; temp != null; temp = temp.next) {
	      System.out.println(temp.data);
	    }
	    System.out.println(list.size);

	    if (list.size > 0) {
	      System.out.println(list.tail.data);
	    } 
	  }
	  public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    LinkedList list = new LinkedList();

	    String str = br.readLine();
	    while(str.equals("quit") == false){
	      if(str.startsWith("addLast")){
	        int val = Integer.parseInt(str.split(" ")[1]);
	        list.addLast(val);
	      } 
	      str = br.readLine();
	    }

	    testList(list);
	  }
}
