public class LinkedList {
    Node head;
    public void insert(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            Node n = head; //Assign head to a new variable avoiding overwrite head of first note.

            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }

        /*In objects and arrays, they are assigned to new variable, they do not make a copy
            they point to the same memory reference and anything changed both variable will be reflected
             */

        /* In contrast, primitive data type like int, char,bool, will creat a copy as they are not object */

            /*When you create an object in Java and assign it to a new variable,
            you are not creating a new copy of the object itself. Instead, you are creating a new reference
            to the same object in the heap memory. This means that both variables will point to the same object
            in memory, and any changes made to the object through one variable will be reflected
            when accessing the object through the other variable.
             */
    }
    public void insertAtFirstPosition(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        node.next = head;
        head = node;
    }

    public void insertAnyIndex(int index, int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;

        if (index < 0) {
            System.out.println("Invalid index");
            return;
        }

        if (index == 0) {
            node.next = head;
            head = node;
            return; // return after inserting at index 0
        }

        Node n = head;
        for (int i = 0; i < index - 1; i++) {
            n = n.next;
        }
        node.next = n.next;
        n.next = node;
    }
    public void delete(int index){
        if (index==0){
            head = head.next;
        } else{
            Node n = head;
            Node n1 = null;
            for(int i=0; i<index-1; i++){
                n = n.next;
            }
            n1 = n.next;
            n.next = n1.next;
            System.out.println("n1 " + n1.data);

        }

    }
    public void show() {
        Node node = head;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }
}