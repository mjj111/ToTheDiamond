package greedy;

import java.util.*;
import java.io.*;

public class ClassroomAssignment {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[][] lectures = new int[N][2];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      lectures[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
      lectures[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
    }

    Arrays.sort(lectures,(a,b) -> a[0] - b[0]);

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      int start = lectures[i][0];
      int end = lectures[i][1];

      // 현재 강의 시작 전에 끝난 강의실 있으면 재사용
      if (!pq.isEmpty() && pq.peek() <= start) {
        pq.poll();
      }
      pq.offer(end);
    }

    System.out.println(pq.size());
  }
}
