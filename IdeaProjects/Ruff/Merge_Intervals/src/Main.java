import javafx.util.Pair;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[][] intervarls;
       // intervarls= new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        //intervarls= new int[][]{{1, 4}, {4, 5},};
        //intervarls= new int[][] {{1,4}, {0,4}};
        intervarls= new int[][] {{1,4}, {2,3}};

        System.out.println(Arrays.deepToString(intervarls));
        Arrays.sort(intervarls, (i1, i2) ->i1[0] - i2[0] );
       // System.out.println(Arrays.deepToString(intervarls));
        //System.exit(1);
        Solution obj = new Solution();
        int [][] result=obj.merge(intervarls);
        for(int i=0;i< result.length;i++){
           for(int j=0;j<2;j++){
               System.out.print(result[i][j]);
           }
            System.out.println();
        }
    }
}

class Solution{

    public int[][] merge(int[][] intervals) {

        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        for(int row=0;row<intervals.length;row++){
            if(row==0){
                   stack.push(new Pair<>(intervals[row][0],intervals[row][1]));
            }else{
                   //first pick
                   Pair<Integer, Integer> p2= stack.peek();
                   if(p2.getValue()>=intervals[row][0]){
                       Pair<Integer, Integer> p3= stack.pop();
                       stack.push(new Pair(p3.getKey(),
                               Math.max(p3.getValue(),intervals[row][1])));
                   }else{
                       stack.push(new Pair<>(intervals[row][0],intervals[row][1]));
                   }
               }

        }
        //stack.stream()
        int[][] arr = new int[stack.size()][2];
        System.out.println("stack size: "+stack.size());
        for(int i=0;!stack.empty();i++){
            Pair<Integer, Integer> p4= stack.pop();
            //System.out.println(p4.getKey() + " : "+ p4.getValue());
            arr[i][0]=p4.getKey();
            arr[i][1]=p4.getValue();
        }

        return arr;

    }

}