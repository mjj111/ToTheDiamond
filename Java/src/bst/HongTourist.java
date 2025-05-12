package bst;

import java.util.*;
import java.io.*;

public class HongTourist {
  static int N, Q;
  static TreeSet<Integer> attractions = new TreeSet<>();
  static int curPos = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    Q = Integer.parseInt(st.nextToken());

    int[] A = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
      if (A[i] == 1) attractions.add(i);
    }

    for (int i = 0; i < Q; i++) {
      String[] parts = br.readLine().split(" ");
      int type = Integer.parseInt(parts[0]);

      if (type == 1) {
        int idx = Integer.parseInt(parts[1]) - 1;
        if (A[idx] == 0) {
          A[idx] = 1;
          attractions.add(idx);
        } else {
          A[idx] = 0;
          attractions.remove(idx);
        }
      }

      if (type == 2) {
        int x = Integer.parseInt(parts[1]);
        curPos = (curPos + x) % N;
      }

      if (type == 3){
        if (attractions.isEmpty()) {
          sb.append("-1\n");
          continue;
        }

        Integer next = attractions.ceiling(curPos); // 이상이면서 가장 작은 것
        if (next != null) sb.append(next - curPos).append("\n");
        else sb.append((N - curPos) + attractions.first()).append("\n");
      }
    }

    System.out.print(sb);
  }
}