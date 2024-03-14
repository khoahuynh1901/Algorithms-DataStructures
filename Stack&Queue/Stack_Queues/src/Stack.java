import java.util.Arrays;

public class Stack {
    int[] StackArray = new int[5];
    int top = 0;
    public void push(int data){

        if ( top < 5){
            StackArray[top] = data;
            top++;

        } else {
            System.out.println("The stack array is full");
        }

    }

    public int size(){
        return top;
    }

    public int pop(){

        if (isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        else{
            top--;
            int data;
            data = StackArray[top];
            StackArray[top] = 0;
            return data;
        }

    }
    public int peek(){
        int data;
        data =  StackArray[top-1];
        return data;
    }

    public boolean isEmpty(){
        if (top <= 0){
            return true;
        }
        return false;
    }

    public void show() {
        System.out.println(Arrays.toString(StackArray));

    }
    public static void main(String[] args) {
            Stack games = new Stack();
            games.push(10);
            games.push(5);
            games.push(13);
            games.push(20);
            games.push(21);
            System.out.println(games.pop());
            games.show();
    }

}