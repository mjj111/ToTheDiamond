package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class LongestEvenSequence {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] nums = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

    int start = 0;
    int count = 0;
    int answer = 0;

    for(int end = 0; end < N; end++){
      if (nums[end] % 2 == 1) count++;

      while (count > K) {
        if (nums[start] % 2 == 1) count--;
        start++;
      }

      answer = Math.max(answer, end - start + 1 - count);
    }

    System.out.println(answer);
  }
}
