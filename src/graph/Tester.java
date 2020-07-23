package graph;

public class Tester
{
    public static void main(String[] args) {
        Graph<Integer> graph = new GraphImpl<>();
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);
        graph.addVertex(8);
        graph.addEdge(5, 6, true);
        graph.addEdge(5, 7, true);
        graph.addEdge(6, 7, true);
        graph.addEdge(5, 8, false);
        graph.removeEdge(6, 7);
        System.out.println(graph.totalVertices());
        System.out.println(graph);
        graph.removeVertex(5);
        System.out.println(graph.totalVertices());
        System.out.println(graph);
    }
}
