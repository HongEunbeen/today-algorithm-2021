import java.io.BufferedReader;
import java.util.*;

class Graph {
  private int node;
  private LinkedList<Integer> list[];
  private boolean checkList[];
  private int count;

  Graph(int node) {
    this.node = node;
    this.list = new LinkedList[node + 1];
    this.checkList = new boolean[node + 1];

    for (int i = 1; i < node + 1; ++i)
      list[i] = new LinkedList<Integer>();
  }

  void edge(int a, int b) {
    list[a].add(b);
    list[b].add(a);
  }

  void sort() {
    for (int i = 1; i < node + 1; ++i)
      Collections.sort(list[i]);
  }

  void DFS(int index) {
    checkList[index] = true;

    // System.out.print(index + " ");
    Iterator<Integer> iter = list[index].iterator();

    while (iter.hasNext()) {
      int num = iter.next();

      if (!checkList[num]) {
        this.DFS(num);
        count++;
      }
    }
  }

  int getCount() {
    return count;
  }
}

class Main {
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());

      Graph graphDfs = new Graph(n);

      while (m-- > 0) {
        String[] line = br.readLine().split(" ");

        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);

        graphDfs.edge(a, b);
      }

      graphDfs.sort();

      graphDfs.DFS(1);
      System.out.println(graphDfs.getCount());

      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
