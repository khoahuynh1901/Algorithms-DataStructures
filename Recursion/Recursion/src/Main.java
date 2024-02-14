public class Main {

    public static void main(String[] args) {
        System.out.println("Recursive Function");
        System.out.println(fibonacci(5));


    }

    static void recursive(int number) {
        if (number == 1) {
            return;
        }
        recursive(number - 1);
    }
    static int fibonacci(int number){
        if(number<2){
            return(number);
        }else{
            return (fibonacci(number-1) + fibonacci(number-2));
        }


    }
}

