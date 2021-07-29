import java.io.BufferedReader;
import java.util.*;

class Main{
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
 
            int n = Integer.valueOf(br.readLine());
            
            int dp[] = new int[n+1];
            dp[1] = 1;
            dp[2] = 2;
            for(int i=3; i<=n; i++){
                dp[i] = (dp[i - 1] + dp[i - 2])%10_007;
            }

            System.out.println(dp[n]);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
