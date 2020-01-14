package array;

public class Tester
{
    public static void main(String[] args)
    {
        Array<String> array = new ArrayImpl<>(5);
        array.add("A");
        array.add("B");
        array.add("C");
        array.add("D");
        array.add("E");
        System.out.println(array);
        System.out.println(array.isFull());
        System.out.println(array.size());
        System.out.println(array.remove("C"));
        System.out.println(array);
        array.swap(1, array.size()-1);
        System.out.println(array);
        array.swap(0, array.size()); // throws IndexOutOfBoundException
    }
}
