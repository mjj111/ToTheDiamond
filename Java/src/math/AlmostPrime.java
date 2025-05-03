package math;

import java.util.*;

public class AlmostPrime {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long A = sc.nextLong();
    long B = sc.nextLong();

    int MAX = 10000000;
    boolean[] isNotPrime = new boolean[MAX + 1];
    List<Integer> primes = new ArrayList<>();

    for (int i = 2; i <= MAX; i++) {
      if(isNotPrime[i])continue;

      primes.add(i);
      for (long j = (long)i * i; j <= MAX; j += i) {
        isNotPrime[(int)j] = true;
      }
    }

    int count = 0;
    for (int p : primes) {
      long pow = (long)p * p;
      while (pow <= B) {
        if (pow >= A) count++;
        if ((double)pow * p > B) break;
        pow *= p;
      }
    }

    System.out.println(count);
  }
}
