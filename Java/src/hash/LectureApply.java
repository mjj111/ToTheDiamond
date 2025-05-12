package hash;

import java.io.*;
import java.util.*;

public class LectureApply {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int K = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    LinkedHashMap<String, Boolean> map = new LinkedHashMap<>();

    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      map.remove(input);
      map.put(input, true);
    }

    int count = 0;
    for (String key : map.keySet()) {
      System.out.println(key);
      count++;
      if (count == K) break;
    }
  }
}
