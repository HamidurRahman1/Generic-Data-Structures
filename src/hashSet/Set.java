package hashSet;

public interface Set<E>
{
    boolean add(E e);
    boolean contains(E e);
    boolean remove(E e);
    E get(E e);

    int size();
    boolean isEmpty();
}
