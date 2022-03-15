package dsalevel2.advancedds.hashmapandheap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class LRUCache {
	public static class LRU {
		
		// Doubly Linked List node
		public static class Node {
			int key;
			int value;
			Node prev;
			Node next;

			public Node (int key, int value) {
				this.key= key;
				this.value = value;
			}
		}
		
		Node head = null;
		Node tail = null;
		int size = 0;
		
		public void addLast (Node node) {
			
			if (this.size == 0) {
				head = tail = node;
			} else {
				// add to Last of doubly linked list
				tail.next = node;
				node.prev = tail;
				tail = node;
				// as if we add old node back to Last, it should remove its next pointer
				tail.next = null;
			}
			size++;
		}
		
		public void remove (Node node) {
			
			if (this.size == 1) {
				head = tail = null;
			} else if (head == node) {
				// if head, move head ahead and remove dangling pointers
				head = head.next;
				head.prev = null;
				node.next = null;
			} else if (tail == node) {
				// if tail, move tail back and remove dangling pointers
				tail = tail.prev;
				tail.next = null;
				node.prev = null;
			} else {
				// if in between, set prev and next to each other and remove
				// that node pointers
				Node cnode_prev = node.prev;
				Node cnode_next = node.next;
				
				cnode_prev.next = cnode_next;
				cnode_next.prev = cnode_prev;
				
				node.next = null;
				node.prev = null;	
			}
			size--;			
		}
		
		int maxSize;
		//map to help getting key node in O(1)
		HashMap<Integer, Node> map;
		
		public LRU(int capacity) {
			maxSize = capacity;
			map = new HashMap<>();
		}

		public int get(int key) {

			if (!map.containsKey(key)) {
				return -1;
			}
			
			Node node = map.get(key);
			
			//remove that node from LL
			remove(node);
			//And add to Last of Linked list
			addLast(node);
			//Node changes in map, as no deletion or addition happend on new data

			
			return node.value;
		}

		public void put(int key, int value) {

			if (!map.containsKey(key)) {
				//if map doesn't consist, add new node to last of LL and also in map
				Node node = new Node(key, value);
				
				addLast(node);
				map.put(key, node);
				
				//if after adding new node, size is more
				//remove head which will be the least recently used node
				if (size > maxSize) { // Remove Least recently used
					Node tr = head;
					remove(tr);
					map.remove(tr.key);
				}
			} else {
				//get call is important, as on put also, 
				//that key node becomes recently used, so put in last of LL
				int val = get(key);
				
				//if val is differeent than update it
				if (val != value) {
					Node node = map.get(key);
					node.value = value;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		LRU obj = new LRU(Integer.parseInt(str.split(" ")[1]));

		while (true) {
			str = br.readLine();
			String inp[] = str.split(" ");
			if (inp.length == 1) {
				break;
			} else if (inp.length == 2) {
				System.out.println(obj.get(Integer.parseInt(inp[1])));
			} else if (inp.length == 3) {
				obj.put(Integer.parseInt(inp[1]), Integer.parseInt(inp[2]));
			}
		}
	}
}
