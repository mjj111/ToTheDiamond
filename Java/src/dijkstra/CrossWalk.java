package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CrossWalk {
  private static int N, M;
  private static List<List<Node>> crossWalk;
  private static long[] distance;

  public static void main(String[] args) throws Exception {
    StringTokenizer st;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    distance = new long[N+1];
    Arrays.fill(distance, Long.MAX_VALUE);

    crossWalk = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      crossWalk.add(new ArrayList<Node>());
    }
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      crossWalk.get(u).add(new Node(v, i));
      crossWalk.get(v).add(new Node(u, i));
    }
    dijkstra();
    System.out.println(distance[N]);
  }

  static class Node implements Comparable<Node>{
    int index;
    long cost;
    Node(int index, long cost) {
      this.index = index;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
      return Long.compare(this.cost, o.cost);
    }
  }

  private static void dijkstra() {
    PriorityQueue<Node> queue = new PriorityQueue<>();
    queue.offer(new Node(1, 0));
    distance[1] = 0;

    while(!queue.isEmpty()) {
      Node currentNode = queue.poll();
      if (currentNode.cost > distance[currentNode.index])
        continue;
      for (Node next :crossWalk.get(currentNode.index)) {
        int nextIndex = next.index;
        long nextCost;
        if (currentNode.cost <= next.cost) {
          nextCost = next.cost + 1;
        } else {
          // 모듈러 연산
          nextCost = ((long) Math.ceil(((double)currentNode.cost-next.cost)/M)) * M + next.cost + 1;
        }
        if (nextCost < distance[nextIndex]) {
          distance[nextIndex] = nextCost;
          queue.offer(new Node(nextIndex, nextCost));
        }
      }
    }
  }
}
