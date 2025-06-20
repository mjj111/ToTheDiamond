package backtracking;

import java.util.*;

public class EggBreaking {
  static int n;
  static int maxBroken = 0;
  static int[][] eggs;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    eggs = new int[n][2]; // [내구도, 무게]

    for (int i = 0; i < n; i++) {
      eggs[i][0] = sc.nextInt(); // 내구도
      eggs[i][1] = sc.nextInt(); // 무게
    }

    dfs(0);
    System.out.println(maxBroken);
  }

  static void dfs(int current) {
    if (current == n) {
      maxBroken = Math.max(maxBroken, countBroken());
      return;
    }

    if (eggs[current][0] <= 0) {
      dfs(current + 1);
      return;
    }

    boolean isHit = false;

    for (int target = 0; target < n; target++) {
      if (target == current || eggs[target][0] <= 0) continue;

      isHit = true;

      // 계란 치기
      eggs[current][0] -= eggs[target][1];
      eggs[target][0] -= eggs[current][1];

      dfs(current + 1);

      // 원상복구
      eggs[current][0] += eggs[target][1];
      eggs[target][0] += eggs[current][1];
    }

    if (!isHit) {
      dfs(current + 1);
    }
  }

  static int countBroken() {
    int count = 0;
    for (int[] egg : eggs) {
      if (egg[0] <= 0) count++;
    }
    return count;
  }
}

