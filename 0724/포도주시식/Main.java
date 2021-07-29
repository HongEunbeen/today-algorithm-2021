import java.io.BufferedReader;
import java.util.*;

class Main{
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
 
            int n = Integer.valueOf(br.readLine());
           
            int temp[] = new int[n+1];
            int dp[] = new int[n+1];
            

            for(int i=1; i<=n; i++){
                temp[i] = Integer.valueOf(br.readLine());
                if(i == 1) dp[1] = temp[1];
                if(i == 2) dp[2] = temp[1] + temp[2];
            }

            for(int i=3; i<=n; i++){
                dp[i] =  Math.max(dp[i-1],Math.max(dp[i - 2], dp[i - 3] + temp[i - 1]) + temp[i]);
            }
            System.out.println(dp[n]);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
