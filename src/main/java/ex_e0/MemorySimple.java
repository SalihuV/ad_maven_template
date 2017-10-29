/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_e0;

import java.util.*;

/**
 *
 * @author Valon
 */
public class MemorySimple implements Memory {

    private LinkedHashMap table = new LinkedHashMap();

    public MemorySimple(int size) {

    }

    public Allocation malloc(final int address,final int size) {
        Allocation a = new Allocation(address,size);
        table.put(a, size);
        return a;
    }

    public void free(Allocation a) {
        table.remove(a);
    }

}
