package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StudyGroup {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N=Integer.parseInt(st.nextToken());
    int K=Integer.parseInt(st.nextToken());
    int D=Integer.parseInt(st.nextToken());

    Student[] students = new Student[N];
    for(int i=0;i<N;i++){
      st = new StringTokenizer(br.readLine());
      int M=Integer.parseInt(st.nextToken());
      int ability=Integer.parseInt(st.nextToken());
      ArrayList<Integer> algo = new ArrayList<>(M);
      st = new StringTokenizer(br.readLine());
      while (M-->0) algo.add(Integer.parseInt(st.nextToken()));
      students[i] = new Student(ability, algo);
    }
    Arrays.sort(students, (a, b) -> a.ability - b.ability);

    int arr[]=new int[K+1];
    int max=0;
    int start=0;
    int end=0;
    for(int i:students[0].algorithms){
      arr[i]++;
    }

    while(true){
      int gap=students[end].ability-students[start].ability;
      if(gap<=D){
        max = Math.max(max,getE(arr,start,end));
        end++;
        if(end>=N) break;
        for(int i:students[end].algorithms){
          arr[i]++;
        }
      }
      else{
        for(int i:students[start].algorithms){
          arr[i]--;
        }
        start++;
      }
    }
    System.out.println(max);
  }

  public static class Student {
    int ability;
    ArrayList<Integer> algorithms;

    public Student(int ability, ArrayList<Integer> algorithms) {
      this.ability = ability;
      this.algorithms = algorithms;
    }
  }

  public static int getE(int[] arr,int start,int end){
    int someone=0;
    int everyone=0;
    int num=end-start+1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) someone++;
      if (arr[i] == num) everyone++;
    }
    return (someone-everyone)*num;
  }
}