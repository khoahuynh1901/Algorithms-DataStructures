import java.lang.reflect.Array;
import java.util.Arrays;
//Dynamic Stack array can be shrinkable and Expandable
public class DynamicStack {
    int capacity = 5;
    int[] StackArray = new int[capacity];
    int top = 0;

    public void push(int data) {

        if (size() == capacity) {
            expand();
            StackArray[top] = data;
            top++;
            capacity++;

        } else {
            StackArray[top] = data;
            top++;
        }

    }

    private void expand() {
        int length = size();
        int[] temp = Arrays.copyOf(StackArray, length+1);
        StackArray = temp;
    }

    public int size() {
        return top;
    }

    public int pop() {

        if (isEmpty()) {
            System.out.print("Stack is empty: ");
            return -1;
        } else {
            top--;
            capacity--;
            int data = StackArray[top];
            shrink();
            return data;


        }

    }

    private void shrink(){
        int length = size();
        int[] temp = Arrays.copyOf(StackArray, length);
        StackArray = temp;
    }

    public int peek() {
        int data;
        data = StackArray[top - 1];
        return data;
    }

    public boolean isEmpty() {
        if (top <= 0) {
            return true;
        }
        return false;
    }

    public void show() {
        System.out.println(Arrays.toString(StackArray));

    }

    public static void main(String[] args) {
        DynamicStack dy = new DynamicStack();
        dy.push(20);
        dy.push(2);
        dy.push(10);
        dy.push(2003);
        dy.push(19);
        dy.push(25);
        System.out.println(dy.pop());
        System.out.println(dy.pop());
        System.out.println(dy.pop());
        System.out.println(dy.pop());
        System.out.println(dy.pop());
        System.out.println(dy.pop());
        System.out.println(dy.pop());

        dy.show();


    }
}
