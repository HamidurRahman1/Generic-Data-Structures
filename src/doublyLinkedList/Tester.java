package doublyLinkedList;

import java.util.Iterator;

public class Tester
{
    public static void main(String[] args) {
        List<String> d = new DoublyLinkedList<>();
        d.add(0, "1a");
        d.add(1,  "2a");
        d.add(2, "3a");
        d.addLast( "4a");
        d.addLast( "5a");

        Iterator<String> iterator = ((DoublyLinkedList<String>) d).iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
