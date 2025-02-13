package Stretching.Java;

public class ContinuousNumbersSum {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int start = 0;
    int end = 0;
    int sum = 0;

    int answer = 0;
    while(end <= N) {
      if(sum == N) {
        answer++;
        sum += ++end;
      }else if(sum < N) {
        sum += ++end;
      }else {
        sum -= ++start;
      }
    }
    System.out.println(answer);
  }

}
