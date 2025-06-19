package dp_deepening;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task {
  static int n, ans;
  static int[] dur = new int[10002];
  static int[] ind = new int[10002];
  static List<Integer>[] rel = new ArrayList[10002];
  static List<Integer>[] tt = new ArrayList[1000002];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();

    // 초기화
    for (int i = 0; i <= 10001; i++) rel[i] = new ArrayList<>();
    for (int i = 0; i <= 1_000_001; i++) tt[i] = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      dur[i] = sc.nextInt();
      int m = sc.nextInt();
      if (m == 0) {
        tt[dur[i]].add(i);
      }
      for (int j = 0; j < m; j++) {
        int x = sc.nextInt();
        rel[x].add(i);
        ind[i]++;
      }
    }

    for (int t = 0; t <= 1_000_000; t++) {
      for (int finished : tt[t]) {
        ans = t;
        for (int r : rel[finished]) {
          ind[r]--;
          if (ind[r] != 0) continue;
          tt[t + dur[r]].add(r);
        }
      }
    }

    System.out.println(ans);
  }
}
