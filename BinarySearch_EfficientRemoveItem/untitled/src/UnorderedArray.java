import java.util.Arrays;

public class UnorderedArray {
    private int[] m_array;
    private int maxSize;
    private int numElements;

    public UnorderedArray(int maxSize){
        this.maxSize = maxSize;
        numElements = 0;
        m_array = new int[maxSize];
    }

    public boolean addLast(int item) {
        if (numElements < maxSize) {
            m_array[numElements] = item;
            numElements++;
            return true;
        }
        else{
            return false;
        }
    }
    public int linearSearch(int item) {
        for (int i = 0; i < numElements; i++){
            if (item == m_array[i]){
                System.out.println("the item found in the index of " + i);
                return i;
            }
        }
        return -1;
    }
    //Binary Search Required Sorted Array

    public void selectionSort(){
        // we need the loop for filling the array
        //[10,3,2,9,0]
        for (int i = 0; i < numElements; i++) {
            // go through the array!
            // we have to find the smallest
            int smallestLocation = i;
            for (int j = i+1; j <numElements ; j++) {
                //j = 4;9
                // comparison!
                if(m_array[j] < m_array[smallestLocation]) {
                    smallestLocation = j; //3;2
                }
            }
            // time to swap!
            int temp = m_array[smallestLocation];
            m_array[smallestLocation] = m_array[i];
            m_array[i] = temp;
        }
    }

    public int binarySearch(int item) {
        //[0,2,4,4,5]
        int start = 0;
        int end = numElements - 1; // assuming numElements is the number of elements in m_array
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (m_array[mid] == item) {
                return mid;
            } else if (item < m_array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        // If the item is not found, return -1
        return -1;
    }

    boolean removeItem(int item) {

        int index = linearSearch(item);

        if (index == -1) return false;
        else {
            m_array[index] = m_array[numElements - 1];
            numElements--;
            return true;
        }
    }
    //Note:  first revise the remove item. instead of zeroing the found element
    // swap it with the last element of the array and decrease the num_Element by one
    public boolean efficientRemoveItem(int item) {
        /*
        Removes the first occurrence of item from the
        array. If found, the item must be removed by
        shifting down all items after it down by 1. The
        function returns true if the removal was successful
        (if found) and false otherwise (not found)
        */
        int index = linearSearch(item);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < numElements - 1; i++) {
            m_array[i] = m_array[i + 1];
        }
        numElements --;
        return true;
        //your code here

    }

    public void listItems() {
        System.out.print("Array = {");
        for (int i = 0; i < numElements; i++) {
            System.out.print(m_array[i] + " ");
        }
        System.out.println("}");
    }

    @Override
    public String toString() {
        return "UnsortedArray{" +
                "m_array=" + Arrays.toString(m_array) +
                ", maxSize=" + maxSize +
                ", numElements=" + numElements +
                '}';
    }

}
