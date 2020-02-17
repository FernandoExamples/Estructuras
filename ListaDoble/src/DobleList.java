public class DobleList {
    Node start, end;

    public DobleList(){
        start = null;
        end = null;
    }

    public boolean isEmpty(){
        return start == null;
    }

    public void printStack(){
        Node actual = start;
        if(!isEmpty()){
            while (actual != null){
                System.out.println(actual.element);
                actual = actual.next;
            }
        }
    }

    public void insert(int element){
        Node aux = new Node(element);
        if(isEmpty()){
            start = aux;
            end = aux;
        }else if(element <= start.element){
            aux.next = start;
            start.before = aux;
            start = aux;
        }else if(element >= end.element){
            aux.before = end;
            end.next = aux;
            end = aux;
        }else{
            Node inicio = start;
            Node fin = end;

            while (inicio.element < element && fin.element > element){
                inicio = inicio.next;
                fin = fin.before;
            }

            if(element >= fin.element){
                aux.next = fin.next;
                fin.next.before = aux;
                fin.next = aux;
                aux.before = fin;
            }else{
                aux.before = inicio.before;
                inicio.before.next = aux;
                inicio.before = aux;
                aux.next = inicio;
            }
        }
    }

    public boolean delete(int element){
        boolean succes = false;

        if (element < start.element || element > end.element)
            succes = false;
        else if(start.equals(end) && start.element == element){
            start = end = null;
            succes = true;
        }else if(start.element == element) {
            start = start.next;
            start.before = null;
            succes = true;
        }else if(end.element == element){
            end = end.before;
            end.next = null;
            succes = true;
        }else{
            Node inicio = start;
            Node fin = end;

            while (inicio.element != element && fin.element != element && inicio.element < fin.element){
                inicio = inicio.next;
                fin = fin.before;
            }

            if(inicio.element == element){
                inicio.before.next = inicio.next;
                inicio = inicio.before;
                inicio.next.before = inicio;
                succes = true;
            }else if(fin.element == element){
                fin.next.before = fin.before;
                fin = fin.next;
                fin.before.next = fin;
                succes = true;
            }
        }

        return succes;

    }
}
