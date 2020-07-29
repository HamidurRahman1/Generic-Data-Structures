package doublyLinkedList;

public class Tester
{
    public static void main(String[] args) {
        List<String> d = new DoublyLinkedList<>();
        d.add(0, "1a");
        d.add(1,  "2a");
        d.add(2, "3a");
        d.addLast( "4a");
        d.addLast( "5a");

        System.out.println("-> "+d);
        System.out.println(d.size());
        System.out.println(d.removeLast());
        System.out.println("-> "+d);
        System.out.println(d.size());
        System.out.println(d.removeLast());
        System.out.println("-> "+d);
        System.out.println(d.size());
        System.out.println(d.removeLast());
        System.out.println("-> "+d);
        System.out.println(d.size());
        System.out.println(d.removeLast());
        System.out.println("-> "+d);
        System.out.println(d.size());
        System.out.println(d.removeLast());
        System.out.println("-> "+d);
        System.out.println(d.getLast());
        System.out.println(d.isEmpty());
        System.out.println(d.size());
        System.out.println("-> "+d);
    }
}
