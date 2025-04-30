package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrefixSum {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] nums = new int[N];
    for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

    int answer = Integer.MIN_VALUE;
    int sum = 0;
    for(int now : nums) {

      if(sum + now >= 0) {
        sum += now;
        answer = Math.max(answer, sum);
        continue;
      }
      sum = 0;
      answer = Math.max(now, answer);
    }

    System.out.println(answer);
  }
}
