public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(29);
        list.insert(40);
        list.insert(2);
        list.delete(2);
        list.show();
    }
}

// Using generics to specify LinkedList of Strings
//        LinkedList<String> cars = new LinkedList<String>();
//        // Adding values to the LinkedList
//        cars.add("Toyota");
//        cars.add("Honda");
//        cars.add("Ford");
//
//        // Displaying the values in the LinkedList
//        System.out.println("Cars:");
//        for (String car : cars) {
//            System.out.println(car);
//        }
//
//        // Using raw type LinkedList
//        LinkedList link = new LinkedList();
//
//        // Adding values to the LinkedList
//        link.add(10);
//        link.add("Hello");
//        link.add(3.14);
//
//        // Displaying the values in the LinkedList
//        System.out.println("\nLink:");
//        for (Object item : link) {
//            System.out.println(item);