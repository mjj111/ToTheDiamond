package dp_deepening;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class RacingCar {
  static int N, M;
  static ArrayList<Node>[] graph;
  static int[] inDegree, score, prev;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    graph = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

    inDegree = new int[N + 1];
    for (int i = 0; i < M; i++) {
      StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

      int s = Integer.parseInt(stD.nextToken());
      int e = Integer.parseInt(stD.nextToken());
      int v = Integer.parseInt(stD.nextToken());

      graph[s].add(new Node(e, v));
      inDegree[e]++;
    }

    topologicalSort();

    System.out.println(score[1]);

    Deque<Integer> path = new ArrayDeque<>();
    int num = 1;
    while (true) {
      path.addFirst(num);
      if (prev[num] == 0 || prev[num] == num) break; // 시작점 도달 또는 순환 방지
      if (num == 1 && path.size() > 1) break; // 1로 돌아왔으면 종료
      num = prev[num];
    }
    for (int node : path) System.out.print(node + " ");
  }
  static class Node {
    int num;
    int cost;

    public Node(int num, int cost) {
      this.num = num;
      this.cost = cost;
    }
  }

  static void topologicalSort(){
    score = new int[N + 1];
    prev = new int[N + 1];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);

    while (!queue.isEmpty()){
      int now = queue.poll();

      for (Node next : graph[now]){
        int nextCost = score[now] + next.cost;

        if (score[next.num] < nextCost){
          score[next.num] = nextCost;
          prev[next.num] = now;
        }

        inDegree[next.num]--;

        if (inDegree[next.num] == 0 && (next.num != 1)) queue.add(next.num);
      }
    }
  }
}