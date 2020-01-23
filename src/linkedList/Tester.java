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
        for(String s : list)
            System.out.println(s);
        System.out.println("-> " + list.remove("E"));
        System.out.println("-> " + list.remove("D"));
        System.out.println(list.size());
        for(String s : list)
            System.out.println(s);
    }
}
