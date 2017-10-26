/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_array_listen_stack_queue;

import java.util.Objects;

/**
 *
 * @author Valon
 */
public class Allocation implements Comparable {

    private final int startAdr;
    private final int size;

    public Allocation(int startAdr, int size) {
        this.startAdr = startAdr;
        this.size = size;
    }

    public int compareTo(Object obj) {
        // return 0 if identical reference
        if (this == obj) {
            return 0;
        }

        final Allocation other = (Allocation) obj;

        if (this.startAdr < other.startAdr) {
            return -1;
        }
        if (this.startAdr > other.startAdr) {
            return 1;
        }
        return 0;
    }

    @Override
    final public int hashCode() {
        return Objects.hash(this.startAdr, this.size);
    }

    @Override
    final public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Allocation)) {
            return false;
        }
        final Allocation other = (Allocation) obj;
        return other.startAdr == this.startAdr && other.size == this.size;
    }

    @Override
    final public String toString() {
        return "Allocation[Address:" + this.getStartAddr()
                + "; Size:" + this.getSize() + "]";
    }

    public int getStartAddr() {
        return startAdr;
    }

    public int getSize() {
        return size;
    }
}
