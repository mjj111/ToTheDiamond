package trie;

import java.util.Arrays;
import java.util.Scanner;

public class Boggle {
  static final int MAX = 300000 * 8 + 5;
  static final int ROOT = 1;
  static int unused = ROOT + 1;
  static int[][] next = new int[MAX][26];
  static int[] check = new int[MAX];
  static boolean[][] visited = new boolean[4][4];
  static char[][] board = new char[4][4];
  static int mark = 2;

  static int[] score = {0, 0, 0, 1, 1, 2, 3, 5, 11};
  static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
  static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};

  static int point = 0, wordnum = 0;
  static String mxlen = "";

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < MAX; i++) {
      Arrays.fill(next[i], 0);
    }

    int w = sc.nextInt();
    while (w-- > 0) {
      String s = sc.next();
      insert(s);
    }

    int b = sc.nextInt();
    for (int i = 0; i < b; i++) {
      for (int j = 0; j < 4; j++) {
        String row = sc.next();
        board[j] = row.toCharArray();
      }
      solve();
    }
  }

  static void solve() {
    point = 0;
    wordnum = 0;
    mxlen = "";

    for (int x = 0; x < 4; x++) {
      for (int y = 0; y < 4; y++) {
        visited[x][y] = true;
        find(x, y, next[ROOT][ctoi(board[x][y])], String.valueOf(board[x][y]));
        visited[x][y] = false;
      }
    }

    System.out.println(point + " " + mxlen + " " + wordnum);
    mark++;
  }

  static int ctoi(char c) {
    return c - 'A';
  }

  static void insert(String s) {
    int cur = ROOT;
    for (char c : s.toCharArray()) {
      int idx = ctoi(c);
      if (next[cur][idx] == 0)
        next[cur][idx] = unused++;
      cur = next[cur][idx];
    }
    check[cur] = 1;
  }

  static void find(int curx, int cury, int cur, String s) {
    if (cur == 0) return;

    if (check[cur] != 0 && check[cur] != mark) {
      check[cur] = mark;
      point += score[s.length()];
      wordnum++;
      if (s.length() > mxlen.length() || (s.length() == mxlen.length() && s.compareTo(mxlen) < 0)) {
        mxlen = s;
      }
    }

    for (int dir = 0; dir < 8; dir++) {
      int nx = curx + dx[dir];
      int ny = cury + dy[dir];
      if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) continue;
      if (visited[nx][ny]) continue;

      visited[nx][ny] = true;
      find(nx, ny, next[cur][ctoi(board[nx][ny])], s + board[nx][ny]);
      visited[nx][ny] = false;
    }
  }
}
