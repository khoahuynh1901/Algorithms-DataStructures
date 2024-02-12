import java.util.Random;

public class Main {
    public static void main(String[] args) {
        UnorderedArray Uo = new UnorderedArray(20);
        Random ran = new Random();
        for (int i = 0; i < 20; i++) {
            Uo.AddArray(ran.nextInt(200));
        }
        System.out.println(Uo.ToString());
        Uo.InsertionSort();
        System.out.println(Uo.ToString());
    }

}