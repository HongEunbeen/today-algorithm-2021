import java.io.BufferedReader;
import java.util.*;

class Main{
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
          
            int count = Integer.valueOf(br.readLine());
            int dp[][] = new int[1001][3];

            for(int i=0; i< count; i++){
                String str[] = br.readLine().split(" ");

                int red = Integer.valueOf(str[0]);
                int green = Integer.valueOf(str[1]);
                int blue = Integer.valueOf(str[2]);
                
                if(i == 0){
                    dp[i][0] = red;
                    dp[i][1] = green;
                    dp[i][2] = blue;
                    continue;
                }
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + red;
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + green;
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + blue;

            }
            
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                if (dp[count-1][i] < ans) ans = dp[count-1][i];
            }

            System.out.println(ans);
            br.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
