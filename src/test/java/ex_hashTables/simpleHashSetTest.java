/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_hashTables;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Valon
 */
public class simpleHashSetTest {

    @Test
    public void initHashSet() {
        simpleHashSet hs = new simpleHashSet(100);
        assertEquals(100, hs.getSize());

    }
    
    @Test
    public void addNodeHashSet()
    {
        simpleHashSet hs = new simpleHashSet(2);
        hs.add(32);
        //assertEquals()
 
    }

}
