package A_stretching;

class NumbersAver {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        int maxValue = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < N; i++) {
          numbers[i] = Integer.parseInt(st.nextToken());
          maxValue = Math.max(maxValue, numbers[i]);
          sum += numbers[i];
        }

        System.out.println(sum * 100 / maxValue / N);
    }
}
