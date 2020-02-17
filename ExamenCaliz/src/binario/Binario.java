package binario;

public class Binario {

    public String convertir(int numero){
        int cociente = numero/2;
        int residuo = numero % 2;

        if(cociente == 0){
            return 1+"";
        }else{
            String binario = convertir(cociente) + residuo;
            return binario;
        }
    }
}
