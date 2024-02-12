public class Main {
    public static void main(String[] args) {
        System.out.println("Recursive Function");
        Recursive(10);

    }

    public static void Recursive(int number){
        if (number < 1 ){
            return;
        }
        System.out.println(number);
        Recursive(number - 1);
    }
}