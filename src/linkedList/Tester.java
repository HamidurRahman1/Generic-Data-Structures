package linkedList;

public class Tester
{
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.add("A"));
        System.out.println(list.add("B"));
        System.out.println(list.size());
        System.out.println(list.isEmpty());
    }
}
