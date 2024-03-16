package dsalevel2.basicds.trie;

import java.io.*;

public class DesginAddAndSearchWordsDataStructure {
	public static class WordDictionary {

		public static class TrieNode {
			boolean isEnd;
			TrieNode[] children;

			public TrieNode() {
				isEnd = false;
				children = new TrieNode[26];
			}
		}

		TrieNode root;

		public WordDictionary() {
			root = new TrieNode();
		}

		/** Adds a word into the data structure. */
		public void addWord(String word) {

			TrieNode node = root;

			for (int i = 0; i < word.length(); i++) {
				int index = word.charAt(i) - 'a';

				if (node.children[index] == null) {
					node.children[index] = new TrieNode();
				}

				node = node.children[index];
			}

			node.isEnd = true;

		}

		public static boolean find(TrieNode node, String word, int idx) {

			// once idx reaches end of string, check for isEnd
			if (idx == word.length()) {
				return node.isEnd;
			}

			char ch = word.charAt(idx);

			if (ch == '.') {
				// call only for 26 times as size of array is only 26
				for (int i = 0; i < 26; i++) {
					// if children not null, check inside that child node with remaining string
					if (node.children[i] != null) {
						boolean ans = find(node.children[i], word, idx + 1);
						// if got ans true anytime, return it
						if (ans == true)
							return ans;
					}
				}

				// if true not returned from inside means string didn't match, return false
				return false;
			} else {
				int index = ch - 'a';
				// if a character, then if it char index at array is null, return false
				if (node.children[index] == null)
					return false;

				// call for recursion with new temp and idx
				node = node.children[index];
				return find(node, word, idx + 1);
			}

		}

		/**
		 * Returns if the word is in the data structure. A word could contain the dot
		 * character ''.'' to represent any one letter.
		 */
		public boolean search(String word) {

			TrieNode node = root;
			return find(node, word, 0);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		WordDictionary obj = new WordDictionary();

		while (read.ready()) {
			String inp[] = read.readLine().split(" ");

			if (inp[0].equals("addWord")) {
				obj.addWord(inp[1]);
			} else if (inp[0].equals("search")) {
				System.out.println(obj.search(inp[1]));
			}
		}

	}
}
