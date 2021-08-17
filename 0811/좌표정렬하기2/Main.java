import java.io.BufferedReader;
import java.lang.reflect.Array;
import java.util.*;

class Main {

  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      int count = Integer.parseInt(br.readLine());

      ArrayList<ArrayList<Integer>> list = new ArrayList<>();

      while(count-- > 0){
        String str[] = br.readLine().split(" ");
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(Integer.valueOf(str[0]));
        temp.add(Integer.valueOf(str[1]));
        list.add(temp);
      }

      list.sort((item1, item2) -> {
        if (item1.get(1) > item2.get(1))
          return 1;
        else if (item1.get(1).equals(item2.get(1)) && item1.get(0) > item2.get(0))
          return 1;
        else
          return -1;
      });

      for (ArrayList<Integer> item : list) {
        sb.append(item.get(0)).append(" ").append(item.get(1)).append("\n");
      }

      
      System.out.println(sb);
     
      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
