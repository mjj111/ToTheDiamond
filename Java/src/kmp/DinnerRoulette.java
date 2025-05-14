package kmp;

import java.util.*;

public class DinnerRoulette {
  static int[] buildKmp(String pattern) {
    int[] table = new int[pattern.length()];
    int pIdx = 0;
    for (int i = 1; i < pattern.length(); i++) {
      while (pIdx > 0 && pattern.charAt(i) != pattern.charAt(pIdx)) {
        pIdx = table[pIdx - 1];
      }
      if (pattern.charAt(i) == pattern.charAt(pIdx)) {
        pIdx++;
        table[i] = pIdx;
      }
    }
    return table;
  }

  static int kmpMatch(String text, String pattern, int N) {
    int[] table = buildKmp(pattern);
    int pIdx = 0;
    int count = 0;

    for (int i = 0; i < text.length(); i++) {
      while (pIdx > 0 && text.charAt(i) != pattern.charAt(pIdx)) {
        pIdx = table[pIdx - 1];
      }

      if (text.charAt(i) == pattern.charAt(pIdx)) {
        pIdx++;

        if (pIdx == pattern.length()) {
          if (i - pattern.length() + 1 < N) {
            count++;
          }
          pIdx = table[pIdx - 1];
        }
      }
    }
    return count;
  }

  static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = Integer.parseInt(sc.nextLine());

    String[] targetArr = sc.nextLine().split(" ");
    String[] rouletteArr = sc.nextLine().split(" ");

    String target = String.join("", targetArr);
    String roulette = String.join("", rouletteArr);
    String doubled = roulette + roulette;

    int matchCount = kmpMatch(doubled, target, N);
    int g = gcd(matchCount, N);
    System.out.printf("%d/%d\n", matchCount / g, N / g);
  }
}

