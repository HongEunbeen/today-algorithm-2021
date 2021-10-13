import java.io.BufferedReader;
import java.util.*;

class Tomato{
  int x, y;

  Tomato(int x, int y)
  {
    this.x = x;
    this.y = y;
  }
}

class Main {
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };

  public static void BFS(int[][] arr, int N, int M) {
    Queue<Tomato> queue = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (arr[i][j] == 1) queue.add(new Tomato(i, j));
      } 
    }

    while (queue.size() != 0) {
      Tomato tomato = queue.poll();
      
      for (int i = 0; i < 4; i++) {
        int nextX = tomato.x + dx[i];
        int nextY = tomato.y + dy[i];

        if ((nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
        || arr[nextX][nextY] != 0 ){
          continue;
        }
        
        arr[nextX][nextY] = arr[tomato.x][tomato.y] + 1;
        queue.add(new Tomato(nextX, nextY));
      }
    }


    int max = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (arr[i][j] == 0) {
          System.out.println(-1);
          return;
        }
        max = Math.max(max, arr[i][j]);
      }
    }

    System.out.println(max - 1);

  }
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      String[] temp = br.readLine().split(" ");

      int N = Integer.valueOf(temp[0]);
      int M = Integer.valueOf(temp[1]);

      int arr[][] = new int[M][N];
      for(int i=0; i<M; i++){
         temp = br.readLine().split(" ");
         for(int j=0; j<N; j++) 
          arr[i][j] = Integer.valueOf(temp[j]);
      }
      
      BFS(arr, M, N);


      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
