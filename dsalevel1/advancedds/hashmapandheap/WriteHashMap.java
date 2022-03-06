package dsalevel1.advancedds.hashmapandheap;

import java.io.*;
import java.util.*;

public class WriteHashMap {

	public static class HashMap<K, V> {
		private class HMNode {
			K key;
			V value;

			HMNode(K key, V value) {
				this.key = key;
				this.value = value;
			}
		}

		private int size; // n
		private LinkedList<HMNode>[] buckets; // N = buckets.length

		public HashMap() {
			initbuckets(4);
			size = 0;
		}

		@SuppressWarnings("unchecked")
		private void initbuckets(int N) {
			buckets = new LinkedList[N];
			//bucket index
			for (int bi = 0; bi < buckets.length; bi++) {
				buckets[bi] = new LinkedList<>();
			}
		}

		public int hashFunction(K key) {
			
			//hash code
			int hc = key.hashCode();
			//bucket index
			//Math.abs(hc) as hashcode can be negative
			int bi = Math.abs(hc) % buckets.length;
			
			return bi;
		}
		
		public int getKeyIndex(int bi, K key) {
			
			int idx = 0;
			
			//iterate over each node of linkedlist at bucket index bi
			for (HMNode node: buckets[bi]) {
				if (key.equals(node.key)) {
					//if node equals key, return that idx of node
					return idx;
				}
				idx++;
			}
			
			return -1;
		}
		
		public void reHash() throws Exception {
			
			LinkedList<HMNode>[] oba = buckets;
			
			//increse size of bucket to reduce lambda
			initbuckets(2*oba.length);
			size = 0;
			
			//put all nodes from old bucket array (oba) to new buckets array 
			//of double size
			for (int bi = 0; bi < oba.length; bi++) {
				for (HMNode node: oba[bi]) {
					put(node.key, node.value);
				}
			}
			
		}
		
		public void put(K key, V value) throws Exception {
			// write your code here
			
			int bi = hashFunction(key);
			int idx = getKeyIndex(bi, key);
			
			if (idx == -1) {
				//add new node to linkedlist at bi
				HMNode node = new HMNode(key, value);
				buckets[bi].addLast(node);
				size++;
			} else {
				//change value of node at idx index of linkedlist at bi
				HMNode node = buckets[bi].get(idx);
				node.value = value;
			}
			
			//calculate lambda using -  n/N
			double lambda = size*1.0 / buckets.length;
			
			//if lambda greater than a constant k, rehash it to avoid TLE error
			//TLE - Time Limit Exceeded
			if (lambda > 2.0) {
				reHash();
			}
			
		}

		public V get(K key) throws Exception {
			// write your code here
			int bi = hashFunction(key);
			int idx = getKeyIndex(bi, key);
			
			//if idx is found return that node value, else null
			if (idx == -1) {
				return null;
			} else {
				HMNode node = buckets[bi].get(idx);
				return node.value;
			}
		}

		public boolean containsKey(K key) {
			// write your code here
			int bi = hashFunction(key);
			int idx = getKeyIndex(bi, key);
			
			//if idx is found, means node/(K,V) pair exist, so true else false
			if (idx == -1) {
				return false;
			} else {
				return true;
			}
		}

		public V remove(K key) throws Exception {
			// write your code here
			int bi = hashFunction(key);
			int idx = getKeyIndex(bi, key);
			
			//if node exists, remove it using idx index and return value
			if (idx == -1) {
				return null;
			} else {
				HMNode node = buckets[bi].remove(idx);
				size--;
				return node.value;
			}
		}

		public ArrayList<K> keyset() throws Exception {
			// write your code here
			ArrayList<K> ans = new ArrayList<>();
			
			//iterate over each node from all the linkedlist
			//and insert key in arraylist
			for (int bi = 0; bi < buckets.length; bi++) {
				for (HMNode node: buckets[bi]) {
					ans.add(node.key);
				}
			}
			
			return ans;			
		}

		public int size() {
			// write your code here
			return size;
		}

		public void display() {
			System.out.println("Display Begins");
			for (int bi = 0; bi < buckets.length; bi++) {
				System.out.print("Bucket" + bi + " ");
				for (HMNode node : buckets[bi]) {
					System.out.print(node.key + "@" + node.value + " ");
				}
				System.out.println(".");
			}
			System.out.println("Display Ends");
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		String str = br.readLine();
		while (str.equals("quit") == false) {
			if (str.startsWith("put")) {
				String[] parts = str.split(" ");
				String key = parts[1];
				Integer val = Integer.parseInt(parts[2]);
				map.put(key, val);
			} else if (str.startsWith("get")) {
				String[] parts = str.split(" ");
				String key = parts[1];
				System.out.println(map.get(key));
			} else if (str.startsWith("containsKey")) {
				String[] parts = str.split(" ");
				String key = parts[1];
				System.out.println(map.containsKey(key));
			} else if (str.startsWith("remove")) {
				String[] parts = str.split(" ");
				String key = parts[1];
				System.out.println(map.remove(key));
			} else if (str.startsWith("size")) {
				System.out.println(map.size());
			} else if (str.startsWith("keyset")) {
				System.out.println(map.keyset());
			} else if (str.startsWith("display")) {
				map.display();
			}
			str = br.readLine();
		}
	}
}