import java.io.BufferedReader;
import java.util.*;

class Main {
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      int N = Integer.valueOf(br.readLine());
      String temp[] = br.readLine().split(" ");
      int[] arrN = new int[N];
      for (int i = 0; i < N; i++) {
        arrN[i] = Integer.valueOf(temp[i]);
      }

      int M = Integer.valueOf(br.readLine());
      String temp2[] = br.readLine().split(" ");
      int[] arrM = new int[M];
      for (int i = 0; i < M; i++) {
        arrM[i] = Integer.valueOf(temp2[i]);
      }

      Arrays.sort(arrN);

      for (int i = 0; i < M; i++) {
        boolean flag = false;
        int left = 0;
        int right = N - 1;

        while (left <= right) {
          int mid = (left + right) / 2;
          if (arrN[mid] > arrM[i])
            right = mid - 1;
          else if (arrN[mid] < arrM[i])
            left = mid + 1;
          else {
            flag = true;
            break;
          }
        }
        if (flag)
          sb.append("1\n");
        else
          sb.append("0\n");
      }

      System.out.println(sb);

      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
