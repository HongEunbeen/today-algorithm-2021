import java.io.BufferedReader;
import java.util.*;

class Main{
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            String[] temp = br.readLine().split(" ");

            int N = Integer.valueOf(temp[0]);
            int C = Integer.valueOf(temp[1]);

            int arr[] = new int[N];

            for(int i=0; i<N; i++){
                arr[i] = Integer.valueOf(br.readLine());
            }

            Arrays.sort(arr);

            int low = 1;
            int high = arr[N-1] - arr[0];
            int d = 0, result = 0, mid= 0;

            while(low <= high) {
                mid = (low + high) / 2;
                int start = arr[0];
                int count = 1;
                for(int i=0; i<N; i++){
                    d = arr[i] - start;
                    if(mid <= d){
                        count++;
                        start = arr[i];
                    }
                }
                if(C <= count) {
                    result = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            System.out.println(result);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
