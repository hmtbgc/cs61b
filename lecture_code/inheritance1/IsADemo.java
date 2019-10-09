public class IsADemo {
    public static void main(String[] args) {
        /*
        List61B<String> someList = new SLList<>();
        someList.addFirst("elk");
        someList.addLast("dwell");
        someList.addLast("on");
        someList.addLast("existential");
        someList.addLast("crises");
        someList.print();
        */

        List61B<Integer> intList = new AList<>();
        intList.addFirst(10);
        intList.addFirst(20);
        intList.addLast(30);
        intList.print();
    }
}