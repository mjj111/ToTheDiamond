package greedy;

import java.io.*;

  public class DonjunMakingGame {
    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      int[] scores = new int[N];

      for (int i = 0; i < N; i++) {
        scores[i] = Integer.parseInt(br.readLine());
      }

      int count = 0;
      for (int i = N - 2; i >= 0; i--) {
        if(scores[i] < scores[i + 1]) continue;

        int newScore = scores[i + 1] - 1;
        count += scores[i] - newScore;
        scores[i] = newScore;
      }

      System.out.println(count);
    }
  }
