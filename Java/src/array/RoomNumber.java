package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RoomNumber {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i <= 9; i++) map.put(i, 0);

    for(char c : sc.next().toCharArray()) {
      int value = map.get(c -'0') + 1;
      map.put(c -'0', value);
    }

    int answer = -1;
    for(int i = 0; i <9; i++) {
      int value = map.get(i);

      if(i == 6) {
        value += map.get(9);
        if(value % 2 == 0) value /= 2;
        else {
         value /=2;
         value++;
        }
      }

      answer = Math.max(answer, value);
    }

    System.out.println(answer);
  }
}
