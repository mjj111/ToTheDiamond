package trie;

import java.util.Arrays;
import java.util.Scanner;

public class PhoneNumberList {
  static final int MX = 100_005; // 10000 * 10 + 5
  static final int ROOT = 1;

  static int unused;
  static int[][] nxt = new int[MX][10];
  static boolean[] chk = new boolean[MX];

  static int t, n;

  // 문자 → 숫자로 변환 ('0' ~ '9')
  static int ctoi(char c) {
    return c - '0';
  }

  static boolean insert(String s) {
    int cur = ROOT;
    for (char c : s.toCharArray()) {
      int idx = ctoi(c);
      if (nxt[cur][idx] == -1) {
        nxt[cur][idx] = unused++;
      }
      cur = nxt[cur][idx];
      if (chk[cur]) return false; // 중간에 끝나는 번호가 있음 → 접두어 충돌
    }
    if (cur != unused - 1) return false; // 누군가 이 번호를 접두어로 갖고 있음
    chk[cur] = true; // 이 지점은 끝나는 지점
    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    t = sc.nextInt();

    while (t-- > 0) {
      Arrays.fill(chk, false);
      for (int i = 0; i < MX; i++) Arrays.fill(nxt[i], -1);
      unused = ROOT + 1;

      boolean isValid = true;

      n = sc.nextInt();
      String[] numbers = new String[n];
      for (int i = 0; i < n; i++) {
        numbers[i] = sc.next();
      }

      for (String s : numbers) {
        if (!insert(s)) {
          isValid = false;
          break;
        }
      }

      System.out.println(isValid ? "YES" : "NO");
    }
  }
}