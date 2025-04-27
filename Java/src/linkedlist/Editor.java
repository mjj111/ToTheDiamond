package linkedlist;

import java.io.*;
import java.util.*;

public class Editor {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    int M = Integer.parseInt(br.readLine());

    LinkedList<Character> list = new LinkedList<>();

    for(int i = 0; i < str.length(); i++) {
      list.add(str.charAt(i));
    }

    ListIterator<Character> iter = list.listIterator(list.size());

    for(int i = 0; i < M; i++) {
      String command = br.readLine();
      char c = command.charAt(0);
      switch(c) {
        case 'L':
          if(iter.hasPrevious())
            iter.previous();

          break;
        case 'D':
          if(iter.hasNext())
            iter.next();

          break;
        case 'B':
          if(iter.hasPrevious()) {
            iter.previous();
            iter.remove();
          }
          break;
        case 'P':
          char t = command.charAt(2);
          iter.add(t);

          break;
        default:
          break;
      }
    }
    for(Character chr : list) {
      bw.write(chr);
    }

    bw.flush();
    bw.close();
  }
}