package stack;

import java.io.*;
import java.util.*;

public class StackSequence {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Stack<Integer> stack = new Stack<>();
    int start = 0;

    while(N-- > 0) {
      int value = Integer.parseInt(br.readLine());

      if(value > start) {
        for(int i = start + 1; i <= value; i++) {
          stack.push(i);
          System.out.println('+');
        }
        start = value;
      }

      else if(stack.peek() != value) {
        System.out.println("NO");
        return;
      }

      stack.pop();
      System.out.println('-');
    }
  }
}