import java.io.BufferedReader;
import java.util.*;

class Main{
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            ArrayList<Integer> list = new ArrayList<>();
            
            String[] temp = br.readLine().split(" ");

            int N = Integer.valueOf(temp[0]);
            int K = Integer.valueOf(temp[1]);


            int dp[][] = new int[N+1][K+1];

            int W[] = new int[N+1];
            int V[] = new int[N+1];

            for(int i=1; i<=N; i++){
                temp = br.readLine().split(" ");
                W[i] = Integer.valueOf(temp[0]);
                V[i] = Integer.valueOf(temp[1]);
            }

            for(int i=1; i<=N; i++){
                for(int j=1; j<=K; j++){
                    dp[i][j] = dp[i-1][j];
                    if(j - W[i]>=0) {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]]+V[i]);
                    }
                }

            }


            System.out.println(dp[N][K]);

           
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
