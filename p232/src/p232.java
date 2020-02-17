/*
Construye una aplicación que permita calcular el promedio una lista de calificaciones de alumnos.
 La entrada contiene en el primer renglón el número de alumnos que contiene la lista y en los renglones
  siguientes el número de control, nombre completo (sin espacios) y las calificaciones de los cuatro
   parciales todo separado por espacios. Sin embargo la lista no viene ordenada, el programa debe
   leer los datos de entrada y construir una lista de estudiantes ordenados por el número de control.
   Una vez que la lista está construida, el programa debe calcular el promedio general del grupo redondeado
    a un numero entero. Nota:
ignora los puntos que vienen al inicio de los renglones que aparecen a continuación.
 */

import java.util.Scanner;

public class p232 {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        MyList list = new MyList();
        int n;
        int cal1, cal2, cal3, cal4;
        String numControl, nombre;

        n = keyboard.nextInt();
        keyboard.nextLine();

        for (int i = 0; i < n; i++) {
            numControl = keyboard.next();
            nombre = keyboard.next();
            cal1 = keyboard.nextInt();
            cal2 = keyboard.nextInt();
            cal3 = keyboard.nextInt();
            cal4 = keyboard.nextInt();
            keyboard.nextLine();

            list.add(new Alumno(numControl,nombre,cal1,cal2,cal3,cal4));
        }

        System.out.println(list.getPromedio());
    }
}

class Alumno{
    private String numControl;
    private String nombre;
    private int cal1, cal2, cal3, cal4;

    public Alumno(String numControl, String nombre, int cal1, int cal2, int cal3, int cal4) {
        this.numControl = numControl;
        this.nombre = nombre;
        this.cal1 = cal1;
        this.cal2 = cal2;
        this.cal3 = cal3;
        this.cal4 = cal4;
    }

    public String getNumControl() {
        return numControl;
    }

    public int getCal1() {
        return cal1;
    }

    public int getCal2() {
        return cal2;
    }

    public int getCal3() {
        return cal3;
    }

    public int getCal4() {
        return cal4;
    }
}

class Nodo{
    Alumno elemento;
    Nodo next;

    public Nodo(Alumno alumno) {
        this.elemento = alumno;
        next = null;
    }
}

class MyList{
    Nodo inicio;

    public MyList(){
        inicio = null;
    }

    public boolean isEmpty(){
        return inicio == null;
    }

    public void add(Alumno alumno){
        Nodo aux = new Nodo(alumno);
        String numInsertar = aux.elemento.getNumControl();
        String numActual = "";

        if(isEmpty()) {
            inicio = aux;
        }
        else if(inicio.elemento.getNumControl().compareTo(numInsertar) > 0){
            aux.next = inicio;
            inicio = aux;
        }else{
            Nodo actual = inicio, anterior = inicio;
            numActual = actual.elemento.getNumControl();

            while (numActual.compareTo(numInsertar) < 0 && actual.next != null){
                anterior = actual;
                actual = actual.next;
                numActual = actual.elemento.getNumControl();
            }

            if(numActual.compareTo(numInsertar) > 0){
                aux.next = actual;
                anterior = aux;
            }else
                actual.next = aux;

        }
    }

    public int getPromedio(){
        int promAlumno = 0;
        int promGeneral = 0;
        int acumAlumno = 0;
        int acumGeneral = 0;
        int numAlumnos = 0;
        if(!isEmpty()){
            Nodo anterior = inicio, actual = inicio;

            while (actual.next != null){
                acumAlumno += actual.elemento.getCal1() + actual.elemento.getCal2() + actual.elemento.getCal3() + actual.elemento.getCal4();
                promAlumno = acumAlumno / 4;
                acumAlumno = 0;

                acumGeneral += promAlumno;

                actual = actual;
                actual = actual.next;
                numAlumnos++;
            }

            acumAlumno += actual.elemento.getCal1() + actual.elemento.getCal2() + actual.elemento.getCal3() + actual.elemento.getCal4();
            promAlumno = acumAlumno / 4;

            acumGeneral += promAlumno;
            numAlumnos++;

            promGeneral = acumGeneral / numAlumnos;
        }

        return promGeneral;
    }
}
