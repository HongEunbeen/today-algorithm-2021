import java.io.BufferedReader;
import java.util.*;

class Main {

  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      String[] str = br.readLine().split("");

      Arrays.sort(str, Collections.reverseOrder());

      for(String item : str){
        sb.append(item);
      }

      System.out.println(sb);

     
      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
