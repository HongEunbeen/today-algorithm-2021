import java.io.BufferedReader;

public class Main {
  public static void main(String[] args) {
    try{
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      String temp[] = br.readLine().split(" ");

      int N = Integer.valueOf(temp[0]);
      int M = Integer.valueOf(temp[1]);
      int arr[][] = new int[N][M];

      for(int i=0; i<N; i++){
        temp = br.readLine().split(" ");
        for(int j=0; j<M; j++){
          arr[i][j] = Integer.valueOf(temp[j]);
        }
      }

      temp = br.readLine().split(" ");

      int K = Integer.valueOf(temp[1]);
      int arr2[][] = new int[M][K];

      for(int i=0; i<M; i++){
        temp = br.readLine().split(" ");
        for(int j=0; j<K; j++){
          arr2[i][j] = Integer.valueOf(temp[j]);
        }
      }

      for(int i=0; i<N; i++){
        for(int j=0; j<K; j++){
            int sum = 0;
            for(int k=0; k<M; k++){
                sum+=arr[i][k]*arr2[k][j];
            }
            sb.append(sum).append(" ");
        }
        sb.append("\n");            
    }

    System.out.println(sb);  

    }catch(Exception e){
        System.out.println(e);
    }

  }
}
