package greedy;

import java.io.*;
import java.util.*;

public class LineUp {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] position = new int[N + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int number = Integer.parseInt(st.nextToken());
      position[number] = i;
    }

    int longest = 1;
    int count = 1;

    for (int i = 1; i < N; i++) {
      if (position[i] < position[i + 1]) {
        count++;
      } else {
        longest = Math.max(longest, count);
        count = 1;
      }
    }
    longest = Math.max(longest, count);

    System.out.println(N == 1 ? 0 : N - longest);
  }
}
