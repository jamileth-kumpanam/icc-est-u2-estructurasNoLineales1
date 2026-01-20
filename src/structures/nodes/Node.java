package structures.nodes;

import java.util.List;
import java.util.Objects;

public class Node<T> {

    private T value;
    private Node<T> left;
    private Node<T> right;
    private List<Node<T>> neighbors;

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.neighbors = null;
    }

    public Node(T value, Node<T> left, Node<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.neighbors = null;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node<?> node)) return false;
        return Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "N[" + value + "]";
    }
}
