import java.io.BufferedReader;
import java.util.*;

class Main{
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int N = Integer.valueOf(br.readLine());
    
            int[] dp = new int[N+1];

            dp[0] = 0;
            dp[1] = 1;
            if(N > 1) dp[2] = 2;

            for(int i=3; i<=N; i++){
                dp[i] = (dp[i-1] + dp[i-2]) % 15746;
            }

            System.out.println(dp[N]);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
