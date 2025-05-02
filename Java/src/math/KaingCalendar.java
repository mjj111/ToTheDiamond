package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KaingCalendar {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCase = Integer.parseInt(br.readLine());

    while(testCase-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      int count = calculateCount(N,M,x,y);
      System.out.println(count);
    }
  }

  public static int calculateCount(int M, int N, int x, int y) {
    //모든 해는 (x, y)의 순서쌍으로 순환하며, 최대 반복은 LCM(M, N)번 이후 다시 처음으로 돌아온다.
    // 즉, 최소공배수를 구하면 N,M으로 구할 수 있는 최대 연도를 구할 수 있다.
    int maxYear = lcm(M, N);

    //x = (k - 1) % M + 1
    //y = (k - 1) % N + 1
    // K 연도를 구하고자 할 떄 x와 y값은 이러하다.
    //그러나 구하고자 하는 것은 xy에 대한 연도값이기 떄문에 반대로 뒤집는다.

    for (int year = x; year <= maxYear; year += M) {
      // y가 맞는지 확인: (year - 1) % N + 1 == y
      if ((year - 1) % N + 1 == y) {
        return year;
      }
    }

    return -1;
  }

  public static int lcm(int a, int b) {
    return a * b / gcd(a, b);
  }

  public static int gcd(int a, int b) {
    return b == 0? a: gcd(b, a % b);
  }
}