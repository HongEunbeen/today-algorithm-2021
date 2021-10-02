import java.io.BufferedReader;
import java.util.*;

class Main{
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
 
            int dp[][] = new int[31][31];

            int count = Integer.valueOf(br.readLine());

            for(int i=0; i<30; i++){
                dp[i][i] = 1;
                dp[i][0] = 1;
            }

            for(int i=2; i<30; i++){
                for(int j=1; j < 30; j++){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }


            for(int i=1; i<=count; i++){
                String[] temp = br.readLine().split(" ");
                sb.append(dp[Integer.valueOf(temp[1])][Integer.valueOf(temp[0])]).append("\n");
            }

            System.out.println(sb);

           
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
