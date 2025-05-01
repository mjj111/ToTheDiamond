package greedy;

import java.io.*;
import java.util.*;

public class NumberTying {


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    List<Integer> positives = new ArrayList<>();
    List<Integer> nonPositives = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());

      if (num > 0) positives.add(num);
      else nonPositives.add(num);
    }

    Collections.sort(positives, Collections.reverseOrder());
    Collections.sort(nonPositives);

    int result = calculateMaxSum(positives, true) + calculateMaxSum(nonPositives, false);

    System.out.println(result);
  }

  private static int calculateMaxSum(List<Integer> list, boolean isPositive) {
    int sum = 0;
    int i = 0;

    while (i < list.size()) {
      if (i + 1 < list.size()) {
        int a = list.get(i);
        int b = list.get(i + 1);

        // 1은 곱하는 것보다 더하는 것이 이득
        if (isPositive && (a == 1 || b == 1)) {
          sum += a;
          i++;
        } else {
          sum += a * b;
          i += 2;
        }
      } else {
        sum += list.get(i++);
      }
    }
    return sum;
  }
}