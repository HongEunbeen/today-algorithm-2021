import java.io.BufferedReader;
import java.util.*;

class Main{
    static int[][] graph = new int[50][50];
	static boolean[][] checkList = new boolean[50][50];
    static int M = 0;
    static int N = 0;
    static int num = 0;

    static int[] calcX ={0,0,1,-1};
    static int[] calcY = {1,-1,0,0};
	
    public static void dfs(int x, int y) {
        checkList[x][y] = true;

        for(int i=0; i<4; i++){
            int newX = x + calcX[i];
            int newY = y + calcY[i];
            if(newX >=0 && newY >=0 && newX < M && newY < N){
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
          
            int count = Integer.valueOf(br.readLine());

            while(count -- > 0){
                num = 0;
                String[] str = br.readLine().split(" ");

                M = Integer.valueOf(str[0]);
                N = Integer.valueOf(str[1]);
                int K = Integer.valueOf(str[2]);

                graph = new int[M][N];
                checkList = new boolean[M][N];
    
                for(int i=0; i<K; i++){
                    String[] line = br.readLine().split(" ");
                    int x = Integer.valueOf(line[0]);
                    int y = Integer.valueOf(line[1]);
                    graph[x][y] = 1;
                }
    
                for(int i=0; i<M; i++){
                    for(int j=0; j<N; j++){
                        if(graph[i][j] == 1 && !checkList[i][j]){
                            dfs(i,j);
                            num++;
                        }
                    }
                }
               sb.append(num + "\n");
            }

            System.out.println(sb);
            br.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
