import java.io.BufferedReader;

class Main{
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            
            int count = Integer.parseInt(br.readLine());
            double result = 0;

            while(count-- > 0){
                String [] arr = br.readLine().split(" ");

                double h = Integer.parseInt(arr[0]);
                double w = Integer.parseInt(arr[1]);
                double n = Integer.parseInt(arr[2]);

                if(h * w < n) break;

                result = n % h * 100;
                if(result == 0) result = h * 100;
                
                if(n <= h) result += 1;
                else {
                    result += Math.ceil(n / h);
                }
                sb.append((int)result + "\n");
            }

            System.out.println(sb);

            br.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
