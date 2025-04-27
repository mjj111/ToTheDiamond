package array;

import java.util.*;

public class TwoNumbersSum {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[N];
    for(int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }
    int x = sc.nextInt();

    Arrays.sort(arr);

    int left = 0;
    int right = N - 1;

    int count = 0;

    while(left < right) {
      int sum = arr[left] + arr[right];
      if(sum == x) {
        count++;
        left++;
        right--;
      } else if(sum < x) {
        left++;
      } else {
        right--;
      }
    }

    System.out.println(count);
  }
}
