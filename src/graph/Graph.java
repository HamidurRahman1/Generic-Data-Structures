package graph;

public interface Graph<T>
{
    boolean addVertex(T vertex);
    boolean addEdge(T source, T destination, boolean bidirectional);

    boolean removeVertex(T v);
    boolean removeEdge(T source, T destination);

    boolean containsVertex(T vertex);
    boolean containsEdge(T source, T destination);
}
