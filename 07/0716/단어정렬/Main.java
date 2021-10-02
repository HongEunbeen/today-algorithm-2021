import java.io.BufferedReader;
import java.util.*;

class Main{
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            ArrayList<String> list = new ArrayList<>();
            
            int count = Integer.valueOf(br.readLine());

            
            while(count-- > 0){
                list.add(br.readLine());
            }
            
            Collections.sort(list, new Comparator<String>() {
                public int compare(String str1, String str2) {
                    if(str1.length() == str2.length()) return str1.compareTo(str2);
                    else return str1.length() - str2.length();
                }
            });

            ArrayList<String> result = new ArrayList<>();

            for(String item : list){
                if(!result.contains(item)){
                    result.add(item);
                    sb.append(item+"\n");
                }
                else continue;
            }

            System.out.println(sb);
            

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
