package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CapacityShortage {
  static final int MX = 20000 * 2 + 2;
  static final int ROOT = 1;

  static int n, unused;
  static ArrayList<Pair>[] trie = new ArrayList[MX];
  static boolean[] isWildcardApplicable = new boolean[MX];
  static boolean[] chk = new boolean[MX];

  static class Pair {
    char c;
    int nxt;

    Pair(char c, int nxt) {
      this.c = c;
      this.nxt = nxt;
    }
  }

  public static int find(char c, int cur) {
    for (Pair p : trie[cur]) {
      if (p.c == c) return p.nxt;
    }
    return -1;
  }

  public static void insert(String s, boolean isCode) {
    int cur = ROOT;
    isWildcardApplicable[ROOT] = isCode;
    for (char c : s.toCharArray()) {
      int nxt = find(c, cur);
      if (nxt == -1) {
        nxt = unused;
        trie[cur].add(new Pair(c, unused++));
      }
      isWildcardApplicable[nxt] = isCode;
      cur = nxt;
    }
    chk[cur] = isCode;
  }

  public static int search(int cur) {
    if (isWildcardApplicable[cur]) return 1;

    int res = chk[cur] ? 1 : 0;
    for (Pair p : trie[cur]) {
      res += search(p.nxt);
    }
    return res;
  }

  public static void solve(Scanner sc) {
    Arrays.fill(isWildcardApplicable, false);
    Arrays.fill(chk, false);
    unused = 2;

    for (int i = ROOT; i < MX; i++) {
      trie[i] = new ArrayList<>();
    }

    n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      String s = sc.next();
      insert(s, true);
    }

    n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      String s = sc.next();
      insert(s, false);
    }

    int ans = search(ROOT);
    System.out.println(ans);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      solve(sc);
    }
  }
}