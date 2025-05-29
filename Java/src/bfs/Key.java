package bfs;

import java.util.*;

public class Key {
  static int h, w, ans;
  static char[][] map;
  static boolean[][] visited;
  static boolean[] key;
  static boolean[][] docVisited;
  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, 1, 0, -1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    while (T-- > 0) {
      h = sc.nextInt();
      w = sc.nextInt();
      sc.nextLine();

      map = new char[h + 2][w + 2];
      visited = new boolean[h + 2][w + 2];
      docVisited = new boolean[h + 2][w + 2];
      key = new boolean[26];

      // 외곽에 .을 채워 넣음
      for (int i = 0; i < h + 2; i++) {
        Arrays.fill(map[i], '.');
      }

      for (int i = 1; i <= h; i++) {
        String line = sc.nextLine();
        for (int j = 1; j <= w; j++) {
          map[i][j] = line.charAt(j - 1);
        }
      }

      String keys = sc.nextLine();
      if (!keys.equals("0")) {
        for (char c : keys.toCharArray()) {
          key[c - 'a'] = true;
        }
      }

      ans = 0;
      bfs();
      System.out.println(ans);
    }

    sc.close();
  }
  static boolean isDoor(char c) {
    return c >= 'A' && c <= 'Z';
  }

  static boolean isKey(char c) {
    return c >= 'a' && c <= 'z';
  }

  static boolean isDoc(char c) {
    return c == '$';
  }

  static void bfs() {
    Queue<int[]> queue = new LinkedList<>();
    visited[0][0] = true;
    queue.add(new int[]{0, 0});

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int x = cur[0], y = cur[1];

      for (int i = 0; i < 4; i++) {
        int nx = x + dr[i];
        int ny = y + dc[i];

        if (nx < 0 || ny < 0 || nx >= h + 2 || ny >= w + 2) continue;
        if (visited[nx][ny] || map[nx][ny] == '*') continue;

        char next = map[nx][ny];

        // 문인데 키 없으면 pass
        if (isDoor(next) && !key[next - 'A']) continue;

        // 열쇠를 얻었을 때
        if (isKey(next) && !key[next - 'a']) {
          key[next - 'a'] = true;
          visited = new boolean[h + 2][w + 2]; // 방문 초기화
          docVisited = new boolean[h + 2][w + 2]; // 문서 방문도 초기화 (선택적)
          queue.clear();
          queue.add(new int[]{nx, ny});
          visited[nx][ny] = true;
          break;
        }

        // 문서를 처음 방문할 때
        if (isDoc(next) && !docVisited[nx][ny]) {
          ans++;
          docVisited[nx][ny] = true;
        }

        visited[nx][ny] = true;
        queue.add(new int[]{nx, ny});
      }
    }
  }
}
