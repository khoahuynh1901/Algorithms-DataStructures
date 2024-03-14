import java.util.Arrays;

public class UnorderedArray {
    private int[] Unorder;
    private int MaxSize;
    private int Total_Item;

    public UnorderedArray(int MaxSize) {
        this.MaxSize = MaxSize;
        Total_Item = 0;
        Unorder = new int[MaxSize];
    }
    public boolean AddArray(int item) {
        if (Total_Item < MaxSize) {
            Unorder[Total_Item] = item;
            Total_Item++;
            return true;
        } else {
            return false;
        }
    }
    public void InsertionSort() {
        for (int i = 1; i < Total_Item; i++) {
            int currentValue = Unorder[i];
            int j = i - 1;
            while (j >= 0 && Unorder[j] > currentValue) {
                Unorder[j + 1] = Unorder[j];
                j--;
            }
            Unorder[j + 1] = currentValue;
        }
    }

    public String ToString() {
        String s = "";
        s += "Total Item is: " + Total_Item + "\n";
        s += Arrays.toString(Unorder);
        return s;
    }
}
