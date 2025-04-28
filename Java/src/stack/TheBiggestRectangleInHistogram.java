package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class TheBiggestRectangleInHistogram {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());

      if (N == 0) break;

      int[] nums = new int[N+1];
      for (int i = 0; i < N; i++) {
        nums[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(findBiggest(N, nums));
    }
  }

  public static long findBiggest(int N, int[] nums) {
    Stack<Integer> stack = new Stack<>();
    long maxArea = 0;

    for (int i = 0; i <= N; i++) {
      int nowHeight = nums[i];

      // 스택에서 현재 막대보다 더 낮은 막대가 발견되면,
      // 스택에서 하나씩 꺼내며 넓이를 계산하고 최대 넓이를 갱신한다.
      // 현재 인덱스는 넓이를 계산할 때 너비를 구하는 데 사용된다.
      while (!stack.isEmpty() && nums[stack.peek()] >= nowHeight) {
        int height = nums[stack.pop()];
        // 스택이 비어 있으면 현재 인덱스까지가 너비, 비어 있지 않으면 스택의 top과의 차이가 너비
        long width = stack.isEmpty() ? i : i - 1 - stack.peek();
        maxArea = Math.max(maxArea, height * width);
      }

      stack.push(i);
    }

    return maxArea;
  }
}
