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
        arr.selectionSort();
        System.out.println("Array After Selection Sort");
        arr.selectionSort();
        System.out.println(arr);
    }
    //Testing
//    int[] m_array = new int[]{10,4,5,2,1};
//    selectionSort(m_array);
//        System.out.println(Arrays.toString(m_array));
//   public static void selectionSort(int[] m_array){
//       // we need the loop for filling the array
//       //[10,3,2,9,0]
//       for (int i = 0; i < m_array.length; i++) {
//           // go through the array!
//           // we have to find the smallest
//           int smallestLocation = i;
//           for (int j = i+1; j < m_array.length ; j++) {
//               //j = 4;9
//               // comparison!
//               if(m_array[j] < m_array[smallestLocation]) {
//                   smallestLocation = j; //3;2
//               }
//           }
//           // time to swap!
//           int temp = m_array[smallestLocation];
//           m_array[smallestLocation] = m_array[i];
//           m_array[i] = temp;
//       }
//   }

}