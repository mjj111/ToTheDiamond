package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {

  public static void main(String [] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int person = Integer.parseInt(br.readLine());
    int [] times = new int [person];

    StringTokenizer st = new StringTokenizer( br.readLine());
    for(int i=0;i<times.length;i++) times[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(times);

    int result = 0;
    for(int i=0;i<times.length;i++) result += (times[i] * (times.length - i));

    System.out.println(result);
  }
}