/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_hashTables;

/**
 *
 * @author Valon
 */
public interface simpleHashSetInterface <E> {
    
    public void add(E e);
    public E get(int hashCode);
    public int getSize();
    
}
