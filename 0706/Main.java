import java.io.BufferedReader;
import java.util.*;

class Position{
    private int x, y;
    Position(int y, int x){
        this.x = x;
        this.y = y;
    }

    int getY(){
        return y;
    }
    
    int getX(){
        return x;
    }
}

class Main{
    static char[][] graph = new char[50][50];
    static Queue<Position> queueWater = new LinkedList<>();
    static Queue<Position> queueBiber = new LinkedList<>();

    static int R = 0;
    static int C = 0;
    static int num = 0;

    static int[] calcX ={1,-1,0,0};
    static int[] calcY ={0,0,1,-1};
	
    public static void BFS(){
        
        while(true){
            num++;
            //물
            int sizeWater = queueWater.size();
            for(int i=0; i<sizeWater; i++){
                Position position = queueWater.poll();

                for(int s=0; s<4; s++){
                    int nc = position.getX() + calcX[s];
                    int nr = position.getY() + calcY[s];
                    if(nc >=0 && nr >= 0 && nr < R && nc < C){
                        if(graph[nr][nc] == '.'){
                            graph[nr][nc] = '*';
                            queueWater.add(new Position(nr,nc));
                        }
                    }
                }
            }
            
            //비버
            if(queueBiber.size() == 0){
                System.out.println("KAKTUS");
                System.exit(0);
            }
            int sizeBiber = queueBiber.size();
            for(int i=0; i<sizeBiber; i++){
                Position position = queueBiber.poll();

                for(int s=0; s<4; s++){
                    int nc = position.getX() + calcX[s];
                    int nr = position.getY() + calcY[s];
                    if(nc >=0 && nr >= 0 && nr < R && nc < C){
                        if(graph[nr][nc] == 'D') return;
                        if(graph[nr][nc] == '.'){
                            graph[nr][nc] = '*';
                            queueBiber.add(new Position(nr,nc));
                        }
                    }
                }
            }
        }
    }

    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            String[] str = br.readLine().split(" ");

            R = Integer.valueOf(str[0]); //Y
            C = Integer.valueOf(str[1]); //X

            for(int i=0; i<R; i++){
                String[] line = br.readLine().split("");
                for(int j=0; j<C; j++){
                    graph[i][j] = line[j].charAt(0);
                    if(graph[i][j] == '*') queueWater.add(new Position(i, j));
                    if(graph[i][j] == 'S') queueBiber.add(new Position(i, j));
                }
            }
            num = 0;
            BFS();

            System.out.println(num);
            br.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
