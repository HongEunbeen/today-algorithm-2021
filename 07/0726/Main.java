import java.io.BufferedReader;
import java.util.*;

class Main{
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
 
            int T = Integer.valueOf(br.readLine());

            while(T -- > 0){
                int N = Integer.valueOf(br.readLine());

                String arr1[] = br.readLine().split(" ");
                String arr2[] = br.readLine().split(" ");

                int dp[][] = new int[2][N+1];
                int temp[][] = new int[2][N+1];

                for(int i=1; i<=N; i++){
                    temp[0][i] = Integer.valueOf(arr1[i-1]);
                    temp[1][i] = Integer.valueOf(arr2[i-1]);
                }

                dp[0][1] = temp[0][1];
                dp[1][1] = temp[1][1];

                for(int i=2; i<=N; i++){
                    dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + temp[0][i];
                    dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + temp[1][i];
                }

                sb.append(Math.max(dp[0][N], dp[1][N])).append("\n");
            }

            System.out.println(sb);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
