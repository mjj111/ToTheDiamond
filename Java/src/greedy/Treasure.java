package greedy;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Treasure {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N  = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    Integer[] A = new Integer[N];
    for(int i  = 0 ; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
    Arrays.sort(A);

    st = new StringTokenizer(br.readLine());
    Integer[] B = new Integer[N];
    for(int i  = 0 ; i < N; i++) B[i] = Integer.parseInt(st.nextToken());
    Arrays.sort(B, Collections.reverseOrder());
    // B의 큰 순서에 맞게
    // A의 작은 순서에 맞게 곱해주면 된다.

    int answer = 0;
    for(int i = 0; i < N; i++) answer += A[i] * B[i];

    System.out.println(answer);
  }
}
