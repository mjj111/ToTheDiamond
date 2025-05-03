package math;

import java.util.Scanner;

public class NumberOfCombinationsZero {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    long m = sc.nextLong();

    // n! / (m! * (n-m)!)
    long count5 = countFactor(n, 5) - countFactor(m, 5) - countFactor(n - m, 5);
    long count2 = countFactor(n, 2) - countFactor(m, 2) - countFactor(n - m, 2);

    System.out.println(Math.min(count5, count2));
  }

  static long countFactor(long n, int p) {
    long count = 0;
    while (n >= p) {
      count += n / p;
      n /= p;
    }
    return count;
  }
}
