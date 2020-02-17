public class DobleList {
    Node start, end;

    public DobleList(){
        start = null;
        end = null;
    }

    public boolean isEmpty(){
        return start == null;
    }

    public void printList(){
        Node actual = start;
        if(!isEmpty()){
            while (actual != null){
                System.out.print("["+actual.element+" "+actual.next.element+"] ");
                actual = actual.next.next;
            }
        }
    }

    private void putFirst(Ficha ficha){
        Node aux = new Node(ficha.getNumero1());
        Node aux2 = new Node(ficha.getNumero2());

        aux.next = aux2;
        aux2.before = aux;

        start = aux;
        end = aux;
    }

    public void putOnRigth(Ficha ficha){
        if(isEmpty())
            putFirst(ficha);
        else{
            Node aux = new Node(ficha.getNumero1());
            Node aux2 = new Node(ficha.getNumero2());

            aux.next = aux2;
            aux2.before = aux;

            end.next.next = aux;
            aux.before = end.next;
            end = aux;
        }
    }

    public void putOnLeft(Ficha ficha){
        if(isEmpty())
            putFirst(ficha);
        else{
            Node aux = new Node(ficha.getNumero1());
            Node aux2 = new Node(ficha.getNumero2());

            aux.next = aux2;
            aux2.before = aux;

            aux2.next = start;
            start.before = aux2;
            start = aux;
        }
    }

    public boolean verifyRepeat(Ficha ficha){
        Node actual = start;
        int num1, num2;
        Ficha fichaActual;

        if(!isEmpty()){
            while (actual != null){
                num1 = actual.element;
                num2 = actual.next.element;
                fichaActual = new Ficha(num1, num2);

                if(fichaActual.veriIguales(ficha))
                    return true;

                actual = actual.next.next;
            }
        }

        return false;
    }

    /**
     * Verifica si la ficha se puede colocar de lado derecho o izquierdo, de ser asi la conecta.
     * @param ficha
     * @return 1 derecho, -1 izqueirdo, 0 no se puede colocar
     */
    public int connect(Ficha ficha){
        int place;
        Ficha primera = getFirst();
        Ficha ultima = getEnd();

        if(!isEmpty()) {
            if (ficha.getNumero1() == ultima.getNumero2()) {
                putOnRigth(ficha);
                place = 1;
            } else if (ficha.getNumero2() == primera.getNumero1()) {
                putOnLeft(ficha);
                place = -1;
            } else if (ficha.getNumero2() == ultima.getNumero2()) {
                ficha = rotateFicha(ficha);
                putOnRigth(ficha);
                place = 1;
            } else if (ficha.getNumero1() == primera.getNumero1()) {
                ficha = rotateFicha(ficha);
                putOnLeft(ficha);
                place = -1;
            } else {
                place = 0;
            }
        }else {
            putFirst(ficha);
            place = 1;
        }

        return place;
    }


    private Ficha rotateFicha(Ficha ficha){
        int n1 = ficha.getNumero1();
        int n2 = ficha.getNumero2();
        return new Ficha(n2, n1);
    }

    /**
     * Devuelve un true si la conexion es erronea
     * @return
     */
    public boolean verifyWrongConnection(){
        Node actual = start;
        int num2, num3;

        if(!isEmpty()){
            while (actual.next.next != null){
                num2 = actual.next.element;
                num3 = actual.next.next.element;

                if(num2 != num3)
                    return true;

                actual = actual.next.next;
            }
        }

        return false;
    }

    public Ficha getFirst(){
        Ficha ficha = null;
        if(!isEmpty()) {
            int n1 = start.element;
            int n2 = start.next.element;
            ficha = new Ficha(n1, n2);
        }
        return ficha;
    }

    public Ficha getEnd(){
        Ficha ficha = null;
        if(!isEmpty()) {
            int n1 = end.element;
            int n2 = end.next.element;
            ficha = new Ficha(n1, n2);
        }
        return ficha;
    }

    public void clearList(){
        start = null;
        end = null;
    }

    private class Node {
        int element;
        Node next;
        Node before;

        Node(int element) {
            this.element = element;
            next = null;
            before = null;
        }
    }
}



