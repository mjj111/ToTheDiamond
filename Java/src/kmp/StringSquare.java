package kmp;

import java.util.Scanner;

public class StringSquare {

  private static int[] buildKmpTable(String pattern) {
    int N = pattern.length();
    int[] table = new int[N];

    int pIdx = 0;
    for (int i = 1; i < N; i++) {
      while (pIdx > 0 && pattern.charAt(pIdx) != pattern.charAt(i)) {
        pIdx = table[pIdx - 1];
      }
      if (pattern.charAt(pIdx) == pattern.charAt(i)) {
        pIdx++;
        table[i] = pIdx;
      }
    }
    return table;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      String pattern = sc.nextLine();
      if (pattern.equals(".")) break;

      int[] table = buildKmpTable(pattern);
      int len = pattern.length();
      int prefixLength = table[len - 1];
      int repeatLength = len - prefixLength;

      if (len % repeatLength == 0) {
        System.out.println(len / repeatLength);
      } else {
        System.out.println(1);
      }
    }
    sc.close();
  }
}
