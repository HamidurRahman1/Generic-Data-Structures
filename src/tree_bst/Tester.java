package tree_bst;

public class Tester
{
    public static void main(String[] args) throws Exception
    {
        Tree<Integer> t = new BST<>();
        t.add(5);
        t.add(4);
        t.add(2);
        System.out.println(t.size());
        System.out.println(t.isEmpty());

    }
}

