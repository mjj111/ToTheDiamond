package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Virus {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int E = Integer.parseInt(br.readLine());

    Map<Integer, List<Integer>> nodes = new HashMap<>();
    for(int i = 1; i <= N; i++) {
      nodes.put(i, new ArrayList<Integer>());
    }

    for(int i = 0; i < E; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start =  Integer.parseInt(st.nextToken());
      int end =  Integer.parseInt(st.nextToken());

      nodes.get(start).add(end);
      nodes.get(end).add(start);
    }

    boolean visited[] = new boolean[N+1];
    Deque<Integer> queue = new LinkedList<>();
    queue.addLast(1);

    while(!queue.isEmpty()) {
      int now = queue.removeFirst();
      visited[now] = true;

      for(int next : nodes.get(now)) {
        if(visited[next]) continue;
        queue.addLast(next);
      }
    }

    int answer = 0;
    for(int i = 2; i <= N; i++) {
      if(visited[i]) answer++;
    }

    System.out.println(answer);
  }
}