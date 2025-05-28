package hash;

import java.util.*;

class StringHell {
  static int N, M, K;
  static String[] arr;
  static Map<String, Integer> likeMap = new HashMap<>();

  static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
  static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    M = sc.nextInt();
    K = sc.nextInt();
    sc.nextLine();

    arr = new String[N];
    for (int i = 0; i < N; i++) arr[i] = sc.nextLine().trim();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        bfs(i, j);
      }
    }

    for (int i = 0; i < K; i++) {
      String query = sc.nextLine().trim();
      System.out.println(likeMap.getOrDefault(query, 0));
    }

    sc.close();
  }

  public static void bfs(int x, int y) {
    Queue<BFSState> queue = new LinkedList<>();
    queue.offer(new BFSState(x, y, String.valueOf(arr[x].charAt(y))));

    while (!queue.isEmpty()) {
      BFSState current = queue.poll();

      likeMap.put(current.str, likeMap.getOrDefault(current.str, 0) + 1);
      if (current.str.length() == 5) continue;


      for (int d = 0; d < 8; d++) {
        int nx = (current.x + dx[d] + N) % N;
        int ny = (current.y + dy[d] + M) % M;
        queue.offer(new BFSState(nx, ny, current.str + arr[nx].charAt(ny)));
      }
    }
  }
  static class BFSState {
    int x, y;
    String str;

    BFSState(int x, int y, String str) {
      this.x = x;
      this.y = y;
      this.str = str;
    }
  }
}
