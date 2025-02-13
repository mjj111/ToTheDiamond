package Stretching.Java;

class NumbersSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String numbers = br.readLine();
        int sum = 0;
        for(char number : numbers.toCharArray()) {
          sum += number - '0';
        }

        System.out.println(sum);
    }
}
