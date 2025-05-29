package greedy;

import java.util.Scanner;

public class Flipping {
  public static void main(String[] args) {
    String input = new Scanner(System.in).nextLine();

    int count0 = 0;
    int count1 = 0;

    if (input.charAt(0) == '0') count0++;
    else count1++;

    for (int i = 1; i < input.length(); i++) {
      char now = input.charAt(i);
      char next = input.charAt(i - 1);

      if(now==next) continue;

      // 연속된 숫자가 바뀌는 순간
      // 새로운 그룹 시작
      if (now == '0') count0++;
      else count1++;
    }

    System.out.println(Math.min(count0, count1));
  }
}
