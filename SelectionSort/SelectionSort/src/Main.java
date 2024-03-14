import java.util.Arrays;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        UnorderedArray arr = new UnorderedArray(4);
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            arr.addLast(rand.nextInt(4));
        }
        System.out.println(arr);
        System.out.println("Array After Selection Sort");
        System.out.println(arr);
    }

}