import java.util.ArrayList;

import structures.IntTree;
import structures.graphs.Graph;
import structures.models.Persona;
import structures.nodes.Node;
import structures.trees.Tree;

public class App {
    public static void main(String[] args) {
        // runIntTree();
        // runTree();
        // runGraph();
        runGraphRecorridos();
    }

    private static void runGraphRecorridos(){
        Graph <Persona> grafo = new Graph<>(new ArrayList<>());
        Persona pC23 = new Persona("Carlos", 23);
        Persona pL18 = new Persona("Luis", 18);
        Persona pA23 = new Persona("Ana", 23);
        Persona pA30 = new Persona("Ana", 30);
        Persona pJ25 = new Persona("Juan", 25);
        Persona pAn20 = new Persona("Andres", 23);

        grafo.addEdge(new Node<>(pC23), new Node<>(pA30));
        grafo.addConocido(pC23, pL18);
        grafo.addConocido(pA30, pJ25);
        grafo.addConocido(pA30, pAn20);

        grafo.printGraph();

        System.out.println("\nRecorrido BFS: ");
        grafo.bfs(new Node<>(pC23));

        System.out.println("\nRecorrido DFS: ");
        grafo.dfs(new Node<>(pC23));
    }

    public static void runIntTree(){
    IntTree tree = new IntTree(null);

    tree.insert(10);
    tree.insert(5);
    tree.insert(3);
    tree.insert(15);

    System.out.println("----PRE ORDER----");
    tree.preOrder();

    System.out.println("\n----POS ORDER----");
    tree.posOrder();

    System.out.println("\n----IN ORDER----");
    tree.inOrder();

    System.out.println("\nTamaño del árbol: " + tree.size());
}

public static void runTree(){
    Tree <Persona> tree = new Tree<Persona>();
    tree.insert(new Persona("Pablo", 21));
    tree.insert(new Persona ("Maria", 23));
    tree.insert(new Persona ("Ana", 25));
    tree.insert(new Persona ("Pedro", 23));
    tree.insert(new Persona ("Luis", 19));
    tree.inOrder();
    
    System.out.println("Persona con edad de 23 años: ");
    Persona findPerson = tree.searchByAge(23);
    if(findPerson != null){
        System.out.println(findPerson);
    }else{
        System.out.println("No se encontró");
    }
}

public static void runGraph() {

    Graph<String> graph = new Graph<>(new ArrayList<>());

    Node<String> nA = new Node<>("A");
    Node<String> nB = new Node<>("B");
    Node<String> nC = new Node<>("C");
    Node<String> nD = new Node<>("D");

    graph.addNode(nA);

    graph.addEdge(nA, nB);
    graph.addEdge(nA, nC);
    graph.addEdge(nB, nD);
    graph.addEdge(nC, nD);

    graph.printGraph();
}
}
