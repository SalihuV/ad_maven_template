/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_array_listen_stack_queue;

/**
 *
 * @author Valon
 */
public class Stack<T> implements StackInterface {

    private Object[] stack;

    public Stack(final int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Muss grösser 0 sein");
        }
        this.stack = new Object[size];
    }

    @Override
    public void push(final Object value) {
        for (int i = 0; i < this.stack.length; i++) {
            if (this.stack[i] == null) {
                this.stack[i] = value;
            } else {
                if (i == this.stack.length - 1) {
                    throw new StackException("stack is full");
                }
            }
        }
    }

    @Override
    public T pop() {
        for (int i = this.stack.length - 1; i > -1; i--) {
            if (this.stack[i] != null) {
                Object value = this.stack[i];
                this.stack[i] = null;
                return (T) value;
            }
        }
        return null;
    }

    @Override
    public int count() {
        int count = 0;
        for (int i = 0; i < this.stack.length; i++) {
            if (this.stack[i] != null) {
                count++;
            } else {
                break;

            }
        }
        return count;
    }

}
