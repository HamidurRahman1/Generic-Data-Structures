package linkedList;

public class Tester
{
    public static void main(String[] args) throws IllegalAccessException {
        List<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        System.out.println("-> " + list.remove("E"));
        System.out.println("-> " + list.remove("D"));
        ((LinkedList<String>) list).print();
        System.out.println(list.size());
    }
}
