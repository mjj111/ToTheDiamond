import java.io.*;
import java.util.*;

class Main {

    private static ArrayList<Integer>[] friends;
    private static int[][] dp;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        friends = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            friends[i] = new ArrayList<>();
        }

        dp = new int[N + 1][2];
        visited = new boolean[N + 1];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            friends[start].add(end);
            friends[end].add(start);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void dfs(int now) {
        visited[now] = true;

        for (int friend : friends[now]) {
            if (!visited[friend]) {
                dfs(friend);
                dp[now][1] += Math.min(dp[friend][0], dp[friend][1]);// 내가 얼리어답터인 경우 자식이 얼리어답터 혹은 아닌경우의 최소값을 가진다.
                dp[now][0] += dp[friend][1]; // 내가 얼리어답터가 아닌 경우 친구는 얼리어답터여야하며 값을 얻는다.
            }
        }
        dp[now][1]++;// 본인 추가
    }
}