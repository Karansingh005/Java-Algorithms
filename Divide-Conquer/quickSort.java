public class quickSortClass {

    public static void main(String args[]){

        int[] arr={10, 1, 67, 56, 20, 34, 43, 90, 54, 8, 0};
        int len = arr.length - 1;
        quickSort(arr, 0, len);
        for(int i=0; i<len; i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void quickSort(int[] arr, int lb, int ub) {
        if(lb < ub){
            int index = partition(arr,lb,ub);
            quickSort(arr,lb,index-1);
            quickSort(arr,index+1, ub);
        }
    }

    private static int partition(int[] arr, int lb, int ub) {
        int pivot = arr[lb];
        int left = lb, right = ub;
        while(left<right){
            while(arr[left] <= pivot && left < arr.length-1){
                left++;
            }
            while(arr[right] > pivot && right > 0){
                right--;
            }
            //swapping values in iteration
            if(left<right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        //swapping pivot with element present at right
        int temp = arr[lb];
        arr[lb] = arr[right];
        arr[right] = temp;
        return right;
    }
}
