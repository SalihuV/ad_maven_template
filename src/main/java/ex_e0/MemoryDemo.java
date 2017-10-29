/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_e0;

import org.apache.logging.log4j.*;

/**
 *
 * @author Valon
 */
public class MemoryDemo {

    private static final Logger LOG = LogManager.getLogger(MemoryDemo.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final Memory memory = new MemorySimple(1024);
        LOG.info(memory);
        final Allocation block1 = memory.malloc(16);
        LOG.info(block1);
        LOG.info(memory);
        final Allocation block2 = memory.malloc(8);
        LOG.info(block2);
        LOG.info(memory);
        memory.free(block1);

    }

}
