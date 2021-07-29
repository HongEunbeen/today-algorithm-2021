import java.io.BufferedReader;
import java.util.*;

class Main{
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
 
            

            int N = Integer.valueOf(br.readLine());
            String arr[] = br.readLine().split(" ");
            Map<Integer, Integer> card = new HashMap<>();

            for(int i=0; i<N; i++){
                int num = Integer.valueOf(arr[i]);
                if(card.containsKey(num)){
                    card.put(Integer.valueOf(arr[i]), card.get(num) + 1);
                }
                else {
                    card.put(Integer.valueOf(arr[i]), 1);
                }
               
            }

            int M = Integer.valueOf(br.readLine());
            String arrM[] = br.readLine().split(" ");

            for(int i=0; i<M; i++){
                int num = Integer.valueOf(arrM[i]);
                int result = card.containsKey(num) ? card.get(num) : 0;
                sb.append(result + " ");
            }

            System.out.println(sb);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
