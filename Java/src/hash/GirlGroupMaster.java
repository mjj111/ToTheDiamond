package hash;

import java.io.*;
import java.util.*;

public class GirlGroupMaster {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    Map<String, List<String>> teamToMembers = new HashMap<>();
    Map<String, String> memberToTeam = new HashMap<>();

    for (int i = 0; i < N; i++) {
      String teamName = br.readLine();
      int count = Integer.parseInt(br.readLine());

      List<String> members = new ArrayList<>();
      for (int j = 0; j < count; j++) {
        String member = br.readLine();
        members.add(member);
        memberToTeam.put(member, teamName);
      }
      teamToMembers.put(teamName, members);
    }

    for (int i = 0; i < M; i++) {
      String quiz = br.readLine();
      int type = Integer.parseInt(br.readLine());

      if (type == 0) {
        List<String> members = teamToMembers.get(quiz);
        Collections.sort(members);
        for (String member : members) {
          bw.write(member + "\n");
        }
      } else {
        bw.write(memberToTeam.get(quiz) + "\n");
      }
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
