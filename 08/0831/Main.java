import java.io.BufferedReader;
import java.util.*;

class Main {
  static int factorial(int N) {
    if (N <= 1) {
      return 1;
    }
    return N * factorial(N - 1);
  }
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
    
      String[] temp = br.readLine().split(" ");
      int N = Integer.parseInt(temp[0]);
      int K = Integer.parseInt(temp[1]);

      int result = factorial(N) / (factorial(N - K) * factorial(K));
      System.out.println(result);

      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
