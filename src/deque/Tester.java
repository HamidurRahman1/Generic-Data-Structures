package deque;

public class Tester
{
    public static void main(String[] args)
    {
        Deque<Integer> deque = new DoubleLinkedDeque<>();
        System.out.println(deque.size());
        System.out.println(deque.isEmpty());
        deque.addFirst(1);
        deque.addLast(2);
        System.out.println(deque.size());
        ((DoubleLinkedDeque<Integer>) deque).print();
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
    }
}
