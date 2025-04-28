package stack;

import java.io.*;
import java.util.*;

public class Top {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] heights = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      heights[i] = Integer.parseInt(st.nextToken());
    }

    Stack<int[]> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < N; i++) {
      int height = heights[i];

      while (!stack.isEmpty() && stack.peek()[1] < height) {
        stack.pop();
      }

      if (stack.isEmpty()) {
        sb.append(0).append(' ');
      } else {
        sb.append(stack.peek()[0] + 1).append(' ');
      }

      stack.push(new int[]{i, height});
    }

    System.out.println(sb);
  }
}
