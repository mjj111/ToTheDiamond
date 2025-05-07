package binarysearch;

import java.io.*;
import java.util.*;

public class RestAreaInstallation {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] first = br.readLine().split(" ");
    int N = Integer.parseInt(first[0]);
    int M = Integer.parseInt(first[1]);
    int L = Integer.parseInt(first[2]);

    List<Integer> list = new ArrayList<>();
    if (N > 0) {
      String[] pos = br.readLine().split(" ");
      for (String s : pos) {
        list.add(Integer.parseInt(s));
      }
    }

    list.add(0);
    list.add(L);
    Collections.sort(list);

    int left = 1;
    int right = L - 1;
    int answer = 0;

    while (left <= right) {
      int mid = (left + right) / 2;
      int count = calculateCount(list, mid);

      if (count <= M) {
        answer = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    System.out.println(answer);
  }

  private static int calculateCount(List<Integer> list, int mid) {
    int count = 0;

    for (int i = 1; i < list.size(); i++) {
      int gap = list.get(i) - list.get(i - 1);
      if (gap > mid) {
        count += (gap - 1) / mid;
      }
    }
    return count;
  }
}
