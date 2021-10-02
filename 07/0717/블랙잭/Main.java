import java.io.BufferedReader;
import java.util.*;

class Main {
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      String temp[] = br.readLine().split(" ");
      int N = Integer.valueOf(temp[0]);
      int M = Integer.valueOf(temp[1]);

      String temp2[] = br.readLine().split(" ");
      int arr[] = new int[N];

      for (int i = 0; i < N; i++) {
        arr[i] = Integer.valueOf(temp2[i]);
      }

      int max = 0;

      LoopOut: for (int i = 0; i < N - 2; i++) {
        for (int j = i + 1; j < N - 1; j++) {
          for (int z = j + 1; z < N; z++) {
            int sum = arr[i] + arr[j] + arr[z];
            if (sum <= M && sum > max)
              max = sum;
            if (max == M)
              break LoopOut;
          }

        }
      }

      System.out.println(max);

      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
