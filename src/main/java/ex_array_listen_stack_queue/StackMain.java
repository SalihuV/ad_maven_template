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
public class StackMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                Stack s = new Stack(4);
        s.push("toll");
        s.push("sind");
        s.push("Ferien");
        System.out.println(s.pop());

        
    }
    
}
