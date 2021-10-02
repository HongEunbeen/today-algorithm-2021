import java.io.BufferedReader;
import java.util.*;

import javax.imageio.plugins.tiff.FaxTIFFTagSet;

class Main {
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      int N = Integer.valueOf(br.readLine());

      int count = N - 1;

      int MIN = 0;

      while (count > 0) {
        int result = count;
        String str = String.valueOf(count);

        for (int i = 0; i < str.length(); i++) {
          result += Integer.valueOf(str.substring(i, i + 1));
        }
        if (result == N)
          MIN = count;
        count--;

      }

      System.out.println(MIN);

      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
