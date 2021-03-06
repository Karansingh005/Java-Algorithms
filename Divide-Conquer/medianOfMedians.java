import java.util.Arrays;

public class medianOfMedians {

    public static void main(String args[]){
        int[] arr = {25,24,33,39,3,18,19,31,23,49,45,16,1,29,48,22,15,20,24,4,13,34};
        findMedian(arr);
    }

    private static void findMedian(int[] arr) {
        int median = findMedianUtil(arr, (arr.length/2) +1,0,arr.length-1);
        System.out.print("Median is: " + median);
    }

    private static int findMedianUtil(int[] arr, int k, int low, int high) {
        int n = partiton(arr, low, high);
        int length = n - low + 1;
        if(length == k){
            return arr[n];
        }
        if(length > k){
            return findMedianUtil(arr, k , low, n-1);
        }
        else
        {
            return findMedianUtil(arr,k-length,n+1,high);
        }
    }

    private static int partiton(int[] arr, int low, int high) {
        int pivot = getPivotValue(arr,low,high);
        while(low<high){
            while(arr[low]<pivot){
                low++;
            }
            while (arr[high] > pivot){
                high--;
            }
            if (arr[low]==arr[high]){
                low++;
            }
            else if(low<high){
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
        }
        return high;
    }

    private static int getPivotValue(int[] arr, int low, int high) {
        if(high-low+1 <= 9){
            Arrays.sort(arr);
            return arr[arr.length/2];
        }
        int[] temp = null;
        int[] medians = new int[(int)Math.ceil((double)(high-low+1)/5)];
        int medianIndex = 0;
        while(high >= low){
            temp = new int[Math.min(5,high-low+1)];
            for(int i=0; i < temp.length && low<=high ; i++){
                temp[i] = arr[low];
                low++;
            }
            Arrays.sort(temp);
            medians[medianIndex] = temp[temp.length/2];
            medianIndex++;
        }
        return getPivotValue(medians,0,medianIndex);
    }
}
