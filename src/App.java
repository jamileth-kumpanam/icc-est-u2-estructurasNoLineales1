import structures.IntTree;
import structures.models.Persona;
import structures.trees.Tree;

public class App {
    public static void main(String[] args) {
        // runIntTree();
        runTree();

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

}
