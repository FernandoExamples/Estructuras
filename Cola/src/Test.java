public class Test {
    public static void main(String[] args){
        Cola cola = new Cola();

        cola.push(20);
        cola.push(25);
        cola.push(30);
        cola.push(35);
        cola.push(40);
        cola.push(45);

        System.out.println("Print list----------------");
        cola.printCola();

        System.out.println("Pop------------------------");
        System.out.println(cola.pop());
        System.out.println(cola.pop());
        System.out.println(cola.pop());
        System.out.println(cola.pop());

        System.out.println("Print list----------------");
        cola.printCola();
    }
}
