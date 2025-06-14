package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SharingSweets {
  private static int unclesAmount;
  private static int cookieAmount;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    unclesAmount = Integer.parseInt(st.nextToken());
    cookieAmount = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] cookies = new int[cookieAmount];

    for (int i = 0; i < cookieAmount; i++) {
      cookies[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(cookies);
    int answer = getMaximumLength(cookies);
    System.out.println(answer);
  }

  private static int getMaximumLength(int[] cookies) {
    int start = 1;
    int end = cookies[cookies.length-1];

    while (start <= end) {
      int mid = (start + end) / 2;

      if (isPossible(cookies, mid)) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return end;
  }

  private static boolean isPossible(int[] cookies, int length) {
    int sum = 0;
    for (int cookie : cookies) {
      sum += cookie / length;
    }
    return sum >= unclesAmount;
  }
}