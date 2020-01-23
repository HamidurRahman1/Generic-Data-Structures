package stack;

public class Tester
{
    public static void main(String[] args)
    {
        Stack<Integer> stack = new LinkedStack<>();
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        stack.push(1);
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(15);
        stack.push(16);
        System.out.println(stack.size());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.size());
    }
}
