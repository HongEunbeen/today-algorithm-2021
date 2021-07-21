import java.io.BufferedReader;
import java.util.*;

import javax.imageio.plugins.tiff.FaxTIFFTagSet;

class Main {
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      while (true) {
        String str = br.readLine();
        if (str.equals("."))
          break;

        Stack<String> stack = new Stack<>();

        str = str.replaceAll("\\s+", "");
        String arr[] = str.split("");

        boolean flag = false;
        for (String item : arr) {
          if (item.equals("(") || item.equals("["))
            stack.add(item);

          if (item.equals(")") || item.equals("]")) {
            if (stack.empty()) {
              flag = true;
              break;
            }

            if (item.equals(")") && !stack.pop().equals("(")) {
              flag = true;
              break;
            }

            if (item.equals("]") && !stack.pop().equals("[")) {
              flag = true;
              break;
            }
          }

        }

        if (!stack.empty())
          flag = true;

        if (flag)
          sb.append("no\n");
        else
          sb.append("yes\n");
      }

      System.out.println(sb);

      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
