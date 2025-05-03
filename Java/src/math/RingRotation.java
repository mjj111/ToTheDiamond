package math;


import java.util.Scanner;

public class RingRotation {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] radius = new int[N];

    for (int i = 0; i < N; i++) {
      radius[i] = sc.nextInt();
    }

    int first = radius[0];
    for (int i = 1; i < N; i++) {
      int a = first;
      int b = radius[i];
      int gcd = gcd(a, b);
      System.out.println((a / gcd) + "/" + (b / gcd));
    }
  }

  private static int gcd( int a, int b){
    return b == 0 ? a : gcd(b, a % b);
  }
}