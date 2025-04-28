package stack;

import java.util.Scanner;
import java.util.Stack;

public class IronBar {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    char[] chars = input.toCharArray();

    Stack<Character> stack = new Stack<>();
    int answer = 0;

    for (int i = 0; i < input.length(); i++) {
      char now = chars[i];

      if (now == '(') {
        stack.push(now);
        continue;
      }

      stack.pop();
      char before = chars[i-1];

      if (before == '(') {
        answer += stack.size();
      } else {
        // 막대 끝
        answer += 1;
      }
    }

    System.out.println(answer);
  }
}
