package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ConveyorBeltSushi {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int category = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int coupon = Integer.parseInt(st.nextToken());

    int[] sushi = new int[N];
    for(int i = 0; i < N; i++) sushi[i] = Integer.parseInt(br.readLine());

    Map<Integer, Integer> eatHistory = new HashMap<>();
    int answer;

    for(int i = 0; i < K; i++) eatHistory.put(sushi[i], eatHistory.getOrDefault(sushi[i], 0) + 1);
    if(eatHistory.containsKey(coupon)) answer = eatHistory.size();
    else answer = eatHistory.size() + 1;

    for(int i = 1; i < N; i++) {
      int removeIdx = sushi[(i - 1) % N];
      int addIdx = sushi[(i + K - 1) % N];

      eatHistory.put(removeIdx, eatHistory.get(removeIdx) - 1);
      if(eatHistory.get(removeIdx) == 0) eatHistory.remove(removeIdx);

      eatHistory.put(addIdx, eatHistory.getOrDefault(addIdx, 0) + 1);

      int currentSize = eatHistory.size();
      if (!eatHistory.containsKey(coupon)) currentSize++;

      answer = Math.max(answer, currentSize);
    }

    System.out.println(answer);
  }
}
