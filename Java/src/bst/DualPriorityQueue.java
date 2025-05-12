package bst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class DualPriorityQueue {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(br.readLine());
    while(t-->0){
      int input = Integer.parseInt(br.readLine());

      TreeMap<Integer, Integer> map = new TreeMap<>();
      for(int i=0; i<input; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String op = st.nextToken();

        if(op.equals("I")) {
          int num = Integer.parseInt(st.nextToken());
          map.put(num, map.getOrDefault(num, 0)+1);
        }

        if(op.equals("D")) {
          if(map.size()==0) continue;

          int type = Integer.parseInt(st.nextToken());
          int num;

          if(type == 1) num = map.lastKey();
          else num = map.firstKey();

          if(map.put(num, map.get(num)-1)==1)  map.remove(num);
        }
      }

      if (map.isEmpty()) sb.append("EMPTY\n");
      else sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
    }
    System.out.println(sb);
  }
}