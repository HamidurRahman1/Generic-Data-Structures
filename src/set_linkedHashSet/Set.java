package set_linkedHashSet;

public interface Set<E> extends Iterable<E>
{
    boolean add(E e);
    boolean contains(E e);
    boolean remove(E e);
    E get(E e);

    int size();
    boolean isEmpty();
}
