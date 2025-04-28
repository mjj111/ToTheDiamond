package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class OasisReunion {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] nums = new int[N];
    for(int i = 0; i < N; i++) nums[i] = Integer.parseInt(br.readLine());


    long answer = 0;
    Stack<int[]> stack = new Stack<>();

    for(int i = 0; i < N; i++) {
      int now = nums[i];
      int[] pair = new int[]{now, 1};

      while(!stack.isEmpty() && stack.peek()[0] <= now) {
        int[] info = stack.pop();
        int height = info[0];
        int count = info[1];

        answer+= count;
        if(height == now) pair[1] += count;
      }

      if(!stack.isEmpty()) {
        answer++;
      }

      stack.push(pair);
    }

    System.out.println(answer);
  }
}
