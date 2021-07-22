import java.io.BufferedReader;
import java.util.*;

class Main{
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            ArrayList<Integer> list = new ArrayList<>();
            
            int count = Integer.valueOf(br.readLine());
            PriorityQueue<Integer> priorityQueue_max = new PriorityQueue<>();
            PriorityQueue<Integer> priorityQueue_min = new PriorityQueue<>(new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });

            while(count-- > 0){
                int num = Integer.valueOf(br.readLine());
                priorityQueue_max.add(num);
                if((priorityQueue_max.size()+priorityQueue_min.size())%2!=0) {
                    priorityQueue_min.add(priorityQueue_max.poll());
                }
                else {
                    if(priorityQueue_min.peek()>num) {
                        priorityQueue_max.add(priorityQueue_min.poll());
                        priorityQueue_min.add(priorityQueue_max.poll());
                    }
                }

                sb.append(priorityQueue_min.peek()+"\n");
            }
            System.out.println(sb);
           
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
