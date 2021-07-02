import java.io.BufferedReader;

class Main{
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            
            String [] arr = br.readLine().split(" ");

            long answer = 0;
            int count = Integer.parseInt(arr[0]);
            int total = Integer.parseInt(arr[1]);

            long lan[] = new long[10000];

            for(int i=0; i<count; i++){
                lan[i] = Integer.parseInt(br.readLine());
            }

            long left = 0;
            long right = Long.MAX_VALUE;
           
            while(left <= right){
                long mid = (left + right) / 2;
                long result = 0;
                
                for(int i=0; i<count; i++){
                    result += lan[i] / mid;
                }

                if(result >= total){
                    left = mid + 1;
                    if(mid > answer){
                        answer = mid;
                    }
                }
                else{
                    right = mid - 1;
                }

            }

            System.out.println(answer);

            
            br.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
