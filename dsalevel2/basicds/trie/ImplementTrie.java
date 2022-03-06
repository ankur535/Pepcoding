package dsalevel2.basicds.trie;

import java.io.*;

public class ImplementTrie {
	public static class Trie {
		
		public static class TrieNode {
			boolean isEnd;
			TrieNode[] children;

			public TrieNode() {
				isEnd = false;
				// 26 size for 26 (a-z) characters
				children = new TrieNode[26];
			}
		}
		
		// fixed root which just holds first char of string
		static TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		/** Inserts a word into the trie. */
		public void insert(String word) {
			//initial root node
			TrieNode temp = root;

			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				
				//if that char index for parent node children array is null, add empty node
				if (temp.children[ch - 'a'] == null) {
					temp.children[ch - 'a'] = new TrieNode();
				}

				temp = temp.children[ch - 'a'];
			}

			temp.isEnd = true;
		}

		/** Returns if the word is in the trie. */
		public boolean search(String word) {
			//initial root node
			TrieNode temp = root;

			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				
				//if that char index for parent node children array is null, means
				//string couldn't find and break in between
				if (temp.children[ch - 'a'] == null) {
					return false;
				}

				temp = temp.children[ch - 'a'];
			}
			//once end of string reached, check for isEnd of last character
			return temp.isEnd;
		}

		/**
		 * Returns if there is any word in the trie that starts with the given prefix.
		 */
		public boolean startsWith(String prefix) {
			//initial root node
			TrieNode temp = root;

			for (int i = 0; i < prefix.length(); i++) {
				char ch = prefix.charAt(i);
				
				//if that char index for parent node children array is null, means
				//starts with couldn't find and break in between
				if (temp.children[ch - 'a'] == null) {
					return false;
				}

				temp = temp.children[ch - 'a'];
			}
			//once end of string reached, means return true
			return true;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		Trie obj = new Trie();

		while (read.ready()) {
			String inp[] = read.readLine().split(" ");

			if (inp[0].equals("insert")) {
				obj.insert(inp[1]);
			} else if (inp[0].equals("search")) {
				System.out.println(obj.search(inp[1]));
			} else if (inp[0].equals("startsWith")) {
				System.out.println(obj.startsWith(inp[1]));
			}
		}

	}
}
