package array;

import java.util.*;

public class TwoNumbersSum {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[N];
    for(int i = 0; i < N; i++) arr[i] = sc.nextInt();

    int x = sc.nextInt();

    Arrays.sort(arr);

    int right = N - 1;
    int count = 0;

    for(int left = 0; left < N-1; left++) {
      while (left < right && arr[left] + arr[right] > x) {
        right--;
      }

      if (left < right && arr[left] + arr[right] == x) {
        count++;
      }
    }

    System.out.println(count);
  }
}
