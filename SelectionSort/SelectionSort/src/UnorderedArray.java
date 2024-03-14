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
        } else {
            return false;
        }
    }

    public void listItems() {
        System.out.print("myArray{");
        for (int i = 0; i < numElements; i++){
            System.out.print(m_array[i] + " ");
        }
        System.out.print("}");
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