package greedy;

import java.io.*;
import java.util.*;

public class Delivery {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(br.readLine());

    PriorityQueue<Dinfo> dInfo = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int amount = Integer.parseInt(st.nextToken());

      dInfo.add(new Dinfo(start, end, amount));
    }

    int[] load = new int[N + 1]; // 각 구간별 실린 택배 양
    int totalDelivered = 0;
    while (!dInfo.isEmpty()) {
      Dinfo d = dInfo.poll();

      int maxLoad = 0;
      for (int i = d.start; i < d.end; i++) {
        maxLoad = Math.max(maxLoad, load[i]);
      }

      int canLoad = Math.min(d.amount, K - maxLoad);
      totalDelivered += canLoad;

      for (int i = d.start; i < d.end; i++) {
        load[i] += canLoad;
      }
    }

    System.out.println(totalDelivered);
  }

  private static class Dinfo {
    int start, end, amount;
    public Dinfo(int start, int end, int amount) {
      this.start = start;
      this.end = end;
      this.amount = amount;
    }
  }
}
