package binarysearch;

import java.util.Scanner;

public class CuttingTree {
  static int[] trees;
  static int wannaget;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    wannaget = sc.nextInt();
    trees = new int[n];

    int maxTree = 0;
    for (int i = 0; i < n; i++) {
      trees[i] = sc.nextInt();
      maxTree = Math.max(maxTree, trees[i]);
    }

    int left = 0;
    int right = maxTree;
    int result = 0;

    while (left <= right) {
      int mid = (left + right) / 2;
      long sum = cuttingTree(mid);

      if (sum >= wannaget) {
        result = Math.max(mid,result);
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    System.out.println(result);
  }

  static long cuttingTree(int center) {
    long sumLog = 0;
    for (int tree : trees) {
      if (tree >= center) {
        sumLog += tree - center;
      }
    }
    return sumLog;
  }
}
