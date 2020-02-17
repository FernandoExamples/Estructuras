public class Tree {

    Node root;

    public Tree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean existElement(int search) {
        boolean exist = false;
        if (!isEmpty()) {
            Node aux = root;

            while (aux != null && !exist) {

                if (aux.element == search)
                    exist = true;
                else if (search > aux.element)
                    aux = aux.rigth;
                else
                    aux = aux.left;
            }
        }

        return exist;
    }

    public void inOrder(Node auxiliar) {
        if (auxiliar != null) {
            //ir a la izquierda
            inOrder(auxiliar.left);

            //tratar nodo
            System.out.print(auxiliar.element + " ");

            //ir a la derecha
            inOrder(auxiliar.rigth);
        }
    }

    public void preOrder(Node auxiliar) {
        if (auxiliar != null) {
            //tratar nodo
            System.out.print(auxiliar.element + " ");

            //ir a la izquierda
            preOrder(auxiliar.left);

            //ir a la derecha
            preOrder(auxiliar.rigth);
        }
    }

    public void postOrder(Node auxiliar) {
        if (auxiliar != null) {
            //ir a la izquierda
            postOrder(auxiliar.left);

            //ir a la derecha
            postOrder(auxiliar.rigth);

            //tratar nodo
            System.out.print(auxiliar.element + " ");
        }
    }

    public void insertNode(int element) {
        Node aux = new Node(element);

        if (isEmpty()) {
            root = aux;
        } else {
            Node anterior, actual;
            anterior = actual = root;

            while (actual != null) {

                if (element < actual.element) {
                    anterior = actual;
                    actual = anterior.left;
                } else {
                    anterior = actual;
                    actual = anterior.rigth;
                }
            }

            if (element < anterior.element)
                anterior.left = aux;
            else
                anterior.rigth = aux;

        }

    }

    public boolean delete(int element) {
        boolean succes = false;

        if (!isEmpty()) {
            Node anterior, actual;
            anterior = actual = root;

            boolean encontrado = false;

            while (actual != null && !encontrado) {

                if (actual.element == element)
                    encontrado = true;

                else if (actual.element < element) {
                    anterior = actual;
                    actual = anterior.rigth;
                } else {
                    anterior = actual;
                    actual = anterior.left;
                }

            }

            if (encontrado) {

                //caso A y B (sin hijos)
                if (actual.rigth == null && actual.left == null)
                    if (actual == anterior)
                        root = null;
                    else if (anterior.left == actual)
                        anterior.left = null;
                    else
                        anterior.rigth = null;

                //caso C (hijos solo a la derecha)
                if (actual.left == null && actual.rigth != null) {
                    if (actual == anterior) //se quiere eliminar la raiz
                        root = actual.rigth;
                    else if (anterior.left == actual)
                        anterior.left = actual.rigth;
                    else
                        anterior.rigth = actual.rigth;
                }

                //caso D (Espejo del C) (hijos solo a la izquierda)
                if (actual.rigth == null && actual.left != null) {
                    if (actual == anterior) //se quiere eliminar la raiz
                        root = actual.left;
                    else if (anterior.rigth == actual)
                        anterior.rigth = actual.left;
                    else
                        anterior.left = actual.left;
                }

                //caso E (hijos en ambos lados)
                if (actual.left != null && actual.rigth != null) {
                    Node origen = actual;

                    anterior = actual;
                    actual = actual.left;

                    if (actual.rigth == null) {
                        anterior.element = actual.element;
                        anterior.left = actual.left;
                    } else {
                        while (actual.rigth != null) {
                            anterior = actual;
                            actual = actual.rigth;
                        }

                        if (actual.left != null) {
                            origen.element = actual.element;
                            anterior.rigth = actual.left;
                        } else {
                            origen.element = actual.element;
                            anterior.rigth = null;
                        }
                    }
                }

                succes = true;
            }
        }

        return succes;
    }

}
