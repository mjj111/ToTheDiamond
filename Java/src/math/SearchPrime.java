package math;

import java.util.Scanner;

public class SearchPrime {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    int[] nums = new int[N];
    for(int i = 0; i < N; i++) nums[i] = sc.nextInt();

    int answer = 0;
    for(int num : nums) {
      if(is_prime(num)) answer++;
    }
    System.out.println(answer);
  }

  public static boolean is_prime(int number) {
    if(number < 2) {
      return false;
    }
    if(number == 2) return true;

    for(int i = 2; i < number; i++) if(number % i == 0) return false;

    return true;
  }
}
