import java.io.BufferedReader;
import java.util.*;

class Main {
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      int count = Integer.valueOf(br.readLine());

      int arr[] = new int[count + 1];
      int dp[] = new int[count + 1];

      for (int i = 1; i <= count; i++) {
        arr[i] = Integer.valueOf(br.readLine());
        if (i == 1)
          dp[1] = arr[1];
        if (i == 2)
          dp[2] = arr[1] + arr[2];
      }

      for (int i = 3; i <= count; i++) {
        dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
      }

      System.out.println(dp[count]);

      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
