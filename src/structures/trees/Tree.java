package structures.trees;

import structures.models.Persona;
import structures.nodes.Node;

public class Tree <T extends Comparable<T>> {

    private Node<T> root;

    public Tree(){
        this.root = null;
    }

    // metodo para insertar y metodo inorder
    public void insert(T value){
        root = insertRecursive(root, value);
    }

    public Node<T> insertRecursive(Node<T> current, T value){
        if (current == null) {
            return new Node<>(value, null, null);
        }

        if (value.compareTo(current.getValue()) < 0){
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (value.compareTo(current.getValue()) > 0) {
            current.setRight(insertRecursive(current.getRight(), value));
        }

        return current;
    }

    public void inOrder() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node<T> node) {
        if (node != null) {
            inOrderRecursive(node.getLeft());
            System.out.println(node.getValue() + " ");
            inOrderRecursive(node.getRight());
        }
    }

    public T search (T value){
        return searchRecursive(root, value);
    }

    public T searchRecursive(Node<T> root2, T value){
        return null;
    }

    public T searchByAge(int i){
        return searchByAgeRecursive(root, i);
    }
    
    public T searchByAgeRecursive (Node<T> current, int edad){
        if (current == null){
            return null;
        }

        Persona persona = (Persona) current.getValue();

        if(edad == persona.getEdad()){
            return current.getValue();
        }

        if(edad < persona.getEdad()){
            return searchByAgeRecursive(current.getLeft(), edad);
        }else{
            return searchByAgeRecursive(current.getRight(), edad);
        }
    }
}
