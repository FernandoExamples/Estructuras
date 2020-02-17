public class Test {
    public static void main(String[] args){
        DoubleRoundList list = new DoubleRoundList();

        list.insert(5);
        list.insert(4);
        list.insert(3);
        list.insert(2);
        list.insert(1);

        list.printList();

        list.delete(4);

        System.out.println("Lista eliminada------------------------------");

        list.printList();
    }
}
