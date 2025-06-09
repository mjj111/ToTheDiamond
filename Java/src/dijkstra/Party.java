package dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Party {
  static final int INF = (int) 1e9;
  static List<Node>[] graph;
  static int v, e;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    v = sc.nextInt();
    e = sc.nextInt();

    graph = new ArrayList[v + 1];
    for (int i = 0; i <= v; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < e; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int cost = sc.nextInt();
      graph[a].add(new Node(b, cost));
      graph[b].add(new Node(a, cost));
    }

    int v1 = sc.nextInt();
    int v2 = sc.nextInt();

    int[] distFrom1 = dijkstra(1);
    int[] distFromV1 = dijkstra(v1);
    int[] distFromV2 = dijkstra(v2);

    long path1 = (long)distFrom1[v1] + distFromV1[v2] + distFromV2[v];
    long path2 = (long)distFrom1[v2] + distFromV2[v1] + distFromV1[v];

    long result = Math.min(path1, path2);
    System.out.println(result >= INF ? -1 : result);
  }

  static int[] dijkstra(int start) {
    int[] distance = new int[v + 1];
    Arrays.fill(distance, INF);
    PriorityQueue<Node> pq = new PriorityQueue<>();
    distance[start] = 0;
    pq.add(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node current = pq.poll();

      if (distance[current.index] < current.cost) continue;

      for (Node next : graph[current.index]) {
        int newCost = distance[current.index] + next.cost;
        if (newCost < distance[next.index]) {
          distance[next.index] = newCost;
          pq.add(new Node(next.index, newCost));
        }
      }
    }

    return distance;
  }

  static class Node implements Comparable<Node> {
    int index;
    int cost;

    Node(int index, int cost) {
      this.index = index;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
      return this.cost - other.cost;
    }
  }
}
