package doublyLinkedList;

import java.util.Iterator;

public class Tester
{
    public static void main(String[] args) {
        List<String> d = new DoublyLinkedList<>();
        d.add(0, "a");
        d.add(1,  "b");
        d.add(2, "c");
        d.addLast( "d");
        d.addLast( "e");
        d.addFirst("f");
        d.addLast("g");

        Iterator<String> iterator = ((DoublyLinkedList<String>) d).reverseIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
