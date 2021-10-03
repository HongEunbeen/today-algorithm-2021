import java.io.BufferedReader;
import java.util.*;

class Main{
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int count = Integer.valueOf(br.readLine());

            String temp[] = br.readLine().split(" ");
            int arr[] = new int[count];

            for(int i=0; i<count; i++){
                arr[i] = Integer.valueOf(temp[i]);
            }

            Arrays.sort(arr);
            
            int sum = arr[0];
            for(int i=1; i<count; i++){
                arr[i] = arr[i] + arr[i-1];
                sum += arr[i];
            }

            System.out.println(sum);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
