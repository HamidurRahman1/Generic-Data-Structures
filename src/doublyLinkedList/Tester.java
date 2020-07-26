package doublyLinkedList;

public class Tester
{
    public static void main(String[] args) {
        List<String> d = new DoublyLinkedList<>();
        d.add(0, "a");
        d.addLast( "aa");
        d.addLast("aaa");

        System.out.println(d);
        d.add(3, "2a");
        System.out.println(d);
    }
}
