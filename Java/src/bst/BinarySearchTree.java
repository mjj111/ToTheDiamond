package bst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

class BinarySearchTree {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] len = new int[N];
    long ans = 0;
    TreeSet<Integer> tree = new TreeSet<>();

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      if (tree.higher(num) == null) { // 현재 가장 큰 값(오른쪽)
        if (tree.lower(num) == null) len[num] = 1; // 본인이 처음이라면 1
        else len[num] = len[tree.lower(num)]+1; // 이전 작은값 + 1 이 현재 위치
      }

      else {  // 현재 가장 크지않음
        if (tree.lower(num) == null) len[num] = len[tree.higher(num)] + 1; // 만약 현재 가장 작다면 본인보다 큰값 보다 +1
        else len[num] = Math.max(len[tree.higher(num)], len[tree.lower(num)]) + 1; // 만약 현재 가장 크지도 작지도 않다면 오른쪽왼쪽중 가장 높은 깊이 + 1
      }

      ans += len[num];
      tree.add(num);
    }

    System.out.println(ans);
  }
}