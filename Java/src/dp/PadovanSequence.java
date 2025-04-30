package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PadovanSequence {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    while(n-- > 0) {
      int num = Integer.parseInt(br.readLine());
      getAnswer(num);
    }
  }

  public static void getAnswer(int num) {
    System.out.println(num);
  }
}
