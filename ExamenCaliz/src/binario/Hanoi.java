package binario;

public class Hanoi {

    public void ordenar(int n, char x, char y, char z){
        if(n == 1){
            System.out.println("Mueve de "+x+" a "+y+"\n");
        }else{
            ordenar(n-1,x,z,y);
            System.out.println("Mueve de "+x+" a "+y+"\n");
            ordenar(n-1,z,y,x);
        }
    }
}
