package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RepresentativePlayer {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    List<int[]> students = new ArrayList<>();

    for (int classId = 0; classId < N; classId++) {
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < M; i++) {
        int ability = Integer.parseInt(st.nextToken());
        students.add(new int[]{ability, classId});
      }
    }

    Collections.sort(students,(o1,o2) -> o1[0] - o2[0]);

    int[] count = new int[N];
    int total = 0;
    int start = 0;
    int minDiff = Integer.MAX_VALUE;

    for (int end = 0; end < students.size(); end++) {
      int[] curr = students.get(end);
      int endAbility = curr[0];
      int endClass = curr[1];

      count[endClass]++;
      if (count[endClass] == 1) total++;

      while (total == N) {
        int diff = endAbility - students.get(start)[0];
        minDiff = Math.min(minDiff, diff);

        int leftClassId = students.get(start)[1];
        count[leftClassId]--;
        if (count[leftClassId] == 0) total--;
        start++;
      }
    }

    System.out.println(minDiff);
  }
}
