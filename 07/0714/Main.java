import java.io.BufferedReader;
import java.util.*;

class Main{
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
          
            int count = Integer.valueOf(br.readLine());
            int profit[] = new int[1001];
            int time[] = new int[1001];
            int dp[] = new int[1001];
            int result = 0;

            for(int i=1; i <= count; i++){
                String str[] = br.readLine().split(" ");

                time[i] = Integer.valueOf(str[0]);
                profit[i] = Integer.valueOf(str[1]);
               
            }

            for(int i=1; i <= count; i++){
                //i번째 존재
                if(i+time[i] <=count+1){
                    dp[i+time[i]] = Math.max(dp[i+time[i]], dp[i] + profit[i]);
                    result = Math.max(result, dp[i+time[i]]);
                }
                //i번째 미 존재
                dp[i+1] = Math.max(dp[i+1], dp[i]);
                result = Math.max(result, dp[i+1]);
            }
            
            System.out.println(result);
            br.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
