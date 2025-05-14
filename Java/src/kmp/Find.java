package kmp;

import java.util.*;

class Find {

  public static int[] buildKMPTable(String pattern) {
    int m = pattern.length();
    int[] table = new int[m];
    int pIdx = 0;

    for (int i = 1; i < m; i++) {
      while (pIdx > 0 && pattern.charAt(i) != pattern.charAt(pIdx)) {
        pIdx = table[pIdx - 1];
      }
      if (pattern.charAt(i) == pattern.charAt(pIdx)) {
        table[i] = ++pIdx;
      }
    }
    return table;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String word = sc.nextLine();    // 전체 문자열
    String pattern = sc.nextLine(); // 찾을 패턴

    int[] table = buildKMPTable(pattern);
    List<Integer> results = new ArrayList<>();
    int pIdx = 0;

    for (int i = 0; i < word.length(); i++) {
      while (pIdx > 0 && word.charAt(i) != pattern.charAt(pIdx)) {
        pIdx = table[pIdx - 1];
      }

      if (word.charAt(i) == pattern.charAt(pIdx)) {
        if (++pIdx == pattern.length()) {
          results.add(i - pattern.length() + 2);
          pIdx = table[pIdx - 1];
        }
      }
    }

    System.out.println(results.size());
    for (int pos : results) {
      System.out.print(pos + " ");
    }
  }
}
