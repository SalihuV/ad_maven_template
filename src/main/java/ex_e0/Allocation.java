/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_e0;

import java.util.Objects;

/**
 *
 * @author Valon
 */
public class Allocation {

    private final int memorySize;
    private final int memoryAdress;

    public Allocation(final int mSize,
            final int mAdress) {
        this.memorySize = mSize;
        this.memoryAdress = mAdress;
    }

    public int getMemorySize() {
        return this.memorySize;
    }
    
    public int getMemoryAdress()
    {
        return this.memoryAdress;
    }
    
    @Override
    public boolean equals(final Object other)
    {
        if(this == other)
        {
            return true;
        }
        if (!(other instanceof Allocation))
        {
            return false;
        }
        final Allocation alloc = (Allocation) other;
        return (this.memoryAdress == alloc.memoryAdress) && (this.memorySize == alloc.memorySize);
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(Integer.valueOf(this.memoryAdress),Integer.valueOf(this.memorySize));
    }
}
