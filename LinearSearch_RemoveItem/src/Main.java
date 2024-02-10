import java.util.Random;

public class Main {
    public static void main(String[] args) {
        UnorderedArray Uo = new UnorderedArray(30);
        Random rand = new Random();
        for(int i = 0; i < 20; i++){
            Uo.addLast(rand.nextInt(200));
        }
        System.out.println(Uo.linearSearch(20));
        System.out.println(Uo.toString());
    }
}