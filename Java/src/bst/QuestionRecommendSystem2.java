package bst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

class QuestionRecommendSystem2 {

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    TreeSet<Problem> tree = new TreeSet<>();
    List<TreeSet<Problem>> subtrees = new ArrayList<>();
    for (int i = 0; i <= 100; i++) subtrees.add(new TreeSet<>());
    HashMap<Integer, int[]> hMap = new HashMap<>();

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int no = Integer.parseInt(st.nextToken());
      int level = Integer.parseInt(st.nextToken());
      int group = Integer.parseInt(st.nextToken());

      Problem p = new Problem(no, level, group);
      subtrees.get(group).add(p);
      tree.add(p);
      hMap.put(no, new int[]{level, group});
    }

    int M = Integer.parseInt(br.readLine());
    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String command = st.nextToken();

      if (command.equals("recommend")) {
        int group = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        if (x == 1) sb.append(subtrees.get(group).last().no).append("\n");
        else sb.append(subtrees.get(group).first().no).append("\n");
      }

      if (command.equals("recommend2")) {
        int x = Integer.parseInt(st.nextToken());
        if (x == 1) sb.append(tree.last().no).append("\n");
        else sb.append(tree.first().no).append("\n");
      }

      if (command.equals("recommend3")) {
        int x = Integer.parseInt(st.nextToken());
        int level = Integer.parseInt(st.nextToken());
        if (x == 1) {
          Problem p = tree.ceiling(new Problem(0, level, 0));
          sb.append(p == null ? -1 : p.no).append("\n");
        } else {
          Problem p = tree.lower(new Problem(0, level, 0));
          sb.append(p == null ? -1 : p.no).append("\n");
        }
      }

      if (command.equals("add")) {
        int no = Integer.parseInt(st.nextToken());
        int level = Integer.parseInt(st.nextToken());
        int group = Integer.parseInt(st.nextToken());

        Problem p = new Problem(no, level, group);
        subtrees.get(group).add(p);
        tree.add(p);
        hMap.put(no, new int[]{level, group});
      }

      if (command.equals("solved")) {
        int no = Integer.parseInt(st.nextToken());
        if (!hMap.containsKey(no)) continue;

        int[] info = hMap.get(no);
        int level = info[0];
        int group = info[1];

        Problem p = new Problem(no, level, group);
        hMap.remove(no);
        tree.remove(p);
        subtrees.get(group).remove(p);
      }
    }

    System.out.println(sb.toString());
  }

  static class Problem implements Comparable<Problem> {
    int no;
    int level;
    int group;

    public Problem(int no, int level, int group) {
      this.no = no;
      this.level = level;
      this.group = group;
    }

    @Override
    public int compareTo(Problem o) {
      if (level == o.level) {
        return Integer.compare(no, o.no);
      }
      return Integer.compare(level, o.level);
    }
  }
}
