package hash;

import java.io.*;
import java.util.*;

public class FindPassword {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 저장된 사이트 수
    int M = Integer.parseInt(st.nextToken()); // 비밀번호 찾을 사이트 수

    Map<String, String> map = new HashMap<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      String site = st.nextToken();
      String password = st.nextToken();
      map.put(site, password);
    }

    for (int i = 0; i < M; i++) {
      String query = br.readLine();
      bw.write(map.get(query));
      bw.newLine();
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
