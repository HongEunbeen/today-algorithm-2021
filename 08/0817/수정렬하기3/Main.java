import java.io.BufferedReader;
import java.util.*;

class Main {
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      int count = Integer.valueOf(br.readLine());
      int[] arr = new int[count];

      for(int i=0; i<count; i++) 
        arr[i] = Integer.valueOf(br.readLine());
      
      Arrays.sort(arr);

      for (int i : arr) sb.append(i).append("\n");
      
      System.out.println(sb);
      
      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
