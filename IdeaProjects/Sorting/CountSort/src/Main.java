import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // int[] nums = {3, 9, 12, 6, 4, 8, 1};
        // int[] nums={1,2,2,3,4,5};
        //int [] nums={8,5,7,3,5,2,5};
        int [] nums={10,2,345,674,10000,0};
        Solution solution = new Solution();
        solution.countSort(nums);
        }
}

class Solution {
    public void countSort(int[] nums) {
        //find max in the array that we can do in the O(n) in one pass
        //then create the count array size of max+1
        //scan the element from left to right and put the element in same index of count array and increase the
        //frequency
        //get all the elements from count array and print them
        //if array element is having negative number then we have to create the count array size=min+max+1
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        //O(n)
        int[] count = new int[max + 1];
        //fill the count array , read the element from input array and put it in the index of count array
        //and increment it.
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        //O(n)
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(count));
        //Now copy all the elements from count array to original array
        int i = 0, j = 0;
        while (i < count.length) {
            if (count[i] == 0) {
                i++;
            } else {
                nums[j] = i;
                j++;
                count[i]--;
            }
        }

        System.out.println(Arrays.toString(nums));


    }
}










