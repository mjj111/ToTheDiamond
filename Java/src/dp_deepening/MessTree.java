package dp_deepening;
import java.util.*;

public class MessTree {
  static int N;
  static List<List<Edge>> edge = new ArrayList<>();
  static boolean[] flip;
  static boolean[] ans;
  static int minFlip = Integer.MAX_VALUE;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();

    for (int i = 0; i <= N; i++) edge.add(new ArrayList<>());

    flip = new boolean[N - 1];
    ans = new boolean[N - 1];

    for (int i = 0; i < N - 1; i++) {
      int start = sc.nextInt();
      int end = sc.nextInt();

      edge.get(start).add(new Edge(end, false, i));
      edge.get(end).add(new Edge(start, true, i));
    }

    int flipCnt = calculateFlipCount(1, 0);
    dfs(1, 0, flipCnt);

    for (int i = 0; i < N - 1; i++) {
      System.out.print(ans[i] ? "1" : "0");
    }
  }

  static class Edge {
    int nodeIdx;
    boolean isReverse;
    int edgeIdx;

    Edge(int nodeIdx, boolean isReverse, int edgeIdx) {
      this.nodeIdx = nodeIdx;
      this.isReverse = isReverse;
      this.edgeIdx = edgeIdx;
    }
  }

  static int calculateFlipCount(int now, int prev) {
    int sum = 0;
    for (Edge next : edge.get(now)) {
      if (next.nodeIdx == prev) continue;

      flip[next.edgeIdx] = next.isReverse;
      sum += calculateFlipCount(next.nodeIdx, now) + (next.isReverse ? 1 : 0);
    }
    return sum;
  }

  static void dfs(int node, int prev, int flipCnt) {
    if (minFlip > flipCnt) {
      minFlip = flipCnt;
      ans = flip.clone();
    }

    for (Edge next : edge.get(node)) {
      if (next.nodeIdx == prev) continue;

      if (next.isReverse) {
        flip[next.edgeIdx] = false;
        dfs(next.nodeIdx, node, flipCnt - 1);
        flip[next.edgeIdx] = true;
      } else {
        flip[next.edgeIdx] = true;
        dfs(next.nodeIdx, node, flipCnt + 1);
        flip[next.edgeIdx] = false;
      }
    }
  }
}

