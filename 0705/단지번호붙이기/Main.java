import java.io.BufferedReader;
import java.util.*;

class Main{
    static int[][] graph = new int[26][26];
	static boolean[][] checkList = new boolean[26][26];
    static int count = 0;
    static int num = 0;

    static int[] calcX ={0,0,1,-1};
    static int[] calcY = {1,-1,0,0};
	
    public static void dfs(int x, int y) {
        checkList[x][y] = true;
        num++;

        for(int i=0; i<4; i++){
            int newX = x + calcX[i];
            int newY = y + calcY[i];
            if(newX >=0 && newY >=0 && newX < count && newY < count){
                if(graph[newX][newY] == 1 && !checkList[newX][newY]){
                    dfs(newX, newY);
                }
            }
        }
	}

    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
          
            ArrayList<Integer> list = new ArrayList<Integer>();
          
            count = Integer.valueOf(br.readLine());


            graph = new int[count][count];
            checkList = new boolean[count][count];

            for(int i=0; i<count; i++){
                String[] line = br.readLine().split("");
                for(int j=0; j<count; j++){
                    graph[i][j] = Integer.valueOf(line[j]);
                }
            }

            for(int i=0; i<count; i++){
                for(int j=0; j<count; j++){
                    if(graph[i][j] == 1 && !checkList[i][j]){
                        num = 0;
                        dfs(i,j);
                        list.add(num);
                    }
                }
            }

            Collections.sort(list);
            System.out.println(list.size());

            for(int item : list){
                System.out.println(item);
            }
            
            br.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
