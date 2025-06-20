package floyd;

public class FloydTypo {
  public static void main(String[] args) {
    int n = 100;
    int[][] dist = new int[n + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        dist[i][j] = 10000;
        if (i == n || j == n) dist[i][j] = 4999;
        if (i == j) dist[i][j] = 0;
      }
    }

    System.out.println(n);
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        System.out.print(dist[i][j]);
        if (j < n) System.out.print(" ");
      }
      System.out.println();
    }
  }
}