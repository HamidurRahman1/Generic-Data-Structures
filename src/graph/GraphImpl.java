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
        if(vertex == null) return;
        graph.put(vertex, new LinkedList<>());
    }

    @Override
    public void addEdge(T source, T destination, boolean isBidirectional) {
        if(source == null) return;
        if(destination == null) return;
        if(!graph.containsKey(source)) addVertex(source);
        if(!graph.containsKey(destination)) addVertex(destination);
        graph.get(source).add(destination);
        if(isBidirectional) graph.get(destination).add(source);
    }

    @Override
    public void removeVertex(T vertex) {
        if(vertex == null) return;
        if(!graph.containsKey(vertex)) return;
        List<T> edges = graph.get(vertex);
        graph.remove(vertex);
        graph.keySet().forEach(k -> graph.get(k).removeAll(edges));
    }

    @Override
    public void removeEdge(T source, T destination) {
        if(source == null) return;
        if(destination == null) return;
        if(graph.containsKey(source)) graph.get(source).remove(destination);
        if(graph.containsKey(destination)) graph.get(destination).remove(source);
    }

    @Override
    public boolean containsVertex(T vertex) {
        return graph.containsKey(vertex);
    }

    @Override
    public boolean containsEdge(T source, T destination) {
        if(source == null) return false;
        if(destination == null) return false;
        return graph.get(source).contains(destination);
    }

    public int totalVertices()
    {
        return graph.size();
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
