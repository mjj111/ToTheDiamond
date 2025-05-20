package trie;

import java.util.*;

class FindPrefix {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    sc.nextLine();

    Trie trie = new Trie();
    for (int i = 0; i < N; i++) trie.insert(sc.nextLine());

    int count = 0;
    for (int i = 0; i < M; i++) {
      String word = sc.nextLine();
      if (trie.isPrefixOfAny(word)) count++;
    }

    System.out.println(count);
  }

  static class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord;
  }

  static class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word) {
      TrieNode node = root;
      for (char c : word.toCharArray()) {
        node = node.children.computeIfAbsent(c, k -> new TrieNode());
      }

      node.isEndOfWord = true;
    }

    public boolean isPrefixOfAny(String prefix) {
      TrieNode node = root;
      for (char c : prefix.toCharArray()) {
        if (!node.children.containsKey(c)) return false;
        node = node.children.get(c);
      }

      return true;
    }
  }
}