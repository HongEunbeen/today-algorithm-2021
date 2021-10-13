import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Miro{
  int x, y;

  Miro(int x, int y)
  {
    this.x = x;
    this.y = y;
  }
}

class Main {
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };

  public static void BFS(int[][] arr, int N, int M) {
    Queue<Miro> queue = new LinkedList<>();
    boolean[][] visited = new boolean[N][M];
    queue.add(new Miro(0, 0));

    while (!queue.isEmpty()) {
      Miro miro = queue.poll();
      visited[0][0] = true;

      for (int i = 0; i < 4; i++) {
        int nextX = miro.x + dx[i];
        int nextY = miro.y + dy[i];

        if ((nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)){
          continue;
        }
        if(arr[nextX][nextY] != 0 && !visited[nextX][nextY]){
          queue.add(new Miro(nextX, nextY));
        
          visited[nextX][nextY] = true;
          arr[nextX][nextY] = arr[miro.x][miro.y] + 1;
        }
      }
    }

  }
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      String[] temp = br.readLine().split(" ");

      int N = Integer.valueOf(temp[0]);
      int M = Integer.valueOf(temp[1]);

      int arr[][] = new int[N][M];
      for(int i=0; i<N; i++){
         temp = br.readLine().split("");
         for(int j=0; j<M; j++) 
          arr[i][j] = Integer.valueOf(temp[j]);
      }
      
      BFS(arr, N, M);

      System.out.println(arr[N - 1][M - 1]);

      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
