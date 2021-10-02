import java.io.BufferedReader;

class Main {
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      int T = Integer.valueOf(br.readLine());

      while (T-- > 0) {
        int K = Integer.valueOf(br.readLine());

        int dp[][] = new int[502][502];
        int arr[] = new int[K + 1];
        int sum[] = new int[K + 1];

        String str[] = br.readLine().split(" ");
        for (int i = 1; i <= K; i++) {
          arr[i] = Integer.valueOf(str[i - 1]);
          sum[i] = sum[i - 1] + arr[i];
        }

        for (int i = 2; i <= K; i++) {
          for (int j = i - 1; j > 0; j--) {
            dp[j][i] = Integer.MAX_VALUE;
            for (int s = j; s <= i; s++)
              dp[j][i] = Math.min(dp[j][i], dp[j][s] + dp[s + 1][i]);
            dp[j][i] += sum[i] - sum[j - 1];
          }
        }

        sb.append(dp[1][K]).append("\n");
      }

      System.out.println(sb);

      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
