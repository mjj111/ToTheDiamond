package math;

import java.util.Scanner;

public class LCM {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    while(N-- > 0) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      System.out.println(lcm(a,b));
    }
  }
  private static long lcm(int a, int b) {
    return (long) a * b / gcd(a, b);
  }
  private static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

}
