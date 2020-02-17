public class DoubleRoundList {
    Node start;
    Node end;

    public DoubleRoundList(){
        start = null;
        end = null;
    }

    public boolean isEmpty(){
        return start == null;
    }

    public void printList(){
        if(!isEmpty()){
            Node aux = start;
            while (aux != end){
                System.out.println(aux.element);
                aux = aux.next;
            }
            System.out.println(end.element);
        }
    }

    public void insert(int element){
        Node aux = new Node(element);

        if(isEmpty()){
            start = aux;
            end = aux;
            aux.next = end;
            aux.previous = start;
        }else if (element <= start.element){
            aux.next = start;
            aux.previous = end;
            start.previous = aux;
            start = aux;
            end.next = start;
        }else if(element >= end.element){
            end.next = aux;
            aux.previous = end;
            aux.next = start;
            start.previous = aux;
            end = aux;
        }else{
            Node inicio = start;
            Node fin = end;
            while (inicio.element < element && fin.element > element){
                inicio = inicio.next;
                fin = fin.previous;
            }

            if(element <= inicio.element){
                aux.next = inicio;
                aux.previous = inicio.previous;
                inicio.previous.next = aux;
                inicio.previous = aux;
            }else if(element >= fin.element){
                aux.next = fin.next;
                aux.previous = fin;
                fin.next.previous = aux;
                fin.next = aux;
            }
        }
    }

    public boolean delete(int element){
        boolean succes = false;
        if(!isEmpty())
            if (element == start.element){
                if(start == end) {
                    start = null;
                    end = null;
                }else{
                    start = start.next;
                    end.next = start;
                    start.previous = end;
                }
                succes = true;

            }else if(element == end.element){
                end = end.previous;
                end.next = start;
                start.previous = end;
                succes = true;
            }else{
                Node inicio = start;
                Node fin = end;
                while (inicio.element != element && fin.element != element && inicio != fin){
                    inicio = inicio.next;
                    fin = fin.previous;
                }

                if(inicio.element == element){
                    inicio.previous.next = inicio.next;
                    inicio.next.previous = inicio.previous;
                    succes = true;
                }else if(fin.element == element){
                    fin.previous.next = fin.next;
                    fin.next.previous = fin.previous;
                    succes = true;
                }else
                    succes = false;
            }

        return succes;
    }
}
