package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Multibus2 {
  static int universeCount, planetCount;
  static int[][] universes;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    universeCount = Integer.parseInt(st.nextToken());
    planetCount = Integer.parseInt(st.nextToken());

    universes = new int[universeCount][planetCount];

    for (int i = 0; i < universeCount; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < planetCount; j++) {
        universes[i][j] = Integer.parseInt(st.nextToken());
      }
      compressRanks(universes[i]);
    }

    int equalPairs = 0;
    for (int i = 0; i < universeCount - 1; i++) {
      for (int j = i + 1; j < universeCount; j++) {
        if (Arrays.equals(universes[i], universes[j])) {
          equalPairs++;
        }
      }
    }

    System.out.println(equalPairs);
  }

  static void compressRanks(int[] arr) {
    int[] sorted = arr.clone();
    Arrays.sort(sorted);

    Map<Integer, Integer> rankMap = new HashMap<>();
    int rank = 0;

    for (int val : sorted) {
      if (!rankMap.containsKey(val)) {
        rankMap.put(val, rank++);
      }
    }

    for (int i = 0; i < arr.length; i++) {
      arr[i] = rankMap.get(arr[i]);
    }
  }
}