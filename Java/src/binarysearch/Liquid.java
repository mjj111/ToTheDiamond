package binarysearch;

import java.io.*;
import java.util.*;

public class Liquid {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(reader.readLine());

    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    int[] liquids = new int[N];
    for (int i = 0; i < N; i++) liquids[i] = Integer.parseInt(tokenizer.nextToken());

    int closestSum = Integer.MAX_VALUE;
    int bestLeft = 0, bestRight = 0;

    for (int i = 0; i < N - 1; i++) {
      int fixedOne = liquids[i];

      int left = i + 1;
      int right = N - 1;

      while (left <= right) {
        int mid = (left + right) / 2;
        int sum = fixedOne + liquids[mid];

        if (Math.abs(sum) < closestSum) {
          closestSum = Math.abs(sum);
          bestLeft = fixedOne;
          bestRight = liquids[mid];
        }

        if (sum < 0) left = mid + 1;
        else right = mid - 1;
      }
    }

    if (bestLeft < bestRight) {
      System.out.println(bestLeft + " " + bestRight);
    } else {
      System.out.println(bestRight + " " + bestLeft);
    }
  }
}
