public class Node {
    Node next;
    Node previous;
    int element;

    public Node(int element) {
        this.element = element;
        next = null;
        previous = null;
    }
}
