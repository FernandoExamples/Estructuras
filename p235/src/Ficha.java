public class Ficha
{
    private int a_numero1, a_numero2;

    public Ficha(int p_numero1, int p_numero2)
    {
        a_numero1 = p_numero1;
        a_numero2 = p_numero2;
    }

    public int getNumero1(){
        return a_numero1;
    }

    public int getNumero2(){
        return a_numero2;
    }

    public boolean veriIguales(Ficha p_ficha){
        Ficha v_ficha = p_ficha;

        if(a_numero1 == v_ficha.getNumero1())
            return a_numero2 == v_ficha.getNumero2();

        else if(a_numero1 == v_ficha.getNumero2())
           return a_numero2 == v_ficha.getNumero1();

        else
            return false;
    }
}