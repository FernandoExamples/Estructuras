import java.util.Scanner;

/**
 * Verifique por medio de una pila si una cadena de caracteres está balanceada en paréntesis o no.
 * Esto significa que la expresión debe contener las misma cantidad de paréntesis abiertos y cerrados,
 * colocados de manera que haya coincidencia entre todos los paréntesis. Encontrar un paréntesis cerrado
 * antes de uno abierto es considerado un error por lo tanto la expresión no está balanceada.
 * La entrada contiene en el primer renglón el número de expresiones para la comprobación de paréntesis
 * y en los reglones siguientes los casos como cadenas de caracteres que sólo pueden contener letras minúsculas
 * y los símbolos de paréntesis. La salida debe mostrar
 * las respuestas por renglón "correcto" o "incorrecto" si la expresión está balanceada o no.
 */
public class p230 {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner keyboard = new Scanner(System.in);

        String expresion;
        char character;
        boolean exit = true;

        int numCases = keyboard.nextInt();
        keyboard.nextLine();

        String proves[] = new String[numCases];
        for (int i = 0; i < numCases; i++) {
            proves[i] = keyboard.nextLine();
        }

        for (int k = 0; k < numCases; k++) {

            expresion = proves[k];
            exit = true;

            for (int i = 0; i < expresion.length() && exit; i++) {

                character = expresion.charAt(i);

                if (character == '(' || character == ')') {
                    if (character == ')') {
                        if (stack.isEmpty()) {
                            System.out.println("incorrecto");
                            exit = false;
                        } else
                            stack.pop();
                    } else {
                        stack.push(character);
                    }
                }
            }

            if (stack.isEmpty() && exit) {
                System.out.println("correcto");
            } else if (exit) {
                System.out.println("incorrecto");
            }
        }


    }
}
