import java.io.BufferedReader;
import java.util.*;

class Main {
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      int N = Integer.valueOf(br.readLine());

      int dp[] = new int[1001];
      dp[1] = 1;
      dp[2] = 3;

      for(int i=3; i<=N; i++){
        dp[i] = (dp[i-1] + (2*dp[i-2])) % 10007;
      }

      System.out.println(dp[N]);

      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
