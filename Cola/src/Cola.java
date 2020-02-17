public class Cola {
    Node front;
    Node back;

    public Cola(){
        front = null;
        back = null;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public void printCola(){
        if(!isEmpty()){
            Node aux = front;
            while (aux != null){
                System.out.println(aux.element);
                aux = aux.next;
            }
        }
    }

    public void push(float element){
        Node aux = new Node(element);
        if(isEmpty()){
            front = aux;
            back = aux;
        }else {
            back.next = aux;
            back = back.next;
        }
    }

    public float peek(){
        if(!isEmpty())
            return front.element;
        else
            return Float.NaN;
    }

    public float pop(){
        float element = Float.NaN;
        if(!isEmpty())
            if(front == back){
                element = front.element;
                front = null;
                back = null;
            }else{
                element = front.element;
                front = front.next;
            }

        return element;
    }
}
