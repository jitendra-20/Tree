import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        QuickSort qs=new QuickSort();
        qs.quickMain();
    }
}

class QuickSort{

    //int[] nums ={11,13,7,12,16,9,24,5,10,3};
    int[] nums ={11,13,7,12}; // 7, 11, 13
    //int[] nums={1,2,3,4,5};
    int partition1(int A[], int low, int high){
      int pivot=A[low];
      int i=low,j=high;
        do {
            do {
                i++;
            } while (A[i] <= pivot);
            do {
                j--;
            } while (A[j] > pivot);

            if(i<j){

                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }while(i<j);
        int temp = A[low];
        A[low] = A[j];
        A[j] = temp;
        return j;

    }

    int partition(int A[], int low, int high){
        int pivot=A[low];
        int i=low+1,j=high;
        boolean flag=true;
        while(flag){
            while(i<=j && A[i]<=pivot){
                i++;
            }
            while(j>=i && A[j]>=pivot){
                j--;
            }
            if(i<j){
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }else{
                flag=false;
            }
        }
        //now swap the pivot with A[j]
        int temp = A[low];
        A[low] = A[j];
        A[j] = temp;
        return j;

    }
    public void quickSort(int A[], int low, int high){
          int partition;
           if(low<high){
                partition=partition(A,low,high);
               System.out.println(partition);
               quickSort(A,low,partition-1);
               quickSort(A,partition+1,high);


           }
    }
    public void quickMain(){

        quickSort(nums,0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}