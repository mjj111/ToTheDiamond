package dp_deepening;

import java.util.HashMap;
import java.util.Scanner;

public class InfinitySequence {
  static long P, Q;
  static HashMap<Long, Long> memo = new HashMap<>();

  public static long dfs(long n) {
    if (n == 0) return 1;
    if (memo.containsKey(n)) return memo.get(n);

    long result = dfs(n / P) + dfs(n / Q);
    memo.put(n, result);
    return result;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long N = sc.nextLong();
    P = sc.nextLong();
    Q = sc.nextLong();

    System.out.println(dfs(N));
  }
}
