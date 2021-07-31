import java.io.BufferedReader;
import java.util.*;

import javax.imageio.plugins.tiff.FaxTIFFTagSet;

class Main {
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      int N = Integer.valueOf(br.readLine());

      int[][] dp = new int[N + 1][3];
      dp[1][0] = 1;
      dp[1][1] = 1;
      dp[1][2] = 1;

      for (int i = 2; i <= N; i++) {
        dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
        dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
        dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
      }

      System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % 9901 + "");

      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
