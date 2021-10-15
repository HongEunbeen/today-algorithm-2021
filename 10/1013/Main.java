import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    try{
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
     
      int N = Integer.valueOf(br.readLine());

      int[][] dp = new int[N+1][10];

      for(int i =0; i<10; i++){
        dp[1][i] = 1;
      }
      
      for(int i=2; i<=N; i++){
        for(int j=0; j<10; j++){
          for(int k=0; k<=j; k++){
            dp[i][j] += dp[i-1][k];
            dp[i][j] %= 10007;
          }
        }
      }

      System.out.println(Arrays.stream(dp[N]).sum()%10007);
      
    }catch(Exception e){
        System.out.println(e);
    }
  }
}
