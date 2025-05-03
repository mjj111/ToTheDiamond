package math;

import java.util.Scanner;


public class BookPage {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long N = sc.nextLong();

    long[] count = new long[10];
    long digit = 1;

    while (N / digit > 0) {
      long high = N / (digit * 10); // 현재보다 큰 수
      long cur = (N / digit) % 10;  // 현재
      long low = N % digit;         // 현재 보다 낮은 수

      for (int i = 0; i < 10; i++) {
        if (i < cur) {
          count[i] += (high + 1) * digit;
        } else if (i == cur) {
          count[i] += (high * digit) + (low + 1);
        } else {
          count[i] += high * digit;
        }
      }

      // 앞자리에 0이 올 수 없으므로 해당 횟수만큼 빼기
      count[0] -= digit;

      digit *= 10;
    }

    for (int i = 0; i < 10; i++) System.out.print(count[i] + " ");
  }
}

