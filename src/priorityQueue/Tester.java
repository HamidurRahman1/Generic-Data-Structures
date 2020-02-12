package priorityQueue;

public class Tester
{
    public static void main(String[] args)
    {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(5);
//        queue.add(2);
//        queue.add(5);
//        queue.add(4);
//        queue.add(6);
//        queue.add(2);
//        queue.add(1);
        queue.add(4);
        System.out.println(queue.size());
        System.out.println(queue);

    }

}

