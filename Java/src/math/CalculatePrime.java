package math;

import java.util.Scanner;

public class CalculatePrime {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int start = sc.nextInt();
    int end = sc.nextInt();

    int[] primes = new int[end + 1];
    for(int i = 2; i<= end; i++) primes[i] = i;

    for(int i = 1; i <= end; i++) {
      if(primes[i] == 0) continue;
      for(int j = 2*i; j <= end; j+=i) primes[j] = 0;
    }

    for(int i = start; i <= end; i++) {
      if(primes[i] == 0) continue;
      System.out.println(i);
    }
  }
}
