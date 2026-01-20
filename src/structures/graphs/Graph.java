package structures.graphs;

import java.util.*;

import structures.models.Persona;
import structures.nodes.Node;

public class Graph<T> {

    private Map<Node<T>, List<Node<T>>> mapa;

    public Graph(List<Node<T>> nodes) {
        this.mapa = new HashMap<>();
    }

    // ✔ addNode corregido (Node<T>)
    public void addNode(Node<T> node) {
        mapa.putIfAbsent(node, new ArrayList<>());
    }

    // ✔ se mantiene igual
    public void addEdge(Node<T> n1, Node<T> n2) {
        addNode(n1);
        addNode(n2);
        mapa.get(n1).add(n2);
    }

    // ✔ NO SE QUITA addConocido
    // ✔ se adapta internamente
    public void addConocido(Persona p1, Persona p2) {
        Node<T> n1 = new Node<>((T) p1);
        Node<T> n2 = new Node<>((T) p2);

        addNode(n1);
        addNode(n2);
        mapa.get(n1).add(n2);
    }

    public void printGraph() {
        for (Map.Entry<Node<T>, List<Node<T>>> entry : mapa.entrySet()) {
            System.out.print(entry.getKey().getValue() + " -> ");
            for (Node<T> neighbor : entry.getValue()) {
                System.out.print(neighbor.getValue() + " ");
            }
            System.out.println();
        }
    }

    public List<Node<T>> getNeighbors(Node<T> n) {
        return mapa.getOrDefault(n, new ArrayList<>());
    }

    public void bfs(Node<T> start) {
        Set<Node<T>> visitados = new LinkedHashSet<>();
        Queue<Node<T>> queue = new LinkedList<>();

        visitados.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            System.out.println(current.getValue());

            for (Node<T> conocido : getNeighbors(current)) {
                if (!visitados.contains(conocido)) {
                    visitados.add(conocido);
                    queue.add(conocido);
                }
            }
        }
    }

    public void dfs(Node<T> start) {
        Set<Node<T>> visitados = new LinkedHashSet<>();
        dfsRecursive(start, visitados);
    }

    private void dfsRecursive(Node<T> current, Set<Node<T>> visitados) {
        visitados.add(current);
        System.out.println(current.getValue());

        for (Node<T> conocido : getNeighbors(current)) {
            if (!visitados.contains(conocido)) {
                dfsRecursive(conocido, visitados);
            }
        }
    }
}
