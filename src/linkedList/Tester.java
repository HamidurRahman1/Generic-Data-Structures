package linkedList;

public class Tester
{
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        System.out.println("-> " + list.update(list.size()-1, "AA"));
        ((LinkedList<String>) list).print();
    }
}
