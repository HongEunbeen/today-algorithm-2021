import java.io.BufferedReader;
import java.util.*;

class Main {
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      ArrayDeque<Integer> dq = new ArrayDeque<Integer>();

      int N = Integer.valueOf(br.readLine());

      for (int i = 0; i < N; i++) {
        String temp[] = br.readLine().split(" ");

        String key = temp[0];

        switch(key){
          case "push_front":
            dq.addFirst(Integer.valueOf(temp[1])); break;
          case "push_back": 
            dq.addLast(Integer.valueOf(temp[1])); break;
          case "pop_front":
            if(dq.isEmpty())sb.append("-1").append("\n");
            else sb.append(dq.pollFirst()).append("\n"); 
            break;
          case "pop_back":
            if (dq.isEmpty()) sb.append("-1").append("\n");
            else sb.append(dq.pollLast()).append("\n"); 
            break;
          case "size":
            sb.append(dq.size()).append("\n"); break;
          case "empty":
            if(dq.isEmpty()) sb.append("1").append("\n");
            else sb.append("0").append("\n");
            break;
          case "front":
            if (dq.isEmpty()) sb.append("-1").append("\n");
            else sb.append(dq.peekFirst()).append("\n");
            break;
          case "back":
            if (dq.isEmpty()) sb.append("-1").append("\n");
            else sb.append(dq.peekLast()).append("\n");
            break;
          default: break;
        }
      }
      
      System.out.println(sb);
      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
