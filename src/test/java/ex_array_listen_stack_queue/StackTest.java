/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_array_listen_stack_queue;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Valon
 */
public class StackTest {
    
    @Test
    public void TestPush(){
        Stack s = new Stack(3);
        s.push("toll");
        s.push("sind");
        s.push("Ferien");
        for (int i =0; i <3; i++)
        {
            System.out.println(s.pop());
        }
        
    }
}
