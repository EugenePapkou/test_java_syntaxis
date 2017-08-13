package javaapplication11;

public class B extends A implements IA
{
    void m1()
    {
        System.out.println("B");
    }   

    public String mI()
    {
        System.out.println("String mI()");
        return "34";                       
    }
    
    @Override
    public void a1() {
        System.out.println("interface method");
    }
}
