public class Test {

    public static void main(String[] args) {
        DoubleRoundList list = new DoubleRoundList();

        list.insert(7);
        list.insert(8);
        list.insert(1);
        list.insert(5);
        list.insert(2);
        list.insert(4);
        list.insert(9);

        list.insert(7);
        list.insert(8);
        list.insert(1);
        list.insert(5);
        list.insert(2);
        list.insert(4);
        list.insert(9);

        list.printList();

        System.out.println("Despues de borrar -------------------------------");

        list.delete(7);
        list.delete(9);
        list.delete(8);
        list.delete(1);

        list.printList();
    }
}
