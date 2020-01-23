package stack;

import java.util.EmptyStackException;

public interface Stack<T>
{
    void push(T element) throws NullPointerException;
    T pop() throws EmptyStackException;
    T top() throws EmptyStackException;

    int size();
    boolean isEmpty();
}
