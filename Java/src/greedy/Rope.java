package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Rope {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Integer[] ropes = new Integer[N];
    for(int i = 0; i < N; i++) {
      ropes[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(ropes, Collections.reverseOrder());

    //K개의 로프를 이용하여 w인 물체를 올릴 떄 고르게 w/k 중량이 걸린다.\
    //주어진 로프들 중에서 지금이 가장 작은 값이기에
    // 현재 크기 * 개수 -> 감당 가능한 무게다.

    int maxPower = -1;
    for(int i = 0; i < N; i++) {
      int rope = ropes[i];
      int nowPower = rope * (i+1);
      maxPower = Math.max(nowPower, maxPower);
    }

    System.out.println(maxPower);
  }
}
