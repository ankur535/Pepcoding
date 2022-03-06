package dsalevel1.advancedds.hashmapandheap;

import java.io.*;
import java.util.*;

public class MergeKSortedLists {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			ArrayList<Integer> list = new ArrayList<>();

			int n = Integer.parseInt(br.readLine());
			String[] elements = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				list.add(Integer.parseInt(elements[j]));
			}

			lists.add(list);
		}

		ArrayList<Integer> mlist = mergeKSortedLists(lists);
		for (int val : mlist) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	// self created Pair class and implement comparable
	public static class Pair implements Comparable<Pair> {

		int li; // list index denote list number
		int idx; // index inside a list, which is given by list index
		int data; // data value

		public Pair(int li, int idx, int data) {
			this.li = li;
			this.idx = idx;
			this.data = data;
		}

		// this method provide the sorting order and for which value
		public int compareTo(Pair other) {
			return this.data - other.data; // increasing - min priority queue
			// FYI, return other.data - this.data; -> decreasing - max priority queue
		}
	}

	public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {

		ArrayList<Integer> rv = new ArrayList<>();

		// write your code here
		PriorityQueue<Pair> pq = new PriorityQueue<>();

		// initially adding all list with index 0 data
		for (int i = 0; i < lists.size(); i++) {
			pq.add(new Pair(i, 0, lists.get(i).get(0)));
		}

		while (pq.size() > 0) {

			// retrive top element which has minnimum data
			Pair top = pq.remove();

			// add min data to result arraList
			rv.add(top.data);

			int li = top.li;
			int idx = top.idx;

			// if next idx element present for that list
			// then add that new element as replacement for top(removed) element
			if (idx + 1 < lists.get(li).size()) {
				pq.add(new Pair(li, idx + 1, lists.get(li).get(idx + 1)));
			}
		}

		return rv;
	}

}
