package deque;

public class Tester
{
    public static void main(String[] args)
    {
        Deque<Integer> deque = new DoubleLinkedDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        System.out.println(deque.removeLast());
        System.out.println(deque.size());
        deque.addFirst(10);
        deque.addLast(101);
        System.out.println(deque.size());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
    }
}
