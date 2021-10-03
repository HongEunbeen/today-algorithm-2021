import java.io.BufferedReader;
import java.util.*;

class Main{
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            
            String temp[] = br.readLine().split(" ");

            int N = Integer.valueOf(temp[0]);
            int K = Integer.valueOf(temp[1]);
            
            int arr[] = new int[N];

            for(int i=0; i<N; i++){
                arr[i] = Integer.valueOf(br.readLine());
            }

            int count = 0;
            for(int i=N-1; i>=0; i--){
                if(K >= arr[i]){
                    count += K/arr[i];
                    K %= arr[i];
                }
                if(K == 0) break;
            }

            System.out.println(count);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
