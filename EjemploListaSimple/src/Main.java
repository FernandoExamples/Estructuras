public class Main {
    public static void main(String[] args){
        MyList list = new MyList();
        list.insert(5);
        list.insert(8);
        list.insert(4);
        list.insert(2);
        list.insert(6);
        list.insert(10);
        list.printList();

        System.out.println("Borrar----------------------------------");
        if(list.delete(5))
            System.out.println("Borrado: "+5);
        else
            System.out.println("No eciste el "+5);

        if(list.delete(4))
            System.out.println("Borrado: "+4);
        else
            System.out.println("No eciste el"+4);

        if(list.delete(1))
            System.out.println("Borrado: "+1);
        else
            System.out.println("No eciste el "+1);

        if(list.delete(100))
            System.out.println("Borrado: "+100);
        else
            System.out.println("No eciste el "+100);

        System.out.println("lista final------------------------------------");
        list.printList();
    }
}
