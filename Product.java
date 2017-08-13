/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication11;

/**
 *
 * @author admin
 */
public class Product 
{
    public Product(String title, int size)
    {
        this.title = title;
        this.size = size;
    }
    
    String title;
    int size;
    
    @Override
    public String toString()
    {
        return title + ":" + size;
    }
}
