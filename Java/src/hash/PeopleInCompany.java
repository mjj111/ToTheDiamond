package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PeopleInCompany {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Set<String> comapny = new HashSet<>();
    for(int i = 0 ; i < N ; i++) {
      String[] input = br.readLine().split(" ");
      if(input[1].equals("enter")) {
        comapny.add(input[0]);
      }else {
        comapny.remove(input[0]);
      }
    }

    List<String> answer = new ArrayList<>(comapny);
    Collections.sort(answer, Collections.reverseOrder());
    for(String s : answer) System.out.println(s);
  }
}
