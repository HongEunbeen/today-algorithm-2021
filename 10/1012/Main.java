import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;


public class Main {
  public static void main(String[] args) {
    try{
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
     
      Deque<Integer> deque = new LinkedList<>();

      String temp[] = br.readLine().split(" ");

      int N = Integer.valueOf(temp[0]); 
      int M = Integer.valueOf(temp[1]);
      int arr[] = new int[M];
      int sum = 0;

      for(int i=1; i<=N; i++){
        deque.offer(i);
      }

      temp = br.readLine().split(" ");
      for(int i=0; i<M; i++){
        arr[i] = Integer.valueOf(temp[i]);
      }

      for(int i=0; i<arr.length; i++){
        if(deque.getFirst() == arr[i]){
          deque.removeFirst();
        }
        else{
          Iterator<Integer> itr = deque.iterator();
          int fnum = 0;
          int lnum = 0;
          while(itr.hasNext()){
            if(arr[i] == itr.next()) break;
            fnum++;
          }
          lnum = deque.size() - fnum;
          
          if(fnum < lnum){
            while(deque.getFirst() != arr[i]){
              deque.addLast(deque.removeFirst());
              sum++;
            }
          }
          else{
            while(deque.getFirst() != arr[i]){
              deque.addFirst(deque.removeLast());
              sum++;
            }
          }
          deque.removeFirst();
        }
      }

     System.out.println(sum);
    
      
    }catch(Exception e){
        System.out.println(e);
    }
  }
}
