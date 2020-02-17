public class Proceso {
    int semilla, numRandom;
    String resultado;

    public Proceso(int semilla, int numRandom) {
        this.semilla = semilla;
        this.numRandom = numRandom;
    }

    public void multiplicar() {
        int aux = semilla * numRandom;
        resultado = refactorizar(aux);
    }

    public String substraer() {
        String sub = resultado.substring(2, 6);
        return sub;
    }

    public String refactorizar(int refactor) {
        String aux = String.valueOf(refactor);

        if (aux.length() < 8) {

            int numCeros = 8 - aux.length();
            String ceros = "";
            for (int i = 0; i < numCeros; i++)
                ceros += "0";

            aux = ceros + aux;
        }
        return aux;
    }

    public void conmutar(String substring){
        semilla = numRandom;
        numRandom = Integer.valueOf(substring);
    }

    public boolean verificar(String substring){
        int aux = Integer.valueOf(substring);
        return aux != semilla;
    }

    public void start(){
        String sub;
        int i = 1;
        do{
            multiplicar();
            sub = substraer();
            conmutar(sub);

            System.out.println(i +" "+sub);
            i++;
        }while (verificar(sub));
    }
}
