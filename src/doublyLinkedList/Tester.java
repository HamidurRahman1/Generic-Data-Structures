package doublyLinkedList;

public class Tester
{
    public static void main(String[] args) {
        List<String> d = new DoublyLinkedList<>();
        d.add(0, "a");
        d.add(0,  "aa");
        d.add(2, "aaa");

        System.out.println(d);
        d.set(3, "3a");
        System.out.println(d);
    }
}
