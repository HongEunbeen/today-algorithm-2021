import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    try{
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      
      String temp[] = br.readLine().split("-");
      ArrayList<Integer> list = new ArrayList<>();

      for(int i=0; i<temp.length; i++){
        if(temp[i].indexOf('+') != -1){
          String temp2[] = temp[i].split("\\+");
          int sum = 0;
          for(int j=0; j<temp2.length; j++){
            sum += Integer.valueOf(temp2[j]);
          }
          if(i == 0) list.add(sum*-1);
          else list.add(sum);
        }
        else {
          if(i == 0) list.add(Integer.valueOf(temp[i]) * -1);
          else list.add(Integer.valueOf(temp[i]));
        }
      }

      int sum = 0;
      for(int d : list){
        sum += (d*-1);
      }
         
      
      System.out.println(sum);
      
    }catch(Exception e){
        System.out.println(e);
    }
  }
}
