public class MyList {
    Node first;

    public MyList() {
        first = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insert(int element){
        Node aux = new Node(element);

        if(isEmpty())
            first = aux;
        else if(aux.element < first.element){
            aux.next = first;
            first = aux;
        }else{

            Node actual = first;
            Node before = first;
            while (actual != null && actual.element < aux.element){
                before = actual;
                actual = actual.next;
            }

            if(actual != null){
                aux.next = actual;
                before.next = aux;
            }else
                before.next = aux;
        }

    }

    public boolean delete(int element){
        boolean succes = false;

        if(!isEmpty()){
            Node actual = first;
            Node before = first;

           if(element >= first.element){

               while (actual != null && actual.element != element){
                   before = actual;
                   actual = actual.next;
               }

               if(actual != null){
                   before.next = actual.next;
                   succes = true;
               }
           }

        }
        return succes;
    }

    public void printList(){
        Node aux = first;
        while (aux.next != null){
            System.out.println(aux.element);
            aux = aux.next;
        }
        System.out.println(aux.element);
    }
}
