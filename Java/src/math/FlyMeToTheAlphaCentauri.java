package math;

import java.util.Scanner;

public class FlyMeToTheAlphaCentauri {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    while (T-- > 0) {
      int start = in.nextInt();
      int end = in.nextInt();
      calculate(start, end);
    }
  }

  public static void calculate(int start, int end) {
    int distance = end - start;
    if (distance < 4) {
      System.out.println(distance);
      return;
    }

    int n = (int)Math.sqrt(distance);

    if (distance == n * n) {
      System.out.println(2 * n - 1);
      return;
    }

    if (distance <= n * (n + 1)) {
      System.out.println(2 * n);
      return;
    }

    System.out.println(2 * n + 1);
  }
}
