package priorityqueue;

import java.io.*;
import java.util.*;

class NthBiggestNumber {
  static class Element implements Comparable<Element> {
    int value, row, col;

    Element(int value, int row, int col) {
      this.value = value;
      this.row = row;
      this.col = col;
    }

    @Override
    public int compareTo(Element o) {
      return o.value - this.value;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] matrix = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    PriorityQueue<Element> pq = new PriorityQueue<>();

    for (int i = 0; i < N; i++) {
      pq.add(new Element(matrix[N - 1][i], N - 1, i));
    }

    int count = 0, answer = 0;

    while (count < N) {
      Element now = pq.poll();
      answer = now.value;
      count++;

      if (now.row - 1 >= 0) {
        pq.add(new Element(matrix[now.row - 1][now.col], now.row - 1, now.col));
      }
    }

    System.out.println(answer);
  }
}