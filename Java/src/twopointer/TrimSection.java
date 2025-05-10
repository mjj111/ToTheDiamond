package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TrimSection {

  public static void main(String[] args) throws IOException {
    final int MAX = 1_000_001;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] diff = new int[MAX + 1];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      diff[start]++;
      diff[end]--;
    }

    int[] overlap = new int[MAX];
    overlap[0] = diff[0];
    for (int i = 1; i < MAX; i++) overlap[i] = overlap[i - 1] + diff[i];

    long[] prefixSum = new long[MAX + 1];
    for (int i = 1; i <= MAX; i++) prefixSum[i] = prefixSum[i - 1] + overlap[i - 1];

    System.out.println(calculate(MAX, prefixSum, K));
  }

  private static String calculate(int MAX, long[] prefixSum, int K) {
    int start = 0;

    for (int end = 1; end <= MAX; end++) {
      while (start < end && prefixSum[end] - prefixSum[start] > K) start++;
      if (prefixSum[end] - prefixSum[start] == K) return start + " " + end;
    }

    return "0 0";
  }
}
