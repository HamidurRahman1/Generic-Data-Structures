package queue;

public class Tester
{
    public static void main(String[] args)
    {
        Queue<Integer> queue = new LinkedQueue<>();
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        queue.enqueue(101);
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        queue.enqueue(102);
        queue.enqueue(103);
        queue.enqueue(104);
        System.out.println(queue.size());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
//        System.out.println(queue.peek()); // throws Exception
    }
}
