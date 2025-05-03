package math;

import java.util.Scanner;

public class CalculateDay {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int E = sc.nextInt();
    int S = sc.nextInt();
    int M = sc.nextInt();

    int year = E;
    while (true) {
      if ((year - 1) % 28 + 1 == S &&
          (year - 1) % 19 + 1 == M) {
        System.out.println(year);
        break;
      }
      year += 15;
    }
  }
}
