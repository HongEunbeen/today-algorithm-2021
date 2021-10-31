class Flood{
    int x;
    int y;
    Flood(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    
    public static void BFS(int[][] arr, int N, int M, int sr, int sc, int newColor) {
       Queue<Flood> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new Flood(sr, sc));
        int oldColor = arr[sr][sc];
        arr[sr][sc] = newColor;
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
          Flood flood = queue.poll();

          for (int i = 0; i < 4; i++) {
            int nextX = flood.x + dx[i];
            int nextY = flood.y + dy[i];

            if ((nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)){
              continue;
            }
            if(arr[nextX][nextY] == oldColor && !visited[nextX][nextY]){
              queue.add(new Flood(nextX, nextY));

              visited[nextX][nextY] = true;
              arr[nextX][nextY] = newColor;
            }
          }
        }  
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int changeColor = image[sr][sc];
         BFS(image, image.length, image[0].length, sr, sc, newColor);
        return image;
    
    }
}
