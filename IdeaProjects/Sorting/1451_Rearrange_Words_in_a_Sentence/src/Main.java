import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution= new Solution();
        System.out.println(15/10);
        String text="Leetcode is cool ram1";
        String result=solution.arrangeWords(text);
        String result1=solution.arrangeWords1(text);
        System.out.println(result);
        System.out.println(result1);
    }
}

class Solution {
    public String arrangeWords(String text) {
        Map<Integer, ArrayList<String>> map= new TreeMap<>();
      if(text==null || text.length()==0)  {
          return null;
      }
      String words[] =text.split(" ");

      for(String word: words){
          ArrayList<String> list= new ArrayList<>();
          if(map.containsKey(word.length())){
              list=map.get(word.length());
          }
          list.add(word.toLowerCase());
          map.put(word.length(), list);

      }
        System.out.println(map);
      String result="";
      for(Map.Entry<Integer,ArrayList<String>> map1:map.entrySet()){
         for(String str: map1.getValue()){
             result+=str+" ";
         }

      }
      return (result.substring(0,1).toUpperCase()+result.substring(1)).trim();
    }

    public String arrangeWords1(String text) {
        String[] word=text.split(" ");
        Arrays.sort(word,(s1,s2)->Integer.compare(s1.length(),s2.length()));
        StringBuilder sb= new StringBuilder();
        sb.append(word[0].substring(0,1).toUpperCase() +(word[0]).substring(1));
        for(int i=1;i<word.length;i++){
            sb.append(" "+word[i].toLowerCase());
        }
        return sb.toString().trim();
    }
}