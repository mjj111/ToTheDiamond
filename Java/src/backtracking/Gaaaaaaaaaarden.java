package backtracking;

import java.util.*;

public class Gaaaaaaaaaarden  {
  static final int EMPTY = 0;
  static final int GREEN = 1;
  static final int RED = 2;
  static final int FLOWER = 3;

  static int n, m, g, r;
  static int[][] board = new int[52][52];
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static List<int[]> cand = new ArrayList<>();
  static int[] brute = new int[10];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt(); m = sc.nextInt(); g = sc.nextInt(); r = sc.nextInt();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        board[i][j] = sc.nextInt();
        if (board[i][j] == 2) {
          cand.add(new int[]{i, j});
        }
      }
    }

    int candsz = cand.size();
    Arrays.fill(brute, 0, candsz - g - r, EMPTY);
    Arrays.fill(brute, candsz - g - r, candsz - r, GREEN);
    Arrays.fill(brute, candsz - r, candsz, RED);

    int mx = 0;
    do {
      mx = Math.max(mx, solve());
    } while (nextPermutation(brute, candsz));

    System.out.println(mx);
  }

  static class State {
    int time, color;

    State(int time, int color) {
      this.time = time;
      this.color = color;
    }
  }

  static int solve() {
    State[][] state = new State[52][52];
    for (int i = 0; i < 52; i++)
      Arrays.fill(state[i], null);

    Queue<int[]> q = new LinkedList<>();
    for (int i = 0; i < cand.size(); i++) {
      int[] c = cand.get(i);
      if (brute[i] == GREEN || brute[i] == RED) {
        state[c[0]][c[1]] = new State(0, brute[i]);
        q.offer(new int[]{c[0], c[1]});
      }
    }

    int cnt = 0;
    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int x = cur[0], y = cur[1];
      int curTime = state[x][y].time;
      int curColor = state[x][y].color;

      if (state[x][y].color == FLOWER) continue;

      for (int dir = 0; dir < 4; dir++) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
        if (board[nx][ny] == 0) continue;

        if (state[nx][ny] == null) {
          state[nx][ny] = new State(curTime + 1, curColor);
          q.offer(new int[]{nx, ny});
        } else if (state[nx][ny].color == RED) {
          if (curColor == GREEN && state[nx][ny].time == curTime + 1) {
            state[nx][ny].color = FLOWER;
            cnt++;
          }
        } else if (state[nx][ny].color == GREEN) {
          if (curColor == RED && state[nx][ny].time == curTime + 1) {
            state[nx][ny].color = FLOWER;
            cnt++;
          }
        }
      }
    }

    return cnt;
  }

  static boolean nextPermutation(int[] arr, int n) {
    int i = n - 1;
    while (i > 0 && arr[i - 1] >= arr[i]) i--;
    if (i <= 0) return false;

    int j = n - 1;
    while (arr[i - 1] >= arr[j]) j--;

    int temp = arr[i - 1];
    arr[i - 1] = arr[j];
    arr[j] = temp;

    j = n - 1;
    while (i < j) {
      temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++; j--;
    }
    return true;
  }
}