import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static int[] indegrees, timeDegrees;
    private static Map<Integer, Node> nodes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while(T-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            indegrees = new int[N+1];
            nodes = new HashMap<>();
            timeDegrees = new int[N+1];
            Arrays.fill(timeDegrees, Integer.MIN_VALUE);

            for(int i = 1; i <= N; i++) {
                nodes.putIfAbsent(i, new Node(i));
                Node now = nodes.get(i);
                now.d = sc.nextInt();
            }

            for(int i = 1; i <= K; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                indegrees[end]++;
                Node startNode = nodes.get(start);
                startNode.nexts.add(end);
            }

            int destination = sc.nextInt();

            Deque<int[]> dq = new LinkedList<>();
            for(int i = 1; i <= N; i++) {
                if(indegrees[i] != 0) continue;

                dq.addLast(new int[]{i, 0});
                Node now = nodes.get(i);
                timeDegrees[i] = now.d;
            }

            while(!dq.isEmpty()) {
                int[] value = dq.removeFirst();
                int nowTime = value[1];
                int nowNumber = value[0];

                Node now = nodes.get(nowNumber);
                if(nowNumber == destination) {
                    System.out.println( nowTime+ now.d);
                    break;
                }

                for(int next : now.nexts) {
                    indegrees[next]--;
                    timeDegrees[next] = Math.max(nowTime + now.d, timeDegrees[next]);
                    if(indegrees[next] == 0) dq.addLast(new int[]{next, timeDegrees[next]});
                }
            }
        }
    }

    private static class Node {
        int number, d;
        List<Integer> nexts;

        public Node(int number) {
            this.number = number;
            nexts = new ArrayList<>();
        }
    }
}