import java.io.BufferedReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

import jdk.nashorn.api.tree.ContinueTree;

class Main {

  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      String[] str = br.readLine().split(" ");

      int count = Integer.valueOf(str[0]);
      int delete = Integer.valueOf(str[1]);

      Queue<Integer> queue = new LinkedList<>();

      for(int i=1; i<=count; i++) queue.add(i);

      sb.append("<");

      while(!queue.isEmpty()){
        for (int i=0; i < delete; i++) {
          if (i == delete - 1) sb.append(queue.poll()).append(", ");
          else queue.add(queue.poll());
        }
      }
      
      sb.delete(sb.length()-2, sb.length());
      sb.append(">");
      
      System.out.println(sb);
     
      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
