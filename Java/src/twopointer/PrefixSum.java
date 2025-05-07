package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrefixSum {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());

    int[] nums = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

    int start = 0;
    int sum = 0;
    int answer = Integer.MAX_VALUE;

    for (int end = 0; end < N; end++) {
      sum += nums[end];

      while (sum >= S) {
        answer = Math.min(answer, end - start + 1);
        sum -= nums[start++];
      }
    }

    if (answer == Integer.MAX_VALUE) System.out.println(0);
    else System.out.println(answer);
  }
}
