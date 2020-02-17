import java.math.BigInteger;
import java.util.Scanner;

/**
 * Usa una pila para obtener el factorial de un número almacenando los elemento desde n, n-1, n-2,
 * hasta 1 y después recupera todos los elementos de la pila y calcula los productos para obtener
 * el factorial del número n, en dónde 1<= n <=100
 *  La entrada contiene en el primer renglón el número de casos a probar de tipo entero y en
 *  los renglones siguientes números enteros para calcular su factorial, la salida debe imprimir los resultados de los
 *  factoriales en formato entero, es decir, sin punto decimal, uno por renglón.
 */
public class p1
{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        Stack stack = new Stack();
        int factorial;
        BigInteger result, aux;

        int numCases = keyboard.nextInt();
        int proves[] = new int[numCases];

        for (int j = 0; j < numCases; j++)
            proves[j] = keyboard.nextInt();

        for (int k = 0; k < numCases; k++) {
            factorial = proves[k];

            for (int i = factorial; i > 0; i--)
                stack.push(i);

            result = new BigInteger("1");
            while (!stack.isEmpty()){
                aux = new BigInteger(String.valueOf(stack.pop()));
                result = result.multiply(aux);
            }

            System.out.println(result);

        }

    }
}

class Node
{
    int element;
    Node autocue;

    public Node(int element){
        autocue = null;
        this.element = element;
    }

}

class Stack
{
    Node top;

    public Stack(){
        top = null;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void push(int element){
        Node newNode = new Node(element);
        newNode.autocue = top;
        top = newNode;
    }

    public int pop(){
        int aux = -1;
        if(!isEmpty()){
            aux = top.element;
            top = top.autocue;
        }
        return aux;
    }

    public void printStack(){
        Node aux = top;
        if(!isEmpty()){
            while(aux != null){
                System.out.println(aux.element);
                aux = aux.autocue;
            }
        }
    }
}



