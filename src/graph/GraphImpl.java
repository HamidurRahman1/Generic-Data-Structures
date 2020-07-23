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
        if(!graph.containsKey(source)) addVertex(source);
        if(!graph.containsKey(destination)) addVertex(destination);
        graph.get(source).add(destination);
        if(isBidirectional) graph.get(destination).add(source);
    }

    @Override
    public void removeVertex(T v) {
        graph.remove(v);
    }

    @Override
    public void removeEdge(T source, T destination) {
        if(graph.containsKey(source)) graph.get(source).remove(destination);
        if(graph.containsKey(destination)) graph.get(destination).remove(source);
    }

    @Override
    public boolean containsVertex(T vertex) {
        return graph.containsKey(vertex);
    }

    @Override
    public boolean containsEdge(T source, T destination) {
        return graph.get(source).contains(destination);
    }

    public boolean isEmpty()
    {
        return graph.size() == 0;
    }

    public void clear()
    {
        graph = null;
        graph = new HashMap<>();
    }
}
