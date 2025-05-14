package kmp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SizerPassword {
  public static int[] buildKMPTable(String pattern) {
    int m = pattern.length();
    int[] table = new int[m];
    int j = 0;
    for (int i = 1; i < m; i++) {
      while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
        j = table[j - 1];
      }
      if (pattern.charAt(i) == pattern.charAt(j)) {
        table[i] = ++j;
      }
    }
    return table;
  }

  public static int countOccurrences(String text, String pattern, int[] table) {
    int count = 0;
    int j = 0;
    for (int i = 0; i < text.length(); i++) {
      while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
        j = table[j - 1];
      }
      if (text.charAt(i) == pattern.charAt(j)) {
        if (++j == pattern.length()) {
          count++;
          j = table[j - 1];
        }
      }
    }
    return count;
  }

  public static String decrypt(String cipher, Map<Character, Integer> charToIndex, char[] indexToChar, int shift, int len) {
    StringBuilder sb = new StringBuilder();
    for (char c : cipher.toCharArray()) {
      int idx = (charToIndex.get(c) - shift + len) % len;
      sb.append(indexToChar[idx]);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = Integer.parseInt(sc.nextLine());
    while (T-- > 0) {
      String A = sc.nextLine();
      String W = sc.nextLine();
      String S = sc.nextLine();

      int len = A.length();
      Map<Character, Integer> charToIndex = new HashMap<>();
      char[] indexToChar = new char[len];
      for (int i = 0; i < len; i++) {
        char c = A.charAt(i);
        charToIndex.put(c, i);
        indexToChar[i] = c;
      }

      int[] kmpTable = buildKMPTable(W);
      List<Integer> validShifts = new ArrayList<>();

      for (int shift = 0; shift < len; shift++) {
        String decrypted = decrypt(S, charToIndex, indexToChar, shift, len);
        int occurrences = countOccurrences(decrypted, W, kmpTable);
        if (occurrences == 1) {
          validShifts.add(shift);
        }
      }

      if (validShifts.isEmpty()) {
        System.out.println("no solution");
      } else if (validShifts.size() == 1) {
        System.out.println("unique: " + validShifts.get(0));
      } else {
        System.out.print("ambiguous:");
        for (int shift : validShifts) {
          System.out.print(" " + shift);
        }
        System.out.println();
      }
    }
    sc.close();
  }
}