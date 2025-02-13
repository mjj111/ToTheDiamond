package Stretching.Java;

public class PrefixSum1D {
    private static int[] prefixSum;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        prefixSum = new int[N+1];

        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N+1];
        for(int i = 0; i < N; i++) {
          numbers[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
          prefixSum[i] = prefixSum[i -1] + numbers[i-1];
        }

        for(int i = 0; i < Q; i++) {
          st = new StringTokenizer(br.readLine());
          int start = Integer.parseInt(st.nextToken());
          int end = Integer.parseInt(st.nextToken());

          System.out.println(query(start, end));
        }
    }
    private static int query(int start, int end) {
        return prefixSum[end] - prefixSum[start-1];
    }
}
