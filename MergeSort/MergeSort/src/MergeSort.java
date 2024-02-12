import java.util.Random;
public class MergeSort {
    private static void mergeSort(int[] array) {
        int arrayLength = array.length;

        //1- base condition
        if (arrayLength <=1) {
            return;
        }

        //2- defining midIndex, leftHalf and rightHalf
        int midIndex = arrayLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[arrayLength - midIndex];

        //3- devide the array into leftHalf and rightHalf
        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = array[i];
        }

        for (int i = midIndex; i < arrayLength; i++) {
            rightHalf[i - midIndex] = array[i];
        }

        //recursive call of leftHalf and rightHalf
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(array, leftHalf, rightHalf);
    }

    private static void merge(int[] array, int[] leftHalf, int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        //define iterators for three arrays
        int i = 0, j = 0, k = 0;

        //compare until leftHalf or rightHalf runs out
        while(i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                array[k] = leftHalf[i];
                i++;
            } else {
                array[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        //add the remaining elements
        while (i < leftSize) {
            array[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            array[k] = rightHalf[j];
            j++;
            k++;
        }
    }
    //helpers methods
    private static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rnd.nextInt(100);
        }

        System.out.print("Original Array: ");
        printArray(numbers);

        mergeSort(numbers);

        System.out.print("Sorted Array: ");
        printArray(numbers);
    }

}
