package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class ConnectedComponentCount {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int NodeCount = Integer.parseInt(st.nextToken());
    int EdgeCount = Integer.parseInt(st.nextToken());
    boolean[] visited = new boolean[NodeCount+1];

    ArrayList<Integer>[] edges = new ArrayList[NodeCount+1];
    for (int i = 0; i < NodeCount + 1; i++) {
      edges[i] = new ArrayList<>();
    }

    for(int i = 0; i < EdgeCount; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      edges[start].add(end);
      edges[end].add(start);
    }

    int answer = 0;
    for(int i = 0; i < NodeCount + 1; i++) {
      if(!visited[i]) {
        answer += 1;
        dfs(i, visited, edges);
      }
    }

    System.out.println(answer-1);
  }

  static void dfs(int nowNode, boolean[] visited, ArrayList<Integer>[] edges) {
    if(visited[nowNode]) {
      return;
    }
    visited[nowNode] = true;

    for(int nextNode : edges[nowNode]) {
      dfs(nextNode, visited, edges);
    }
  }
}