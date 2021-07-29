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
            for(int i=2; i<=n; i++){
                if(i == 2) dp[2] = 2;
                else dp[i] = (dp[i - 1] + dp[i - 2])%10007;
            }

            System.out.println(dp[n] + "");
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
