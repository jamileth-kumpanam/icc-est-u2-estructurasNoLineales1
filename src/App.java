import structures.IntTree;

public class App {
    public static void main(String[] args) {
        runIntTree();

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

}
