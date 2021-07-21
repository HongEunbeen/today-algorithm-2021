import java.io.BufferedReader;
import java.util.*;

class Main {
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      int[] arr = new int[9];
      int max = 100;
      int sum = 0;

      for (int i = 0; i < 9; i++) {
        arr[i] = Integer.valueOf(br.readLine());
        sum += arr[i];
      }

      LoopMain: for (int i = 0; i < 9; i++) {
        for (int j = i + 1; j < 9; j++) {
          if (sum - (arr[i] + arr[j]) == max) {
            arr[i] = arr[j] = Integer.MAX_VALUE;
            break LoopMain;
          }
        }
      }

      Arrays.sort(arr);

      for (int item : arr) {
        if (item == Integer.MAX_VALUE)
          break;
        sb.append(item + "\n");
      }

      System.out.println(sb);

      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
