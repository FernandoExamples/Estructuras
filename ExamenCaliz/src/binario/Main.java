package binario;

public class Main {
    public static void main(String[] args){

        Binario binario = new Binario();
        System.out.println(binario.convertir(33));

        Hanoi hanoi = new Hanoi();
        hanoi.ordenar(4, 'n','c', 'b');
    }
}
