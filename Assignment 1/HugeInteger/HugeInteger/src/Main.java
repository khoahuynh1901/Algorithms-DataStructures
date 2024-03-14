public class Main {
    public static void main(String[] args) {
        HugeInteger hi = new HugeInteger();
        System.out.println(hi);

        HugeInteger hi1 = new HugeInteger("34545234");
        System.out.println(hi1);

        HugeInteger hi2 = new HugeInteger("-2455434324344");
        System.out.println(hi2);

        HugeInteger hi3 = new HugeInteger("34545234");
        System.out.println(hi3);

        HugeInteger hi4 = new HugeInteger("-2455434324344");
        System.out.println(hi4);

        HugeInteger hi5 = new HugeInteger();
        System.out.println(hi5);
        hi5.concatenateDigit(3);
        System.out.println(hi5);

        HugeInteger hi6 = new HugeInteger("9");
        HugeInteger hi7 = new HugeInteger("6");
        HugeInteger hi8 = hi6.addPositive(hi7);
        System.out.println(hi6 + " + " + hi7 + " = " + hi8);

        HugeInteger hi9 = new HugeInteger("9996354");
        HugeInteger hi10 = new HugeInteger("4656");
        HugeInteger hi11 = hi9.addPositive(hi10);
        System.out.println(hi9 + " + " + hi10 + " = " + hi11);

    }
}
