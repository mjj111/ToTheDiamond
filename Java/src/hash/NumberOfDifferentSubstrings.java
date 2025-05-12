package hash;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NumberOfDifferentSubstrings {
  public static void main(String[] args) {
    String s = new Scanner(System.in).nextLine();
    Set<String> set = new HashSet<>();

    for (int i = 0; i < s.length(); i++)
      for (int j = i + 1; j <= s.length(); j++)
        set.add(s.substring(i, j));

    System.out.println(set.size());
  }
}
