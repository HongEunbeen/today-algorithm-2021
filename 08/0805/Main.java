import java.io.BufferedReader;
import java.util.*;

class Main {
  static int N;
  static char arr[][];

  static int check() {
    int countI = 1;
    int countJ = 1;
    int result = 1;
    for (int i = 0; i < N; i++) {
      countI = 1;
      countJ = 1;
      for (int j = 1; j < N; j++) {
        if (arr[i][j] == arr[i][j - 1]) countJ++;
        else countJ = 1;

        if (arr[j][i] == arr[j - 1][i]) countI++;
        else countI = 1;

        result = Math.max(Math.max(countJ, countI), result);
      }
    }
    return result;
  }

  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      N = Integer.valueOf(br.readLine());

      arr = new char[N][N];
      for (int i = 0; i < N; i++) {
        String str[] = br.readLine().split("");
        for (int j = 0; j < N; j++)
          arr[i][j] = str[j].charAt(0);
      }

      int result = 1;

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (i + 1 < N) {
            for (int x = 0; x < 2; x++) {
              char temp = arr[i][j];
              arr[i][j] = arr[i + 1][j];
              arr[i + 1][j] = temp;
              if (x == 0) result = Math.max(result, check());
            }
          }
          if (j + 1 < N) {
            for (int x = 0; x < 2; x++) {
              char temp = arr[i][j];
              arr[i][j] = arr[i][j+1];
              arr[i][j + 1] = temp;
              if (x == 0) result = Math.max(result, check());
            }
          }
        }
      }

      System.out.println(result);

      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
