import java.io.BufferedReader;
import java.util.*;

class Main{
    static int[][] graph = new int[1001][1001];
	static boolean[] checkList = new boolean[1001];
	
	public static void dfs(int index, int node) {
		if(checkList[index]) return;
		else {
			checkList[index] = true;
			for(int i = 1; i <= node; i++) {
				if(graph[index][i] == 1) {
					dfs(i, node);
				}
			}
		}
	}

    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
          
            int result = 0;

            String[] str = br.readLine().split(" ");

            int n = Integer.valueOf(str[0]);
            int m = Integer.valueOf(str[1]);


            while(m-- > 0){
                String[] node = br.readLine().split(" ");

                int a = Integer.valueOf(node[0]);
                int b = Integer.valueOf(node[1]);

                graph[a][b] = graph[b][a] = 1;
                
            }
            for(int i=1; i<=n; i++){
                if(!checkList[i]){
                    dfs(i, n);
                    result++;
                }
                
            }
            System.out.println(result);


            br.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
   
}
