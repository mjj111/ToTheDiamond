package hash;

import java.io.*;
import java.util.*;

public class StreamingAttendance {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    String S = st.nextToken();
    String E = st.nextToken();
    String Q = st.nextToken();

    Set<String> entered = new HashSet<>();
    Set<String> attended = new HashSet<>();

    String line;
    while ((line = br.readLine()) != null && !line.isEmpty()) {
      String[] parts = line.split(" ");
      String time = parts[0];
      String name = parts[1];

      if (time.compareTo(S) <= 0) {
        entered.add(name);
      } else if (time.compareTo(E) >= 0 && time.compareTo(Q) <= 0) {
        if (entered.contains(name)) {
          attended.add(name);
        }
      }
    }

    System.out.println(attended.size());
  }
}

