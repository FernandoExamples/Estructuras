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
            end.next = start;
        }else if(element <= start.element){
            aux.next = start;
            start = aux;
            end.next = start;
        }else if(element >= end.element){
            end.next = aux;
            end = aux;
            end.next = start;
        }else{
            Node anterior = start;
            Node actual = start;

            while (element > actual.element){
                anterior = actual;
                actual = actual.next;
            }

            aux.next = actual;
            anterior.next = aux;
        }
    }

    public boolean delete(int element){
        boolean succes = true;

        if(!isEmpty())
            if(start == end && start.element == element){
                start = null;
                end = null;
            }else if(start.element == element){
                start = start.next;
                end.next = start;
            }else{
                Node anterior = start;
                Node actual = start;

                while (element != actual.element && actual.next != end){
                    anterior = actual;
                    actual = actual.next;
                }

                if(actual.next != end)
                    anterior.next = actual.next;
                else if(end.element == element) {
                    actual.next = start;
                    end = actual;
                }
                else if(actual.element == element)
                    anterior.next = actual.next;
                else
                    succes = false;

            }

        return succes;
    }
}
