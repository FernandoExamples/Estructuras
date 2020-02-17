public class Pila {
    public Nodo tope;

    public Pila(){
        tope = null;
    }

    public boolean isEmpty(){
        return tope == null;
    }

    //meter un elemento a la pila
    public void push(int element){
        Nodo nodo = new Nodo(element);
        nodo.apuntador = tope;
        tope = nodo;
    }

    //sacar un elemento de la pila
    public int pop(){
        int valorTope = 0;
        if(!isEmpty()){
            valorTope = tope.numero;
            tope = tope.apuntador;
        }
        return valorTope;
    }

    //imprimir el contenido de la pila
    public void imprimePila(){
        Nodo aux = tope;
        if(!isEmpty()){
            while (aux != null){
                System.out.println(aux.numero);
                aux = aux.apuntador;
            }
        }
    }
}

