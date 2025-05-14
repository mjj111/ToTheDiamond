package kmp;

import java.util.Scanner;

public class Advertisement {
  public static int getMinAdLength(String s) {
    int n = s.length();
    int[] pi = new int[n];
    int j = 0;

    for (int i = 1; i < n; i++) {
      while (j > 0 && s.charAt(i) != s.charAt(j)) {
        j = pi[j - 1];
      }
      if (s.charAt(i) == s.charAt(j)) {
        pi[i] = ++j;
      }
    }
    for(int i : pi) System.out.print(i + " ");
    return n - pi[n - 1];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int L = sc.nextInt();
    String str = sc.next();

    int result = getMinAdLength(str);
    System.out.println(result);
  }
}
