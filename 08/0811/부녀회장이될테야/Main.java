import java.io.BufferedReader;
import java.util.*;

class Main {

  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      int count = Integer.parseInt(br.readLine());

      while(count-- > 0){
        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        if(k == n && n == 0){
          sb.append(1).append("\n");
          continue;
        }

        int arr[][] = new int[k+1][n];

        for(int i=0; i<=k; i++){
          for(int j=0; j<n; j++){
            if(j == 0) arr[i][j] = 1;
            else if(i == 0) arr[i][j] = arr[i][j-1] + 1;
            else arr[i][j] = arr[i][j-1] + arr[i-1][j];
          }
        }

        sb.append(arr[k][n-1]).append("\n");
      }
      
      System.out.println(sb);
     
      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
