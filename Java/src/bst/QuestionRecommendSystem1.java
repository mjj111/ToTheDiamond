package bst;

import java.io.*;
import java.util.*;

public class QuestionRecommendSystem1 {
  static class Problem implements Comparable<Problem> {
    int id, level;

    public Problem(int id, int level) {
      this.id = id;
      this.level = level;
    }

    @Override
    public int compareTo(Problem o) {
      if (this.level == o.level) return this.id - o.id;
      return this.level - o.level;
    }
  }

  public static void main(String[] args) throws IOException {
    TreeSet<Problem> set = new TreeSet<>();
    Map<Integer, Integer> hardMap = new HashMap<>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int p = Integer.parseInt(st.nextToken());
      int l = Integer.parseInt(st.nextToken());
      set.add(new Problem(p, l));
      hardMap.put(p, l);
    }

    int Q = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < Q; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String cmd = st.nextToken();

      if (cmd.equals("add")) {
        int p = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        set.add(new Problem(p, l));
        hardMap.put(p, l);
      }

      if (cmd.equals("recommend")) {
        int x = Integer.parseInt(st.nextToken());
        if (x == 1) {
          sb.append(set.last().id).append("\n");
        } else {
          sb.append(set.first().id).append("\n");
        }
      }

      if (cmd.equals("solved")) {
        int p = Integer.parseInt(st.nextToken());
        int l = hardMap.get(p);
        set.remove(new Problem(p, l));
        hardMap.remove(p);
      }
    }

    System.out.print(sb);
  }
}
