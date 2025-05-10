package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DontLikeOverlapping {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] nums = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

    int[] freq = new int[100_001];
    int start = 0;
    int answer = 0;

    for (int end = 0; end < N; end++) {
      freq[nums[end]]++;

      while (freq[nums[end]] > K) {
        freq[nums[start]]--;
        start++;
      }

      answer = Math.max(answer, end - start + 1);
    }

    System.out.println(answer);
  }
}
