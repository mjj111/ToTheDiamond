package linkedlist;

import java.util.*;

public class Josephus {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();

    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 1; i <= N; i++) list.add(i);

    StringBuilder result = new StringBuilder("<");
    ListIterator<Integer> cursor = list.listIterator();

    while (!list.isEmpty()) {
      // K번째까지 이동
      for (int i = 0; i < K; i++) {
        if (!cursor.hasNext()) {
          cursor = list.listIterator(); // 원형 순회
        }
        cursor.next();
      }

      // 커서가 K번째 뒤로 가 있으므로 한 칸 뒤로 가서 제거
      cursor.previous();
      result.append(cursor.next());
      cursor.remove();

      if (!list.isEmpty()) {
        result.append(", ");
      }
    }

    result.append(">");
    System.out.println(result);
  }
}
