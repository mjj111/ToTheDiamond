package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FashionKingShin {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine());

      Map<String, Integer> map = new HashMap<>();
      for (int i = 0; i < N; i++) {
        String[] input = br.readLine().split(" ");
        map.put(input[1], map.getOrDefault(input[1], 0) + 1);
      }

      int answer = 1;
      for (int value : map.values()) answer *= (value + 1);

      answer -= 1;
      System.out.println(answer);
    }
  }
}
