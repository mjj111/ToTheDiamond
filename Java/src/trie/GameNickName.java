package trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameNickName {
  static private Set<String> nickPres;

  public static void main(String[] args) throws IOException {
    nickPres = new HashSet<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Map<String, Integer> nameCount = new HashMap<>();
    for (int i = 0; i < N; i++) {
      String nowName = br.readLine();

      int nowCount = nameCount.getOrDefault(nowName, 0) + 1;
      nameCount.put(nowName, nowCount);

      System.out.println(getNickname(nowName, nameCount));
    }
  }

  static private String getNickname(String name, Map<String, Integer> nameCount) {
    int count = nameCount.get(name);
    if (count == 1) {
      String nicknamePres = getPres(name);
      return nicknamePres;
    }
    return name + count;
  }

  static private String getPres(String name) {
    boolean isNotApplied = false;
    String answerPre = "";

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < name.length(); i++) {
      sb.append(name.charAt(i));
      String nowPre = sb.toString();

      if (!nickPres.contains(nowPre) && !isNotApplied) {
        answerPre = nowPre;
        isNotApplied = true;
      }

      nickPres.add(nowPre);
    }

    return isNotApplied ? answerPre : name;
  }
}
