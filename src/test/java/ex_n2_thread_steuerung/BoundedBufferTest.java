/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_n2_thread_steuerung;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertNull;

/**
 *
 * @author Valon
 */
public class BoundedBufferTest {

    @Test
    public void testSeqPutSize() throws InterruptedException {
        BoundedBuffer<Integer> buffer = new BoundedBuffer<>(5);
        assertEquals(5, buffer.size());
    }

    @Test
    public void testSeqPutIsFull() throws InterruptedException {
        BoundedBuffer<Integer> buffer = new BoundedBuffer<>(5);
        buffer.put(1);
        buffer.put(2);
        buffer.put(3);
        buffer.put(4);
        buffer.put(5);
        assertTrue(buffer.full());
    }

    @Test
    public void testSeqPutIsEmpty() throws InterruptedException {
        BoundedBuffer<Integer> buffer = new BoundedBuffer<>(5);
        assertTrue(buffer.empty());
    }

    @Test
    public void tetSeqGet() throws InterruptedException {
        BoundedBuffer<Integer> buffer = new BoundedBuffer<>(1);
        buffer.put(1);
        assertEquals(new Integer(1), buffer.get());
    }

    @Test
    public void testSeqGet2() throws InterruptedException {
        BoundedBuffer<Integer> buffer = new BoundedBuffer<>(2);
        buffer.put(1);
        buffer.put(2);
        buffer.get();
        assertEquals(new Integer(2), buffer.get());
    }

    private class ConsumerElement<T> {

        public T element;
    }

    @Test
    public void testAsyncWaitGet_element1IsNull() throws InterruptedException {
        BoundedBuffer<Integer> buffer = new BoundedBuffer<>(5);

        ConsumerElement<Integer> c1Element = new ConsumerElement<>();
        ConsumerElement<Integer> c2Element = new ConsumerElement<>();

        // set up two consumers to read from buffer
        Thread c1 = new Thread(() -> {
            try {
                c1Element.element = buffer.get();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        Thread c2 = new Thread(() -> {
            try {
                c2Element.element = buffer.get();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        // start consumers
        c1.start();
        c2.start();

        // give the threads a chance to get elements (case of wrong implementation)
        Thread.sleep(250);

        assertNull(c1Element.element);

    }

    @Test
    public void testAsyncWaitGet_element2IsNull() throws InterruptedException {
        BoundedBuffer<Integer> buffer = new BoundedBuffer<>(5);

        ConsumerElement<Integer> c1Element = new ConsumerElement<>();
        ConsumerElement<Integer> c2Element = new ConsumerElement<>();

        // set up two consumers to read from buffer
        Thread c1 = new Thread(() -> {
            try {
                c1Element.element = buffer.get();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        Thread c2 = new Thread(() -> {
            try {
                c2Element.element = buffer.get();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        // start consumers
        c1.start();
        c2.start();

        // give the threads a chance to get elements (case of wrong implementation)
        Thread.sleep(250);

        assertNull(c2Element.element);

    }

    @Test
    public void testAsyncWaitGetBothElements() throws InterruptedException {
        BoundedBuffer<Integer> buffer = new BoundedBuffer<>(5);

        ConsumerElement<Integer> c1Element = new ConsumerElement<>();
        ConsumerElement<Integer> c2Element = new ConsumerElement<>();

        // set up two consumers to read from buffer
        Thread c1 = new Thread(() -> {
            try {
                c1Element.element = buffer.get();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        Thread c2 = new Thread(() -> {
            try {
                c2Element.element = buffer.get();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        // start consumers
        c1.start();
        c2.start();

        // give the threads a chance to get elements (case of wrong implementation)
        Thread.sleep(250);

        // produce a value and expect that it was consumed
        buffer.put(21);
        Thread.sleep(250);

        assertTrue(new Integer(21).equals(c1Element.element) ^ (new Integer(21).equals(c2Element.element)));
    }

    @Test
    public void testAsyncWaitGet3Elements() throws InterruptedException {
        BoundedBuffer<Integer> buffer = new BoundedBuffer<>(5);

        ConsumerElement<Integer> c1Element = new ConsumerElement<>();
        ConsumerElement<Integer> c2Element = new ConsumerElement<>();
        ConsumerElement<Integer> c3Element = new ConsumerElement<>();

        // set up two consumers to read from buffer
        Thread c1 = new Thread(() -> {
            try {
                c1Element.element = buffer.get();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        Thread c2 = new Thread(() -> {
            try {
                c2Element.element = buffer.get();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        Thread c3 = new Thread(() -> {
            try {
                c3Element.element = buffer.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // start consumers
        c1.start();
        c2.start();
        c3.start();

        // give the threads a chance to get elements (case of wrong implementation)
        Thread.sleep(250);

        // produce a value and expect that it was consumed
        buffer.put(21);
        Thread.sleep(250);

        assertTrue(new Integer(21).equals(c1Element.element) ^ (new Integer(21).equals(c2Element.element)) ^ (new Integer(21).equals(c3Element.element)));
    }
}
