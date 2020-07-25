package doublyLinkedList;

public class Tester
{
    public static void main(String[] args) {
        List<String> d = new DoublyLinkedList<>();
        System.out.println(d.isEmpty());
        System.out.println(d.size());

        d.addLast("a");
        d.addLast( "aa");
        d.addLast("2a");

        System.out.println(d);
        System.out.println(d.removeFirst());
        System.out.println(d);

        System.out.println(d.isEmpty());
        System.out.println(d.size());
    }
}
