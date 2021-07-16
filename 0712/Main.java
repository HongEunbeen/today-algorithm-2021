import java.io.BufferedReader;
import java.util.*;

class Main{
    public static boolean[][] arr = new boolean[51][51];
    public static int result = Integer.MAX_VALUE;

    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
           
            
            String[] str = br.readLine().split(" ");

            int N = Integer.valueOf(str[0]);
            int M = Integer.valueOf(str[1]);

            for(int i=0; i<N; i++){
                String line =  br.readLine();
                for(int j=0; j<M; j++){
                    arr[i][j] = line.charAt(j) == 'W' ? true : false;
                }
            }

            //경우의 수 = 2 * (7-N) * (7-M)

            for(int i=0; i<N-7; i++){
                for(int j=0; j<M-7;j++){
                    calcChess(i, j);
                }
            }
            
            System.out.println(result);

        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void calcChess(int x, int y){
        boolean color = arr[x][y];
        int count = 0;

        for(int i=x; i<x+8; i++){
            for(int j=y; j<y+8; j++){
                count = arr[i][j] != color ? count+1 : count;
                color = (!color);
            }
            color = (!color);
        }

        count = Math.min(count, 64-count);
        result = Math.min(count, result);
    }
}
