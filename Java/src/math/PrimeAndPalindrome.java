package math;

import java.util.Scanner;

public class PrimeAndPalindrome {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    while (true) {
      if (isPalindrome(N) && isPrime(N)) {
        System.out.println(N);
        break;
      }
      N++;
    }
  }

  static boolean isPalindrome(int n) {
    String s = Integer.toString(n);
    int len = s.length();
    for (int i = 0; i < len / 2; i++) {
      if (s.charAt(i) != s.charAt(len - 1 - i)) return false;
    }
    return true;
  }

  static boolean isPrime(int n) {
    if (n < 2) return false;
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) return false;
    }
    return true;
  }
}
