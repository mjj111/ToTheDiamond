package dp_deepening;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindingTheSumOfIntervals5 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());


    int[][] board = new int[N+1][N+1];
    for(int i = 1; i < N+1; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j < N+1; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[][] sumBoard = new int[N+1][N+1];
    for (int i = 1; i < N+1; i++) {
      for(int j = 1; j < N+1; j++) {
        sumBoard[i][j] =
            + sumBoard[i-1][j]
                + sumBoard[i][j-1]
                - sumBoard[i-1][j-1]
                + board[i][j];
      }
    }

    int result = 0;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int firstX = Integer.parseInt(st.nextToken());
      int firstY = Integer.parseInt(st.nextToken());
      int secondX = Integer.parseInt(st.nextToken());
      int secondY = Integer.parseInt(st.nextToken());
      result = sumBoard[secondX][secondY]
          - sumBoard[secondX][firstY-1]
          - sumBoard[firstX-1][secondY]
          + sumBoard[firstX-1][firstY-1];
      System.out.println(result);
    }
  }
}