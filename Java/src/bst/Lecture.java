package bst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Lecture {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    ArrayList<Student> students = new ArrayList<>();
    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      Student s = new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      students.add(s);
    }
    Collections.sort(students);

    TreeSet<Integer> set = new TreeSet<>();
    int[] countOfGroup = new int[N + 1];

    int result = 0;
    for (int i = 0; i < N; i++) {
      Student s = students.get(i);
      Integer findGroupCurSize = set.lower(s.k);

      if (findGroupCurSize == null) { // 새로운 팀 추가
        set.add(1);
        countOfGroup[1]++;
        result++;
        continue;
      }

      countOfGroup[findGroupCurSize]--;
      if (countOfGroup[findGroupCurSize] == 0) set.remove(findGroupCurSize);

      countOfGroup[findGroupCurSize + 1]++;
      if (countOfGroup[findGroupCurSize + 1] == 1) set.add(findGroupCurSize + 1);
    }

    System.out.println(result);
  }

  static class Student implements Comparable<Student> {
    final int h;
    final int k;

    public Student(int h, int k) {
      this.h = h;
      this.k = k;
    }

    @Override
    public int compareTo(Student o) {
      return o.h -h;
    }
  }

}