import java.io.BufferedReader;
import java.util.*;

class Main {
  static int factorial(int N) {
    if (N <= 1) {
      return 1;
    }
    return N * factorial(N - 1);
  }
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
    
      char[] str1 = br.readLine().toCharArray();
      char[] str2 = br.readLine().toCharArray();

      int length_1 = str1.length;
      int length_2 = str2.length;

      int[][] dp = new int[length_1 + 1][length_2 + 1];
      
      for (int i = 1; i <= length_1; i++) {
        for (int j = 1; j <= length_2; j++) {
          if (str1[i - 1] == str2[j - 1]) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
          }

          else {
            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
          }
        }
      }
      System.out.println(dp[length_1][length_2]);

      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
