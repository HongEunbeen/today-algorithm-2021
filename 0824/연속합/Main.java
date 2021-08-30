import java.io.BufferedReader;
import java.util.*;

class Main {

  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      int N = Integer.valueOf(br.readLine());

      int[] dp = new int[N + 1];

      String[] temp = br.readLine().split(" ");
      int[] arr = new int[N + 1];

      for(int i=0; i<N; i++){
        arr[i] = Integer.valueOf(temp[i]);
      }

      dp[0] = arr[0];
      int max = arr[0];

      for(int i=1; i<N; i++){
        dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        max = Math.max(max, dp[i]);
      }
      System.out.println(max);


      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
