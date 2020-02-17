public class ColaCircular {
    private Node front;
    private Node back;

    public ColaCircular(){
        front = null;
        back = null;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public void printTile(){
        if(!isEmpty()){
            Node aux = front;
            while (aux != back){
                System.out.println(aux.element);
                aux = aux.next;
            }
            System.out.println(back.element);
        }
    }


    public void push(int element){
        Node aux = new Node(element);

        if(isEmpty()){
            front = aux;
            back = aux;
            back.next = front;
        }else{
            aux.next = front;
            back.next = aux;
            back = aux;
        }
    }

    public int pop(){
        int element = Integer.MIN_VALUE;
        if(!isEmpty())
            if(front == back){
                element = front.element;
                front = null;
                back = null;
            }else{
                element = front.element;
                front = front.next;
                back.next = front;
            }

        return element;
    }

    public int peek(){
        return front.element;
    }
}
