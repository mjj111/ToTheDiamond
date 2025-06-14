package binarysearch;

import java.util.*;
import java.io.*;

public class Good{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] numbers = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) numbers[i] =  Integer.parseInt(st.nextToken());

    Arrays.sort(numbers);

    int answer = 0;
    for (int i = 0; i < N; i++) {
      int target = numbers[i];
      int start = 0;
      int end = N - 1;

      while(start < end) {
        int sum = numbers[start] + numbers[end];

        if (sum == target) {
          if (start != i && end != i) {
            answer += 1;
            break;
          }
        }

        if (sum < target || start == i) start += 1;
        else end -= 1;
      }
    }
    System.out.println(answer);
  }
}