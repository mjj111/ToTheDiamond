package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class RooftopGardening {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] buildings = new int[N];
    for (int i = 0; i < N; i++) buildings[i] = Integer.parseInt(br.readLine());

    Stack<Integer> stack = new Stack<>();
    long answer = 0;

    for (int i = 0; i < N; i++) {
      int h = buildings[i];

      while (!stack.isEmpty() && stack.peek() <= h) {
        stack.pop();
      }

      answer += stack.size();
      stack.push(h);
    }

    System.out.println(answer);
  }
}