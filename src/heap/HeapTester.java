package heap;

public class HeapTester
{
    public static void main(String[] args) throws Exception{
        Heap<Integer> heap = new MinHeap<>();
        System.out.println(heap.isEmpty());
        System.out.println(heap.capacity());
        System.out.println(heap.size());
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(7);
        heap.add(1);
        System.out.println(heap.isEmpty());
        System.out.println(heap.capacity());
        System.out.println(heap.size());
        System.out.println(heap);
    }
}
