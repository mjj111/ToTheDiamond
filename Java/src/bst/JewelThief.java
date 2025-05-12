package bst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JewelThief {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[][] jewels = new int[N][2];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      jewels[i][0] = Integer.parseInt(st.nextToken());
      jewels[i][1] = Integer.parseInt(st.nextToken());
    }

    int[] bags = new int[K];
    for (int i = 0; i < K; i++) {
      bags[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(jewels, (a,b) -> a[0] - b[0]); // 무게 기준 오름차순
    Arrays.sort(bags);

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
    long total = 0;
    int idx = 0;

    for (int bag : bags) {
      while (idx < N && jewels[idx][0] <= bag) {
        pq.offer(jewels[idx][1]);
        idx++;
      }

      if (!pq.isEmpty()) total += pq.poll();
    }

    System.out.println(total);
  }
}
