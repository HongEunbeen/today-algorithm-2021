import java.io.BufferedReader;
import java.util.*;

class Main {

  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      int N = Integer.valueOf(br.readLine());

      String[] str = br.readLine().split(" ");
      int dp[] = new int[N+1];
      int arr[] = new int[N+1];

      for(int i=1; i<=N; i++){
        arr[i] = Integer.valueOf(str[i-1]);
      }

      dp[1] = 1;
      dp[2] = 2;

      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= i; j++) {
          dp[i] = Math.max(dp[i], dp[i - j] + arr[j]);
        }
      }

      System.out.println(dp[N]);

      
      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
