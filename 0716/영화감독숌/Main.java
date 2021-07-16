import java.io.BufferedReader;
import java.util.*;

class Main{
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            ArrayList<Integer> list = new ArrayList<>();
            
            int count = Integer.valueOf(br.readLine());
            int num = 666;
            
            while(true){
                if(Integer.toString(num).contains("666")){
                     list.add(num);
                     if(list.size() == count) break;
                }
                num++;
            }
            
            System.out.println(list.get(list.size() -1));
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
