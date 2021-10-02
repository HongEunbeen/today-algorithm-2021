import java.io.BufferedReader;
import java.util.*;

import javax.imageio.plugins.tiff.FaxTIFFTagSet;

class Main {
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      int count = Integer.valueOf(br.readLine());

      int dp[] = new int[12];

      dp[1] = 1;
      dp[2] = 2;
      dp[3] = 4;
      for (int i = 4; i <= 11; i++) {
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
      }

      while (count-- > 0) {
        int N = Integer.valueOf(br.readLine());
        sb.append(dp[N]).append("\n");
      }

      System.out.println(sb);

      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
