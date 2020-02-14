package heap;

public class HeapTester
{
    public static void main(String[] args) throws Exception{
        Heap<Integer> heap = new MinHeap<>(6);
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(7);
        heap.add(1);
        heap.add(0);
        while (!heap.isEmpty())
        {
            System.out.println(heap.remove());
            System.out.println(heap);
        }
    }
}
