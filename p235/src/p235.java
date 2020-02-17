import java.util.Scanner;

public class p235 {
    Scanner keyboard;
    int proves;
    DobleList listFichas;

    public p235(Scanner k) {
        keyboard = k;
        listFichas = new DobleList();
    }

    void readProves() {
        proves = keyboard.nextInt();
        keyboard.nextLine();
    }

    boolean readFichas(String secuencia) {
        int num1, num2;
        Ficha ficha;
        boolean sePuede = true;

        for (int index = 0; index < secuencia.length(); index += 4) {

            num1 = secuencia.charAt(index) - 48;
            num2 = secuencia.charAt(index + 2) - 48;
            ficha = new Ficha(num1, num2);

            if (!listFichas.verifyRepeat(ficha)) {
                if(listFichas.connect(ficha) == 0){
                    sePuede = false;
                    break;
                }
            }else{
                sePuede = false;
                break;
            }
        }

        return sePuede;
    }

    boolean verifyConnections() {
        return listFichas.verifyWrongConnection();
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        p235 problema = new p235(keyboard);

        problema.readProves();

        String[] secuencias = new String[problema.proves];

        for (int casos = 0; casos < problema.proves; casos++)
            secuencias[casos] = keyboard.nextLine();

        for (String caso : secuencias) {

            problema.listFichas.clearList();

            if (problema.readFichas(caso))
                System.out.println("OK");
            else
                System.out.println("NOK");
        }

    }

}
