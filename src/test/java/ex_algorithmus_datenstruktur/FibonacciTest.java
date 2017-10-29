/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_algorithmus_datenstruktur;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Valon
 */
public class FibonacciTest {

    @Test
    public void TestfiboRec1() {
        assertEquals(1, new Fibonacci().fiboRec1(2));
    }

    @Test
    public void TestfiboRec1X() {
        assertEquals(3, new Fibonacci().fiboRec1(4));
    }

    @Test
    public void TestfiboRec1Y() {
        assertEquals(987, new Fibonacci().fiboRec1(16));
    }

}
