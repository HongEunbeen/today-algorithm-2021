import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) {
    try{
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      
      String[] temp = br.readLine().split(" ");

      int C = Integer.valueOf(temp[0]);
      int N = Integer.valueOf(temp[1]);

      int dp[] = new int[C+101];
      Arrays.fill(dp, Integer.MAX_VALUE);

      dp[0] = 0;
      for(int i=0; i<N; i++){
        temp = br.readLine().split(" ");
        int cost     = Integer.parseInt(temp[0]); // 비용
        int customer = Integer.parseInt(temp[1]); // 고객
        for(int j=customer; j<C+101; j++) {
          if(dp[j-customer]!=Integer.MAX_VALUE)
            dp[j] = Math.min(dp[j], cost + dp[j-customer]);
        }
      }
      int min = Integer.MAX_VALUE;
      for(int i=C; i<C+101; i++) min = Math.min(min, dp[i]);
      System.out.println(min);
    }catch(Exception e){
        System.out.println(e);
    }
  }
}
