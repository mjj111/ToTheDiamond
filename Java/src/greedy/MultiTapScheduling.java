package greedy;

import java.io.*;
import java.util.*;

public class MultiTapScheduling {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());;

    st = new StringTokenizer(br.readLine());
    int[] order = new int[K];
    for (int i = 0; i < K; i++) order[i] = Integer.parseInt(st.nextToken());

    Set<Integer> using = new HashSet<>();
    int answer = 0;
    for (int i = 0; i < K; i++) {
      int device = order[i];

      if (using.contains(device)) continue;

      if (using.size() < N) {
        using.add(device);
        continue;
      }

      // 뽑아야 한다면
      int idxToRemove = getIdxToRemove(using, i, K, order);

      using.remove(idxToRemove);
      using.add(device);
      answer++;
    }

    System.out.println(answer);
  }

  private static int getIdxToRemove(Set<Integer> using, int i, int K, int[] order) {
    int farthest = -1;
    int idxToRemove = -1;
    for (int u : using) {
      int nextUse = Integer.MAX_VALUE;

      //가장 나중에 다시 쓰일 기기 찾기
      for (int j = i + 1; j < K; j++) {
        if (order[j] == u) {
          nextUse = j;
          break;
        }
      }
      if (nextUse > farthest) {
        farthest = nextUse;
        idxToRemove = u;
      }
    }
    return idxToRemove;
  }
}