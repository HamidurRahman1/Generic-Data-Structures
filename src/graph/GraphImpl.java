package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphImpl<T> implements Graph<T>
{
    private Map<T, List<T>> graph;

    public GraphImpl() {
        this.graph = new HashMap<>();
    }

    @Override
    public void addVertex(T vertex) {
        graph.put(vertex, new LinkedList<>());
    }

    @Override
    public void addEdge(T source, T destination, boolean isBidirectional) {

    }

    @Override
    public void removeVertex(T v) {
        graph.remove(v);
    }

    @Override
    public void removeEdge(T source, T destination) {

    }

    @Override
    public boolean containsVertex(T vertex) {
        return graph.containsKey(vertex);
    }

    @Override
    public boolean containsEdge(T source, T destination) {
        return graph.get(source).contains(destination);
    }
}
