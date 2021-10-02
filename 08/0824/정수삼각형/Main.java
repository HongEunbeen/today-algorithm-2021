import java.io.BufferedReader;
import java.util.*;

class Main {

  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      int N = Integer.valueOf(br.readLine());

      int[][] arr = new int[N][N];
      int[][] dp = new int[N][N];
      StringTokenizer st;
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j < i + 1; j++) {
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      for (int i = 0; i < N; i++) {
        dp[N - 1][i] = arr[N - 1][i];
      }

      for(int i = N-1; i>0; i--){
        for(int j = 0; j < N-1; j++){
          dp[i-1][j] = Math.max(arr[i - 1][j] + dp[i][j], arr[i - 1][j] + dp[i][j+1]);
        }
      }

      System.out.println(dp[0][0]);

      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
