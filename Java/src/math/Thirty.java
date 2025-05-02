package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Thirty {

  public static void main(String[] args) {
    String number = new Scanner(System.in).next();

    char[] chars = number.toCharArray();
    int N = number.length();

    int sum = 0;
    Integer[] nums = new Integer[N];

    for(int i = 0; i <N; i++) {
      int num = chars[i] - '0';

      nums[i] = num;
      sum += num;
    }

    Arrays.sort(nums, Collections.reverseOrder());
    if(nums[N-1] != 0 || sum % 3 != 0) {
      System.out.println(-1);
      return;
    }

    StringBuilder sb = new StringBuilder();
    for(int num : nums) {
      sb.append(num);
    }
    System.out.println(sb);
  }
}
