package math;

import java.util.Scanner;

public class DrunkenSangbum {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      System.out.println((int)Math.sqrt(n));
    }
  }
}
