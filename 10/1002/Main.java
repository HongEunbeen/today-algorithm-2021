import java.io.BufferedReader;
import java.util.*;

class Main {
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      int count = Integer.valueOf(br.readLine());

      while(count-- > 0){
        String temp[] = br.readLine().split(" ");
        //문서의 개수
        int N = Integer.parseInt(temp[0]);
        //몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째에 놓여 있는지를 나타내는 정수
        int M = Integer.parseInt(temp[1]);
        
        //N개의 문서 중요도
        String temp2[] = br.readLine().split(" ");
        LinkedList<int[]> queue = new LinkedList<>();
        for(int i=0; i<temp2.length; i++){
          queue.offer(new int[] { i, Integer.parseInt(temp2[i])});
        }
        
        int index = 0;
        while (!queue.isEmpty()) {
          int[] first = queue.poll();
          boolean max = true;
          for(int i = 0; i < queue.size(); i++) {
            if(first[1] < queue.get(i)[1]) {
              queue.offer(first);
              for(int j = 0; j < i; j++) {
                queue.offer(queue.poll());
              }
              max = !max;
              break;
            }
          }
          if(!max) continue;
          index++;
          if(first[0] == M) break;
        }
        sb.append(index).append("\n");
      }
     
      
      System.out.println(sb);
      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
