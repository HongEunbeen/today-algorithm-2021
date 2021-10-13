import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Jailbreak{
  int x, y;

  Jailbreak(int x, int y)
  {
    this.x = x;
    this.y = y;
  }
}

class Main {
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };

  public static int[][] BFS(char[][] arr, int h, int w, Jailbreak prisoner) {
    Deque<Jailbreak> queue = new LinkedList<>();
    boolean[][] visited = new boolean[h][w];
    int[][] history = new int[h][w];

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        history[i][j] = -1;
      }
    }

   // Arrays.fill(history, -1);

    queue.add(prisoner);
    visited[prisoner.x][prisoner.y] = true;
    history[prisoner.x][prisoner.y] = 0;

    while (!queue.isEmpty()) {
      Jailbreak jailbreak = queue.poll();
      
      for (int i = 0; i < 4; i++) {
        int nextX = jailbreak.x + dx[i];
        int nextY = jailbreak.y + dy[i];

        if ((nextX < 0 || nextY < 0 || nextX >= h || nextY >= w)){
          continue;
        }
        if(arr[nextX][nextY] != '*' && !visited[nextX][nextY]){
          visited[nextX][nextY] = true;
        if (arr[nextX][nextY] == '#') {
              history[nextX][nextY] = history[jailbreak.x][jailbreak.y] + 1;
              queue.addLast(new Jailbreak(nextX, nextY));
            } else {
              history[nextX][nextY] = history[jailbreak.x][jailbreak.y] ;
              queue.addFirst(new Jailbreak(nextX, nextY));
            }
          }
      }
    }
    return history;
  }
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      int num = Integer.valueOf(br.readLine());

      while(num-- > 0){
        String temp[] = br.readLine().split(" ");
        int h = Integer.valueOf(temp[0]) + 2;
        int w = Integer.valueOf(temp[1]) + 2;

        char arr[][] = new char[h][w];
        ArrayList<Jailbreak> prisoner = new ArrayList<>();
        
        prisoner.add(new Jailbreak(0, 0));

        for (int i = 1; i < h-1; i++) {
          String str = br.readLine();
          for (int j = 1; j < w-1; j++) {
            arr[i][j] = str.charAt(j-1);
            if(arr[i][j] == '$') {
              prisoner.add(new Jailbreak(i, j));
            }
          }
        }

        int[][] mine = BFS(arr, h, w, prisoner.get(0));
        int[][] prisonerCount1 = BFS(arr, h, w, prisoner.get(1));
        int[][] prisonerCount2 = BFS(arr, h, w, prisoner.get(2));
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < h; i++) {
          for (int j = 0; j < w; j++) {
            if (mine[i][j] == -1 || prisonerCount1[i][j] == -1 || prisonerCount2[i][j] == -1 || arr[i][j] == '*') continue;
            int sum = prisonerCount1[i][j] + prisonerCount2[i][j] + mine[i][j];
            sum = arr[i][j] == '#' ? sum - 2 : sum;
            min = Math.min(sum, min);
          }
        }
        sb.append(min).append("\n"); 
      }

      System.out.println(sb);

      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
