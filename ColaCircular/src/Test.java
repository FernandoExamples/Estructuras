public class Test {
    public static void main(String[] args) {
        ColaCircular colaCircular = new ColaCircular();

        colaCircular.push(4);
        colaCircular.push(6);
        colaCircular.push(3);
        colaCircular.push(6);
        colaCircular.push(1);
        colaCircular.push(7);

        colaCircular.printTile();

        System.out.println("Despues de borrar--------------------------");

        System.out.println(colaCircular.pop());
        System.out.println(colaCircular.pop());
        System.out.println(colaCircular.pop());
        System.out.println(colaCircular.pop());
        System.out.println(colaCircular.pop());

    }
}
