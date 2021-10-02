import java.io.BufferedReader;

class Main{
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            
            int num = Integer.parseInt(br.readLine());

            int i = 1;
            int start = 2;
            int result = 0;

            while(true){
                if(num < start) {
                    result = i;
                    break;
                }
                start = start + (6*i);
                i++;
            }

            System.out.println(result);

            br.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
