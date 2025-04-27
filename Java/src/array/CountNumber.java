package array;

import java.util.Scanner;

public class CountNumber {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] numbers = new int[N];
    for(int i = 0; i < N; i++) {
      numbers[i] = sc.nextInt();
    }

    int goal = sc.nextInt();
    int answer = 0;
    for(int number : numbers) {
      if(goal == number) answer++;
    }

    System.out.println(answer);
  }
}
