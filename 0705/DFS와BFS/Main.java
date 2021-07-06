import java.io.BufferedReader;
import java.util.*;

class Graph{
    private int node;
    private LinkedList<Integer> list[];
    private boolean checkList[];

    Graph(int node){
        this.node = node;
        this.list = new LinkedList[node+1];
        this.checkList = new boolean[node+1];

        for (int i=1; i<node+1; ++i) 
          list[i] = new LinkedList<Integer>();
    }

    void edge(int a, int b){
        list[a].add(b);
        list[b].add(a);
    }

    void sort(){
        for (int i=1; i<node+1; ++i) 
            Collections.sort(list[i]);
    }

    void DFS(int index){
        checkList[index] = true;
        
        System.out.print(index + " ");
        Iterator<Integer> iter = list[index].iterator();

        while(iter.hasNext()){
            int num = iter.next();

            if(!checkList[num]){
                this.DFS(num);
            }
        }
    }

    void BFS(int index){
        Queue<Integer> queue = new LinkedList<>();

        checkList[index] = true;
        queue.add(index);

        while(queue.size() != 0){
            index = queue.poll();
            System.out.print(index + " ");

            Iterator<Integer> iter = list[index].iterator();
            while(iter.hasNext()){
                int num = iter.next();

                if(!checkList[num]){
                    checkList[num] = true;
                    queue.add(num);
                }
            }

        }

    }
}
public class Main{
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            
            String[] str = br.readLine().split(" ");

            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int v = Integer.parseInt(str[2]);

            Graph graphDfs = new Graph(n);
            Graph graphBfs = new Graph(n);

            while(m-- > 0){
                String[] line = br.readLine().split(" ");

                int a = Integer.parseInt(line[0]);
                int b = Integer.parseInt(line[1]);

                graphDfs.edge(a, b);
                graphBfs.edge(a, b);

            }

            graphDfs.sort();
            graphBfs.sort();

            graphDfs.DFS(v);
            System.out.println();
            graphBfs.BFS(v);

            br.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
   
}
