import java.io.BufferedReader;
import java.util.*;

class Main {
  static int dp[][];
  static int arr[];
  static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
  static void dfs(int node, int parent){
    for(int child : list.get(node)){
      if(child != parent){
        dfs(child, node);
        dp[node][0] += Math.max(dp[child][0], dp[child][1]);
        dp[node][1] += dp[child][0];
      }
    }

    dp[node][1] += arr[node]; 
  }
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      int N = Integer.valueOf(br.readLine());

      arr = new int[N+1];
      dp = new int[N+1][2];
      String[] temp = br.readLine().split(" ");

      list.add(new ArrayList<>());
      for(int i=1; i<=N; i++){
        list.add(new ArrayList<>());
        arr[i] = Integer.valueOf(temp[i-1]);
      }

      for(int i=1; i<N; i++){
        String[] temp2 = br.readLine().split(" ");
        int a = Integer.valueOf(temp2[0]);
        int b = Integer.valueOf(temp2[1]);

        list.get(a).add(b);
        list.get(b).add(a);
      }

      dfs(1, -1);

      System.out.println(Math.max(dp[1][0], dp[1][1]));

      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
