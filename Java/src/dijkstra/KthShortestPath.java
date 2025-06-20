package dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthShortestPath {
  static int N, M, K;
  static List<List<Node>> graph = new ArrayList<>();
  static PriorityQueue<Integer>[] distance;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    K = sc.nextInt();

    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    // 거리 배열 초기화 (최대 힙으로 K개 유지)
    distance = new PriorityQueue[N + 1];
    for (int i = 0; i <= N; i++) {
      distance[i] = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
    }

    for (int i = 0; i < M; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      graph.get(a).add(new Node(c, b));
    }

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(0, 1));
    distance[1].add(0);

    while (!pq.isEmpty()) {
      Node now = pq.poll();

      for (Node next : graph.get(now.to)) {
        int newCost = now.cost + next.cost;

        if (distance[next.to].size() < K) {
          distance[next.to].add(newCost);
          pq.add(new Node(newCost, next.to));
        } else if (distance[next.to].peek() > newCost) {
          distance[next.to].poll(); // 가장 큰 값 제거
          distance[next.to].add(newCost);
          pq.add(new Node(newCost, next.to));
        }
      }
    }

    for (int i = 1; i <= N; i++) {
      if (distance[i].size() == K) {
        System.out.println(distance[i].peek());
      } else {
        System.out.println(-1);
      }
    }
  }
  static class Node implements Comparable<Node> {
    int to, cost;

    Node(int cost, int to) {
      this.to = to;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
      return this.cost - o.cost;
    }
  }
}