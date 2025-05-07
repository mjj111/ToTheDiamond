package binarysearch;

import java.io.*;
import java.util.*;

public class BudgetCap {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] requests = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();

    int budget = Integer.parseInt(br.readLine());

    int start = 0;
    int end = Arrays.stream(requests).max().getAsInt();
    int result = 0;

    while (start <= end) {
      int mid = (start + end) / 2;
      long total = calculateTotal(requests, mid);

      if (total <= budget) {
        result = mid;
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    System.out.println(result);
  }

  private static long calculateTotal(int[] requests, int mid) {
    long total = 0;
    for (int req : requests) total += Math.min(req, mid);
    return total;
  }
}
