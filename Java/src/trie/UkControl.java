package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UkControl {
  static final int MX = 1000;
  static int[][] nxt = new int[MX][2];
  static boolean[] chk = new boolean[MX];
  static int root = 1, unused = 2;
  static boolean success;
  static String successStr;
  static List<int[]> v = new ArrayList<>();
  static Map<Integer, String> resultMap = new HashMap<>();

  static int c2i(char c) {
    return c - '0';
  }

  static void initiate() {
    for (int i = 0; i < MX; i++) {
      Arrays.fill(nxt[i], -1);
    }
  }

  static void insert(String s) {
    int cur = root;
    for (char c : s.toCharArray()) {
      int idx = c2i(c);
      if (nxt[cur][idx] == -1) {
        nxt[cur][idx] = unused++;
      }
      cur = nxt[cur][idx];
    }
    chk[cur] = true;
  }

  static boolean find(String s) {
    int cur = root;
    for (char c : s.toCharArray()) {
      int idx = c2i(c);
      if (nxt[cur][idx] == -1)
        return false;
      cur = nxt[cur][idx];
    }
    return chk[cur];
  }

  static void dfs(int len, String s) {
    if (success) return;

    if (s.length() == len) {
      insert(s);
      success = true;
      successStr = s;
      return;
    }

    String s0 = s + '0';
    if (!find(s0)) dfs(len, s0);
    if (success) return;

    String s1 = s + '1';
    if (!find(s1)) dfs(len, s1);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    initiate();

    for (int i = 0; i < n; i++) {
      int len = sc.nextInt();
      v.add(new int[]{len, i});
    }

    // 길이 기준으로 정렬 (짧은 문자열부터 우선 배정)
    v.sort(Comparator.comparingInt(a -> a[0]));

    for (int[] pair : v) {
      int len = pair[0], idx = pair[1];
      success = false;
      dfs(len, "");
      if (!success) {
        System.out.println("-1");
        return;
      }
      resultMap.put(idx, successStr);
    }

    System.out.println("1");
    for (int i = 0; i < n; i++) {
      System.out.println(resultMap.get(i));
    }
  }
}