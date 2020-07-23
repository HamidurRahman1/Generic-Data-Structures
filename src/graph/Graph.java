package graph;

public interface Graph<T>
{
    void addVertex(T vertex);
    void addEdge(T source, T destination, boolean isBidirectional);

    void removeVertex(T vertex);
    void removeEdge(T source, T destination);

    boolean containsVertex(T vertex);
    boolean containsEdge(T source, T destination);
}
