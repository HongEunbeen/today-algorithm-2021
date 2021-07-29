import java.io.BufferedReader;
import java.util.*;

class Main{
    public static int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
 
            String arr[] = br.readLine().split(" ");

            int a = Integer.valueOf(arr[0]);
            int b = Integer.valueOf(arr[1]);

            //최대 공약수
            int result = gcd(a, b);
            System.out.println(result);
            //최소 공배수
            System.out.println(a*b/result);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
