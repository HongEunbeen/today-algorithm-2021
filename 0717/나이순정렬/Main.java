import java.io.BufferedReader;
import java.util.*;

class Member implements Comparable<Member> {
  private int num;
  private int age;
  private String name;

  Member(int num, int age, String name) {
    this.num = num;
    this.age = age;
    this.name = name;
  }

  int getNum() {
    return num;
  }

  int getAge() {
    return age;
  }

  String getName() {
    return name;
  }

  @Override
  public int compareTo(Member member) {
    if (this.age > member.age)
      return 1;
    else if (this.age == member.age) {
      if (this.num > member.num)
        return 1;
      else
        return -1;
    } else
      return -1;
  }

}

class Main {
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      ArrayList<Member> list = new ArrayList<>();

      int N = Integer.valueOf(br.readLine());

      for (int i = 0; i < N; i++) {
        String[] arr = br.readLine().split(" ");
        list.add(new Member(i, Integer.valueOf(arr[0]), arr[1]));
      }

      Collections.sort(list);

      for (Member member : list) {
        sb.append(member.getAge() + " " + member.getName() + "\n");
      }

      System.out.println(sb);

      br.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
