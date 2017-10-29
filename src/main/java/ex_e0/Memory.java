/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_e0;

/**
 *
 * @author Valon
 */
public interface Memory {

    public Allocation malloc(int bytes);

    public void free(Allocation alloc);

}
