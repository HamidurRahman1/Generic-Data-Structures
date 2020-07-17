package matrix_denseMatrix;

public interface Matrix<T extends Number>
{
    T get(int i, int j) throws IndexOutOfBoundsException;
    void set(int i, int j, T value) throws IndexOutOfBoundsException, NullPointerException;

    T increaseBy(int i, int j, T value) throws IndexOutOfBoundsException, NullPointerException;
    T decreaseBy(int i, int j, T value) throws IndexOutOfBoundsException, NullPointerException;

    T add(T t) throws NullPointerException;
    T negate();
    T multiply(T t) throws NullPointerException;
    T transpose();

    T clone();
    int size();
}