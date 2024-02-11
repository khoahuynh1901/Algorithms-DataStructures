import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        UnorderedArray Uo = new UnorderedArray(5);
        Random rand = new Random();
        //rand.setSeed(12345);
        for (int i = 0; i < 5; i++) {
            Uo.addLast(rand.nextInt(10));
        }
        Uo.selectionSort();
        Uo.listItems();
//        System.out.println(Uo.linearSearch(6));
        System.out.println(Uo.binarySearch(5));


    }
}