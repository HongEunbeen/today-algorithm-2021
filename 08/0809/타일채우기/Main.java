import java.io.BufferedReader;
import java.util.*;

class Main {

  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      int N = Integer.valueOf(br.readLine());
      
      int dp[] = new int[N+1];


      if(N%2 == 1)
        System.out.println(0);
     else {
       dp[0] = 1;
       dp[1] = 1;
       dp[2] = 3;

       for (int i = 4; i <= N; i += 2) {
         dp[i] = dp[i - 2] * dp[2];
         for (int j = i - 4; j >= 0; j -= 2) {
           dp[i] += dp[j] * 2;
         }
       }
       System.out.println(dp[N]);
     }
      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
