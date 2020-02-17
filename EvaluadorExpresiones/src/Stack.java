public class Stack {
    Node top;

    public Stack(){
        top = null;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void push(char element){
        Node node = new Node(element);
        node.autocue = top;
        top = node;
    }

    public char pop(){
        Node aux;
        char element = Character.OTHER_SYMBOL;
        if(!isEmpty()){
            aux = top;
            top = top.autocue;
            element = aux.element;
        }
        return element;
    }
}
