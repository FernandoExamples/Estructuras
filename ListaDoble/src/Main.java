public class Main {
    public static void main(String[] args){
        DobleList list = new DobleList();
            int n;
        for (int i = 0; i < 10; i++) {
            n = (int) (Math.random() * (50-1+1) + 1);
            list.insert(n);
        }

        list.printStack();

        for (int i = 0; i < 10; i++) {
            n = (int) (Math.random() * (50-1+1) + 1);
            if (list.delete(n))
                System.out.println("Borrado "+n);
            else
                System.out.println("No existe "+n);
        }

        System.out.println("Lista final-------------------------");

        list.printStack();

    }

}
