import java.io.BufferedReader;
import java.util.*;

import javax.imageio.plugins.tiff.FaxTIFFTagSet;

class Main {
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      int count = Integer.valueOf(br.readLine());

      while (count-- > 0) {
        int N = Integer.valueOf(br.readLine());
        long dp[] = new long[N + 1];

        if (N >= 1) dp[1] = 1;
        if (N >= 2) dp[2] = 1;
        if (N >= 3) dp[3] = 1;

        for (int i = 4; i <= N; i++) {
          dp[i] = dp[i - 3] + dp[i - 2];
        }

        sb.append(dp[N]).append("\n");
      }

      System.out.println(sb);

      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
