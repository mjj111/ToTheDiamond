package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MeetingRoomAssignment {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[][] room  = new int[N][2];
    for(int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int enter = Integer.parseInt(st.nextToken());
      int finish = Integer.parseInt(st.nextToken());
      room[i] = new int[] {enter, finish};
    }

    Arrays.sort(room, (o1, o2) ->{
      if(o1[1] == o2[1]) return o1[0] - o2[0];
      return o1[1] - o2[1];
    });

    int answer = 0;
    int nowTime = 0;
    for(int[] r : room) {
      int start = r[0];
      int finish = r[1];

      // 만약 시작시간이 (6시)
      // 현재시간(4시)이 크다면 접근가능하다.
      if(start < nowTime ) continue;
      answer++;
      nowTime = finish;
    }

    System.out.println(answer);
  }
}
