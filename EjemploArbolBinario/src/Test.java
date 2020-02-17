public class Test {

    public static void main(String [] args){
        Tree arbol = new Tree();

        arbol.insertNode(5);
        arbol.insertNode(12);
        arbol.insertNode(23);
        arbol.insertNode(9);
        arbol.insertNode(9);
        arbol.insertNode(1);

        System.out.println(arbol.existElement(12));
        System.out.println(arbol.existElement(1));
        System.out.println(arbol.existElement(9));
        System.out.println(arbol.existElement(100));

        System.out.println("PreOrden");
        arbol.preOrder(arbol.root);
        System.out.println();

        System.out.println("PostOrden");
        arbol.postOrder(arbol.root);
        System.out.println();

        System.out.println("InOrden");
        arbol.inOrder(arbol.root);
        System.out.println();

        System.out.println("-------------------Pruebas de borrado-------------------");
        System.out.println(arbol.delete(100));
        System.out.println(arbol.delete(12));
        System.out.println(arbol.delete(9));
        System.out.println(arbol.delete(9));
        System.out.println(arbol.delete(1));
        System.out.println(arbol.delete(23));
        //System.out.println(arbol.delete(5));

        arbol.inOrder(arbol.root);
    }
}
