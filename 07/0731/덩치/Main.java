import java.io.BufferedReader;

class Main {
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      int N = Integer.valueOf(br.readLine());

      int[][] arr = new int[N][2];

      for (int i = 0; i < N; i++) {
        String[] str = br.readLine().split(" ");
        arr[i][0] = Integer.valueOf(str[0]);
        arr[i][1] = Integer.valueOf(str[1]);
      }

      for (int i = 0; i < N; i++) {
        int count = 1;

        for (int j = 0; j < N; j++) {
          if (i == j)
            continue;
          if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
            count++;
          }
        }

        sb.append(count).append(' ');
      }

      System.out.println(sb);

      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
