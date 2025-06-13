package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MobilePhoneKeyboard {
  static final int ROOT = 1, MX = 1000010;
  static int unused, keystrokeTotal;
  static boolean[] chk = new boolean[MX];

  static List<Pair>[] nxt = new ArrayList[MX];

  static class Pair {
    int id;
    char ch;

    Pair(int id, char ch) {
      this.id = id;
      this.ch = ch;
    }
  }

  static int getChild(int node, char c) {
    for (Pair p : nxt[node]) {
      if (p.ch == c) return p.id;
    }
    return -1;
  }

  static void insert(String s) {
    int curr = ROOT;
    for (char c : s.toCharArray()) {
      int child = getChild(curr, c);
      if (child == -1) {
        child = unused;
        nxt[curr].add(new Pair(unused++, c));
      }
      curr = child;
    }
    chk[curr] = true;
  }

  static void dfs(int curr, int keyStrokes) {
    if (chk[curr]) keystrokeTotal += ++keyStrokes;
    else if (nxt[curr].size() > 1) keyStrokes++;

    for (Pair p : nxt[curr]) {
      dfs(p.id, keyStrokes);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNextInt()) {
      int N = sc.nextInt();

      for (int i = 0; i < MX; i++) {
        if (nxt[i] == null) nxt[i] = new ArrayList<>();
        else nxt[i].clear();
      }
      Arrays.fill(chk, false);
      unused = ROOT + 1;
      keystrokeTotal = 0;

      String[] words = new String[N];
      for (int i = 0; i < N; i++) {
        words[i] = sc.next();
        insert(words[i]);
      }

      for (Pair p : nxt[ROOT]) {
        dfs(p.id, 0);
      }

      System.out.printf("%.2f\n", (double) keystrokeTotal / N);
    }
  }
}