package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrimeContinueSum {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    boolean[] isPrime = new boolean[N + 1];
    Arrays.fill(isPrime, true);

    for (int i = 2; i * i <= N; i++) {
      if (!isPrime[i]) continue;
      for (int j = i * i; j <= N; j += i) isPrime[j] = false;
    }

    List<Integer> primes = new ArrayList<>();
    for (int i = 2; i <= N; i++) if (isPrime[i]) primes.add(i);


    int start = 0;
    int sum = 0;
    int answer = 0;

    for (int end = 0; end < primes.size(); end++) {
      sum += primes.get(end);

      while (sum >= N) {
        if (sum == N) answer++;
        sum -= primes.get(start++);
      }
    }

    System.out.println(answer);
  }
}
