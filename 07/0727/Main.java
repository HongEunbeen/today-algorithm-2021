import java.io.BufferedReader;
import java.util.*;

class Main{
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
 
            String[] arr = br.readLine().split(" ");

            int n = Integer.valueOf(arr[0]);
            int k = Integer.valueOf(arr[1]);
           
            int temp[] = new int[n+1];
            int dp[] = new int[k+1];
            dp[0] = 1;

            for(int i=1; i<=n; i++){
                temp[i] = Integer.valueOf(br.readLine());
                for (int j = temp[i]; j <= k; j++)
                    dp[j] += dp[j - temp[i]];
            }

            System.out.println(dp[k]);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
