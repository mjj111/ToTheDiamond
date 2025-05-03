package math;

import java.util.Scanner;

public class Tournament {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int left = sc.nextInt();
    int right = sc.nextInt();

    boolean find = false;

    int count = 0;
    while(left != right) {
      count++;
      left = (left + 1) / 2;
      right = (right + 1) / 2;
    }

    if(count >= N) {
      System.out.println(-1);
      return;
    }

    System.out.println(count);
  }
}
