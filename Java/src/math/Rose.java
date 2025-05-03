package math;

import java.util.Scanner;

public class Rose {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long N = sc.nextLong();  // 필요한 장미의 수
    long A = sc.nextLong();  // 첫 번째 꽃집에서 한 묶음에 들어있는 장미 수
    long B = sc.nextLong();  // 첫 번째 꽃집에서 한 묶음의 가격
    long C = sc.nextLong();  // 두 번째 꽃집에서 한 묶음에 들어있는 장미 수
    long D = sc.nextLong();  // 두 번째 꽃집에서 한 묶음의 가격

    if (B * C < D * A) {
      long temp;
      temp = A;
      A = C;
      C = temp;
      temp = B;
      B = D;
      D = temp;
    }

    long result = Long.MAX_VALUE;
    for (int firstCount = 0; firstCount < C; firstCount++) {
      long secondCount = (long) Math.ceil((double) (N - firstCount * A) / C);

      if (secondCount < 0) secondCount = 0;
      result = Math.min(result, firstCount * B + secondCount * D);

      if (secondCount == 0) break;
    }

    System.out.println(result);
  }
}
