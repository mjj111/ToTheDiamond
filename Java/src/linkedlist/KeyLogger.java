package linkedlist;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class KeyLogger {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int testCase = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < testCase; i++) {
      test(sc.nextLine());
    }
  }

  public static void test(String input) {
    LinkedList<Character> list = new LinkedList<>();
    ListIterator<Character> cursor = list.listIterator();

    for (char c : input.toCharArray()) {
      if (c == '<') {
        if (cursor.hasPrevious()) {
          cursor.previous();
        }
      } else if (c == '>') {
        if (cursor.hasNext()) {
          cursor.next();
        }
      } else if (c == '-') {
        if (cursor.hasPrevious()) {
          cursor.previous();
          cursor.remove();
        }
      } else {
        cursor.add(c);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (char ch : list) {
      sb.append(ch);
    }
    System.out.println(sb);
  }
}
