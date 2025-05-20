package trie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class StringSet {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    TrieNode trie = new TrieNode();

    for (int i = 0; i < N; i++) {
      String word = br.readLine();
      trie.insert(word);
    }

    int count = 0;

    for (int i = 0; i < M; i++) {
      String word = br.readLine();
      if (trie.search(word)) count++;
    }

    System.out.println(count);
  }
  static class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    void insert(String word) {
      TrieNode node = this;
      for (char c : word.toCharArray()) {
        int idx = c - 'a';
        if (node.children[idx] == null) node.children[idx] = new TrieNode();

        node = node.children[idx];
      }
      node.isEndOfWord = true;
    }

    boolean search(String word) {
      TrieNode node = this;
      for (char c : word.toCharArray()) {
        int idx = c - 'a';
        if (node.children[idx] == null) return false;

        node = node.children[idx];
      }
      return node.isEndOfWord;
    }
  }
}
