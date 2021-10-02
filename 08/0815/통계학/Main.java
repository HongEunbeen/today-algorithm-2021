import java.io.BufferedReader;
import java.util.*;

class Main {
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      
      int N = Integer.valueOf(br.readLine());

      int arr[] = new int[N];
      ArrayList<Integer> list = new ArrayList<>();

      double sum = 0;
      for (int i = 0; i < N; i++) {
        arr[i] = Integer.valueOf(br.readLine());
        sum += arr[i];
        list.add(arr[i]);
      }

      Arrays.sort(arr);

      //최빈값,,, 구할 수 있다 ,,,!!
      boolean flag = false;
      int max = 0;
      int mode = 10000;
      for(int i=0; i<N; i++){
        int jump = 0;
        int count = 1;
        int i_value = arr[i];

        for (int j = i + 1; j < N; j++) {
          if (i_value != arr[j]) {
            break;
          }
          count++;
          jump++;
        }

        if(max < count){
          max = count;
          mode = i_value;
          flag = true;
        } 
        else if (count == max && flag == true) {
          mode = i_value;
          flag = false;
        }
        i += jump;
      }


      sb.append(Math.round(sum / N)).append("\n");
      sb.append(arr[N / 2]).append("\n");
      sb.append(mode).append("\n");
      sb.append(arr[N - 1] - arr[0]).append("\n");

      System.out.println(sb);
      
      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
