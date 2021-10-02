import java.io.BufferedReader;
import java.util.*;

class Main {
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      int count = Integer.valueOf(br.readLine());
      ArrayList<Integer> list = new ArrayList<>();

      for(int i=0; i<count; i++) 
        list.add(Integer.valueOf(br.readLine()));
      
      Collections.sort(list);

      for (int i : list) sb.append(i).append("\n");
      
      System.out.println(sb);
      
      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
