import java.io.BufferedReader;
import java.util.*;

class Main{
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int N = Integer.valueOf(br.readLine());

            long[][] dp = new long[N+1][10];
            
            long result = 0;

            for(int i=1; i<=9; i++){
                dp[1][i] = 1;
            }

            

            for(int i=2; i<=N; i++){
                for(int j=0; j<=9; j++){
                    if(j == 0) dp[i][0] = dp[i-1][1] % 1000000000L;
                    else if(j == 9) dp[i][9] = dp[i-1][8] % 1000000000L;
                    else dp[i][j] =  (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000L;
                }
            }

            for(int i=0; i<10; i++){
                result += dp[N][i];    
            }

            System.out.println(result % 1000000000L);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
