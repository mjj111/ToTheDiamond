package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumberCount {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long answer = 1;
    for(int i = 0; i < 3; i++) {
      answer*= sc.nextInt();
    }

    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i <= 9; i++) map.put(i, 0);

    for(char c: String.valueOf(answer).toCharArray()) {
      int num = c - '0';
      int value = map.get(num) + 1;
      map.put(num, value);
    }
    System.out.println(map.keySet());
    for(int i = 0; i <= 9; i++) System.out.println(map.get(i));
  }
}
