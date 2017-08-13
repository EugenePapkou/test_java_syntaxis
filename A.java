package javaapplication11;

public class A
{
    void m1()
    {
        System.out.println("A");
    }
    
    void m2()
    {
        m1();
    }
    
    public int mI(char w)
    {
        System.out.println("int mI(char w); char w = " + w);
        return 34;
        
    }
}
