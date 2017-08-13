package javaapplication11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

enum Gfsd
{
    Ids, op // static-elements of enum
}

enum EVGEN 
{
    java, php;   
    int level;   
    
    public void setLevel(int l)
    {
        this.level = l;
    }   
}

public class Controller
{
    public static void main(String[] args) 
    {
        A a = new B();
        a.m2(); // "B" // polymorphism
        
        A b = new B();
        //B bbb = b; //compile error
        B b2 = (B)b;
        
        A b3 = new A();
        //B bbb = b3; //compile error
        //B bbb = (B)b3; //ClassCastException, A cannot be cast to B
        
        B b4 = new B();
        A aaa = (A)b4;
        
        
        C<B> c = new C<B>(); // generic-class
        c.m3();
        
        D d1 = new D(1);
        D d2 = new D(2);
        d2 = d1; // 
        d1.d = 5;
        System.out.println("d1.d = " + d1.d); 
        System.out.println("d2.d = " + d2.d);
        d2.d = 7;
        // d1 = null; // it erases one of two links to the object, so the object will
        // exist
        System.out.println("d1.d = " + d1.d); 
        System.out.println("d2.d = " + d2.d);
        
        System.gc(); // increase the chance of clearing (garbage collector)
        
        Gfsd d;
        d = Gfsd.Ids;
        System.out.println(d.Ids);
               
        EVGEN javaOfEvgen = EVGEN.java;  
        javaOfEvgen.setLevel(10);
        EVGEN.java.setLevel(5);
        
        
        Integer sda = new Integer(7);
        Integer sda2 = new Integer(7);
        //sda2 = sda;
        //sda += 5;
        System.out.println("sda = " + sda + ", sda2 = " + sda2);
        
        System.out.println(sda.intValue() == sda2.intValue());
        System.out.println(sda.compareTo(sda2));
        System.out.println(sda.equals(sda2));
        System.out.println(sda == sda2);
        System.out.println(sda.hashCode() == sda2.hashCode());
        
        
        
        Set products = new HashSet();
        products.add(new Product("product1", 2));
        products.add(new Product("product2", 3));
        System.out.println(products); // here's working method toString, 
                                      // which was overriden         
        
        
        List items = new ArrayList();
        items.add("f");
        items.add(2);
        System.out.println(items);
        final List immutableList = items; // it's not immutable List, it's just final-link "immutableList"
        // immutableList = null; // compile error
        immutableList.add(3);
        items.add("item4");
        // items = null; // it erases the link to the object, but there is the 
                        // other link -- immutableList, so the object wasn't deleted
        
        
        List trueImmutableList = Collections.unmodifiableList(items); // immutableList
        // trueImmutableList.add(132); // will cause UnsupportedOperationException
        
        
        System.out.println("items link is equal immutableList link, items = " + items);
        System.out.println("items link is equal immutableList link, immutableList = " + immutableList);
        
        String s1 = "asd"; // merging Strings
        String s2 = "123";
        String s3 = s1 + s2;
        System.out.println(s3);
        
        s2 = "321sdfasgweg sdfsd"; // merging Strings
        s3 = s1.concat(s2);
        System.out.println(s3);
        
        s3 = s2.substring(2); // division Strings
        System.out.println(s3);
        s3 = s2.substring(1, 8);
        System.out.println(s3);     
        
        
        IA testI = new B();
        testI.a1();
    
        int y = 1000;
        byte by = (byte)y;
        System.out.println(by); // -24
        
        D testNumber = new D(3);
        Number n = new Integer(1);
        Long l = new Long(22222222);
        Integer i = 9;
        testNumber.m4(n);
        testNumber.m4(l);
        testNumber.m4(i);
        
        System.out.println("testPublicStaticFinalInt from interface = " +
                IA.testPublicStaticFinalInt);
        b4.mI(); // overloaded method String mI()
        b4.mI('c'); // method from class A int mI(char w)
    }   
}

