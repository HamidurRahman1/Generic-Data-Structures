package set_hashSet;

public class Tester
{
    public static void main(String[] args)
    {
        Set<Integer> set = new LinkedHashSet<>();
        System.out.println(set.isEmpty());
        System.out.println(set.size());
        set.add(5);
        set.add(4);
        set.add(3);
        set.add(2);
        set.add(1);
        set.add(5);
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        set.remove(5);
        set.add(5);
        set.add(5);
        System.out.println(set.size());
    }
}
