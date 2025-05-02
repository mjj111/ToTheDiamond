package math;

import java.util.Scanner;

public class PrimeFactorization {
  public static void main(String[] args) {
    int N = new Scanner(System.in).nextInt();

    StringBuilder sb = new StringBuilder();
    for (int i = 2; i <= Math.sqrt(N); i++) {
      while (N % i == 0) {
        sb.append(i).append('\n');
        N /= i;
      }
    }

    if (N != 1) {
      sb.append(N);
    }
    System.out.println(sb);
  }
}
