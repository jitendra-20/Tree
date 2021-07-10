import java.util.*;


import javafx.util.Pair;
public class Main {
    public static void main(String[] args) {
        int[] nums={1,1,1,2,2,3}; int k=2;
        //int[] nums={5,5,5,4,4,3}; int k=2;

        //int[] nums={-1,-1}; int k=1;
        Solution solution = new Solution();
        solution.topKFrequent(nums,k);
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map= new HashMap<>();
        PriorityQueue<Pair1> heap=
                new PriorityQueue<>();

        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
           // System.out.println(entry.getKey() +" : "+ entry.getValue());
            heap.add(new Pair1( entry.getValue(),entry.getKey() ));
            if(heap.size()>k){
                heap.poll();
            }
        }
        //System.out.println(heap);
        int [] result= new int[k];
      int count=0;
      while(!heap.isEmpty()){
          result[count]=heap.poll().getValue();
          count++;
      }

       // System.out.println(Arrays.toString(result));
      return result;
    }
}
class Pair1 implements Comparable<Pair1>{
    int key;
    int value;
    public Pair1(int key,int value){
        this.key=key;
        this.value=value;
    }




    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Pair1 o) {
        if(this.getKey()==o.getKey()) return 0;
        if(this.getKey()>
                o.getKey()) return 1;
        return -1;
    }
    public String toString(){
        return getKey() +" ->  " +getValue();
    }
}