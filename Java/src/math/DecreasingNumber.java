package math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class DecreasingNumber {
  static List<Long> list = new ArrayList<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    //자릿수별로 만들 수 있는 감소하는 수의 개수는 조합의 수와 같다
    //모든 자릿수는 서로 다른 숫자이며, 내림차순
    // 0~9 중에서 중복 없이 k개를 중복없이 고르는 경우의 수
    // nC1  + ..+  nCn = 2**10 -1 = 1023
    // 을 정렬하여 선택하기.

    bfs();

    Collections.sort(list);

    if (N >= list.size()) System.out.println(-1);
    else System.out.println(list.get(N));
  }

  static void bfs() {
    Queue<Long> q = new LinkedList<>();

    // 한 자리 수
    for (int i = 0; i <= 9; i++) {
      q.offer((long)i);
      list.add((long)i);
    }

    while (!q.isEmpty()) {
      long num = q.poll();
      long lastDigit = num % 10;

      // 다음 자리에 더 작은 수를 붙인다
      for (int i = 0; i < lastDigit; i++) {
        long next = num * 10 + i;
        list.add(next);
        q.offer(next);
      }
    }
  }
}
