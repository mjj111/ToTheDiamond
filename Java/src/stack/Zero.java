package stack;

import java.util.Deque;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;

public class Zero {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    Stack<Integer> stack = new Stack<>();
    for(int i = 0; i < N; i++) {
      int input = sc.nextInt();
      if(input == 0) stack.pop();
      else stack.push(input);
    }

    int answer = 0;
    while(!stack.isEmpty()) {
      answer+= stack.pop();
    }

    System.out.println(answer);
  }
}
