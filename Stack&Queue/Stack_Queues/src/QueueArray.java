//Queue is FIFO (First In, First Out)
//Queue allow you to have access to the first element inserted

import java.util.Arrays;
import java.util.LinkedList;
public class QueueArray {
    int[] queue = new int [5];
    int size;
    int front;
    int rear;

    public void enQueue(int data){
        queue[rear] = data;
        size++;
        rear++;
    }

    public int getSize(){
        return size;
    }

    public int peek(){
        return queue[front];
    }

    public int deQueue()
    {
        if (isEmpty()){
            System.out.println("There is No item left");
            return -1;
        } else {
            //[0,5,2003,21,25]
            //left Rotate array by 1 element in java
            int data = queue[front];
            rear--;
            for(int i = 0; i<size-1; i++){
                queue[i] = queue[i + 1];
            }
            queue[size-1] = 0;
            return data;
        }
    }
    public boolean isEmpty(){
        if (getSize() <= 0){
            return true;
        }
        return false;
    }

    public void show(){
        System.out.println(Arrays.toString(queue));
    }
    public static void main(String[] args) {
        QueueArray Qarray = new QueueArray();
        Qarray.enQueue(10);
        Qarray.enQueue(5);
        Qarray.enQueue(2003);
        Qarray.enQueue(21);
        Qarray.enQueue(25);
        System.out.println(Qarray.deQueue());
        System.out.println(Qarray.deQueue());
        System.out.println(Qarray.deQueue());
        System.out.println(Qarray.deQueue());

        Qarray.show();

        System.out.println("Size of Queue Array: " + Qarray.getSize());
        System.out.println("The Rear is: " + Qarray.rear);
        System.out.println("The Front is: " + Qarray.front);

    }
}