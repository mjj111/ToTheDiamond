package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PrincessGarden {

  static class Flower {
    int start, end;

    // 입력받은 시작 시간과 끝시간을 int형으로 바꾼다.
    Flower(int sm, int sd, int em, int ed) {
      this.start = sm * 100 + sd;
      this.end = em * 100 + ed;
    }
  }

  public static void main(String[] args) throws IOException {
    final int START_DATE = 301;  // 3월 1일
    final int END_DATE = 1201;   // 12월 1일

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    List<Flower> flowers = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int sm = Integer.parseInt(st.nextToken());
      int sd = Integer.parseInt(st.nextToken());
      int em = Integer.parseInt(st.nextToken());
      int ed = Integer.parseInt(st.nextToken());

      Flower flower = new Flower(sm, sd, em, ed);
      // 만약 1,2월만 있거나 12월만 있으면 뺀다.
      if (flower.end <= START_DATE || flower.start >= END_DATE) continue;
      flowers.add(flower);
    }

    // 시작일 오름차순, 같으면 종료일 내림차순
    // 내부 기간이 길고, start 시간이 작은 순 택한다.
    flowers.sort((a, b) -> {
      if (a.start == b.start) return b.end - a.end;
      return a.start - b.start;
    });

    int answer = 0;
    int nowIdx = 0;
    int currentEnd = START_DATE;

    while (currentEnd < END_DATE) {

      int maxEnd = currentEnd;
      while (nowIdx < flowers.size()
          && flowers.get(nowIdx).start <= currentEnd) {
        maxEnd = Math.max(maxEnd, flowers.get(nowIdx).end);
        nowIdx++;
      }

      if (maxEnd == currentEnd) {
        // 더 이상 연장할 수 없음
        System.out.println(0);
        return;
      }

      currentEnd = maxEnd;
      answer++;
    }

    System.out.println(answer);
  }
}

