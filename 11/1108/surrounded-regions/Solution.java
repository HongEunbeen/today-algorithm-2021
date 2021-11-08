class Capture{
    int x, y;
    Capture(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static void BFS(char[][] arr, int n, int m, Capture capture){
        Queue<Capture> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        visited[capture.x][capture.y] = true;
        queue.add(capture);
        
        while(!queue.isEmpty()){
            Capture newCapture = queue.poll();
            
            for(int i=0; i<4; i++){
                int newX = newCapture.x + dx[i];
                int newY = newCapture.y + dy[i];
            
                if(0 > newX || newX >= n || 0 > newY || newY >= m) continue;
                if(arr[newX][newY] != 'X' && !visited[newX][newY]){
                    visited[newX][newY] = true;
                    queue.add(new Capture(newX, newY));
                }
            }
        }
        
        for(int i=0; i<n; i++){
            if(i == 0 || i == n-1){
                for(int j=0; j<m; j++){
                    if(visited[i][j]) return;
                }
            }
            if(visited[i][0] || visited[i][m-1]) return;
        }
        
         for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j]) arr[i][j] = 'X';
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 'O') BFS(board, n, m, new Capture(i, j));
            }
        }
       
    }
}
