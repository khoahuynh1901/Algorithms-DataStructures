public class HugeInteger {
    private boolean isPositive;
    private Node head;
    private Node tail;
    private int length;

    // Constructors
    public HugeInteger() {
        this.isPositive = true;
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public HugeInteger(String number) {
        if (number.charAt(0) == '-') {
            this.isPositive = false;
            number = number.substring(1);
        }
        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(number.charAt(i));
            if (digit != 0 || head != null) {
                addLast(digit);
            }
        }
    }

    // Additional Behavior
    public HugeInteger addPositive(HugeInteger num2) {
        HugeInteger result = new HugeInteger();
        Node current1 = this.head;
        Node current2 = num2.head;
        int carry = 0;

        while (current1 != null || current2 != null || carry != 0) {
            int sum = carry;
            if (current1 != null) {
                sum += current1.data;
                current1 = current1.next;
            }
            if (current2 != null) {
                sum += current2.data;
                current2 = current2.next;
            }
            carry = sum / 10;
            sum %= 10;
            result.addLast(sum);
        }

        return result;
    }


    public void concatenateDigit(int digit) {
        addLast(digit);
    }

    public String toString() {
        if (head == null)
            return "0";
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.insert(0, current.data);
            current = current.next;
        }
        if (!isPositive)
            sb.insert(0, '-');
        return sb.toString();
    }

    private void addLast(int digit) {
        Node newNode = new Node(digit);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }
}
