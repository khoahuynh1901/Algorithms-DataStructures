public class Main {

    public static void main(String[] args) {
        System.out.println("Recursive Function");
        recursive(5);


    }

    static void recursive(int number) {
        if (number == 1) {
            return;
        }
        recursive(number - 1);
        System.out.println("Hi my name is Khoa");
        System.out.println(number);
    }
    static int fibonacci(int number){
        if(number<2){
            return(number);
        }else{
            return (fibonacci(number-1) + fibonacci(number-2));
        }


    }
}

