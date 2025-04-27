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

    int index = 0;
    while (!list.isEmpty()) {
      index = (index + K - 1) % list.size();
      result.append(list.remove(index));

      if (!list.isEmpty()) {
        result.append(", ");
      }
    }

    result.append(">");
    System.out.println(result);
  }
}
