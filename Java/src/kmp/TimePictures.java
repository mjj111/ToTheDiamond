package kmp;

import java.util.Arrays;
import java.util.Scanner;


public class TimePictures {
  static final int FULL_CIRCLE = 360000;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] clock1 = new int[n];
    int[] clock2 = new int[n];

    for (int i = 0; i < n; i++) clock1[i] = sc.nextInt();
    for (int i = 0; i < n; i++) clock2[i] = sc.nextInt();

    Arrays.sort(clock1);
    Arrays.sort(clock2);

    int[] diff1 = buildDiff(clock1);
    int[] diff2 = buildDiff(clock2);

    int[] doubleDiff1 = new int[diff1.length * 2];
    for (int i = 0; i < diff1.length; i++) {
      doubleDiff1[i] = doubleDiff1[i + diff1.length] = diff1[i];
    }

    if (kmp(doubleDiff1, diff2)) {
      System.out.println("possible");
    } else {
      System.out.println("impossible");
    }
  }

  static int[] buildDiff(int[] clock) {
    int n = clock.length;
    int[] diff = new int[n];

    for (int i = 0; i < n; i++) {
      int next = clock[(i + 1) % n];
      int curr = clock[i];
      diff[i] = (next - curr + FULL_CIRCLE) % FULL_CIRCLE;
    }

    return diff;
  }

  static int[] buildKMPTable(int[] pattern) {
    int[] table = new int[pattern.length];
    int pIdx = 0;

    for (int i = 1; i < pattern.length; i++) {
      while (pIdx > 0 && pattern[i] != pattern[pIdx]) {
        pIdx = table[pIdx - 1];
      }

      if (pattern[i] == pattern[pIdx]) {
        pIdx++;
        table[i] = pIdx;
      }
    }
    return table;
  }

  static boolean kmp(int[] text, int[] pattern) {
    int[] table = buildKMPTable(pattern);
    int pIdx = 0;

    for (int i = 0; i < text.length; i++) {
      while (pIdx > 0 && text[i] != pattern[pIdx]) {
        pIdx = table[pIdx - 1];
      }

      if (text[i] == pattern[pIdx]) {
        pIdx++;
        if (pIdx == pattern.length) return true;
      }
    }
    return false;
  }
}

