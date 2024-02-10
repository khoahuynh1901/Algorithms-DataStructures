import java.util.Arrays;

public class UnorderedArray {
    private int[] m_array;
    private int maxSize;
    private int numElements;

    public UnorderedArray(int maxSize) {
        this.maxSize = maxSize;
        this.numElements = 0;
        this.m_array = new int[maxSize];
    }

    public boolean addLast(int item) {
        if (this.numElements < this.maxSize) {
            this.m_array[this.numElements] = item;
            ++this.numElements;
            return true;
        } else {
            return false;
        }
    }

    public int linearSearch(int item) {
        for (int i = 0; i < this.numElements; ++i) {
            if (item == this.m_array[i]) {
                System.out.println("the item found in the index of " + i);
                return i;
            }
        }

        return -1;
    }
    //After remove item assign it to 0 if item in linearSearch is Found
    public boolean removeItem(int item) {
        int index = this.linearSearch(item);
        if (index == -1) {
            return false;
        } else {
            this.m_array[index] = 0;
            return true;
        }
    }

    @Override
    public String toString() {
        String var10000 = Arrays.toString(this.m_array);
        return "UnsortedArray{m_array=" + var10000 + ", maxSize=" + this.maxSize + ", numElements=" + this.numElements + "}";
    }
}
