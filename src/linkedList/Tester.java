package linkedList;

public class Tester
{
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add(3, "E");
        ((LinkedList<String>) list).print();
    }
}
