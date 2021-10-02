import java.io.BufferedReader;
import java.lang.reflect.Array;
import java.util.*;

import jdk.nashorn.api.tree.ContinueTree;

class Main {

  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      int n = Integer.parseInt(br.readLine());
      int nCard[] = new int[n];
      String[] str = br.readLine().split(" ");

      for(int i=0; i<n; i++){
        nCard[i] = Integer.valueOf(str[i]);
      }

      Arrays.sort(nCard);


      int m = Integer.parseInt(br.readLine());
      int mCard[] = new int[m];
      String[] str2 = br.readLine().split(" ");

      for (int i = 0; i < m; i++) {
        mCard[i] = Integer.valueOf(str2[i]);
      }

      

      int left = 0;
      int right = nCard.length - 1;
      int mid = 0;
      boolean flag = false;

      for(int i=0; i<m; i++){
        left = 0;
        right = n - 1;

        while (left <= right) {
          mid = (left + right) / 2;
          if (mCard[i] == nCard[mid]){
            sb.append(1).append(" "); flag = true; break;
          }
          else if (mCard[i] < nCard[mid]) right = mid - 1;
          else left = mid + 1;
        }
        if(!flag) 
          sb.append(0).append(" ");
          
        flag = false;
        
      }
      
      System.out.println(sb);
     
      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
