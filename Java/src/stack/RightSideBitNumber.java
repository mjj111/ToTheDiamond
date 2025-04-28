package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class RightSideBitNumber {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] nums = new int[N];
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    int[] answer = new int[N];
    Arrays.fill(answer, -1);
    Stack<Integer> stack = new Stack<>();
    for(int i = 0; i < N; i++) {
      int now = nums[i];
      while(!stack.isEmpty() && nums[stack.peek()] < now) {
        int leftIndex = stack.pop();
        answer[leftIndex] = now;
      }
      stack.push(i);
    }

    StringBuilder sb = new StringBuilder();
    for(int num : answer) {
      sb.append(num).append(" ");
    }
    System.out.println(sb);
  }

}
