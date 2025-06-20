package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SevenPrincesses {
  static char[][] board = new char[5][5];
  static int answer = 0;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  static List<int[]> positions = new ArrayList<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    for (int i = 0; i < 5; i++) {
      String line = sc.nextLine();
      for (int j = 0; j < 5; j++) {
        board[i][j] = line.charAt(j);
        positions.add(new int[]{i, j});
      }
    }

    comb(0, 0, new int[7][]); // 조합 시작

    System.out.println(answer);
  }

  // 25칸 중에서 7개 고르는 조합
  static void comb(int start, int depth, int[][] selected) {
    if (depth == 7) {
      if (isValid(selected)) {
        answer++;
      }
      return;
    }

    for (int i = start; i < positions.size(); i++) {
      selected[depth] = positions.get(i);
      comb(i + 1, depth + 1, selected);
    }
  }

  static boolean isValid(int[][] selected) {
    int sCount = 0;
    for (int[] pos : selected) {
      if (board[pos[0]][pos[1]] == 'S') {
        sCount++;
      }
    }

    if (sCount < 4) return false;
    return isConnected(selected);
  }

  static boolean isConnected(int[][] selected) {
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[5][5];
    boolean[][] selectedMap = new boolean[5][5];

    for (int[] pos : selected) {
      selectedMap[pos[0]][pos[1]] = true;
    }

    int count = 1;
    queue.add(selected[0]);
    visited[selected[0][0]][selected[0][1]] = true;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      int x = now[0];
      int y = now[1];

      for (int d = 0; d < 4; d++) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
        if (!selectedMap[nx][ny]) continue;
        if (visited[nx][ny]) continue;

        visited[nx][ny] = true;
        queue.add(new int[]{nx, ny});
        count++;
      }
    }

    return count == 7;
  }
}