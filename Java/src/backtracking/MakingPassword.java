package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MakingPassword {
  static int L, C;
  static char[] words;
  static List<Character> answer = new ArrayList<>();
  static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    L = sc.nextInt(); // 만들 암호 길이
    C = sc.nextInt(); // 주어진 문자 개수

    words = new char[C];
    for (int i = 0; i < C; i++) {
      words[i] = sc.next().charAt(0);
    }

    Arrays.sort(words); // 사전순 정렬

    backtrack(0, 0);
  }

  static void backtrack(int length, int index) {
    if (length == L) {
      int mo = 0, ja = 0;
      for (char ch : answer) {
        if (vowels.contains(ch)) mo++;
        else ja++;
      }

      if (mo >= 1 && ja >= 2) {
        for (char ch : answer) System.out.print(ch);
        System.out.println();
      }
      return;
    }

    for (int i = index; i < C; i++) {
      answer.add(words[i]);
      backtrack(length + 1, i + 1);
      answer.remove(answer.size() - 1);
    }
  }
}