/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_tree;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Valon
 */
public class TreeNodeTest {

    @Test
    public void initTreeNodeTest1() {
        TreeNode t = new TreeNode(1);
        assertEquals(1, t.getValue());

    }

    @Test
    public void initTreeNodeTest2() {
        TreeNode t = new TreeNode(1);
        t.setValue(2);
        assertEquals(2, t.getValue());

    }

    @Test
    public void getLeftNode() {
        TreeNode t = new TreeNode(2);
        t.addNode(new TreeNode(1));
        TreeNode x = t.getLeftNode();
        assertEquals(1, x.getValue());
    }

    @Test
    public void getRightNode() {
        TreeNode t = new TreeNode(2);
        t.addNode(new TreeNode(1));
        t.addNode(new TreeNode(3));
        TreeNode x = t.getRightNode();
        assertEquals(3, x.getValue());
    }
    @Test
    public void getLeftNode2()
    {
        TreeNode t = new TreeNode(4);
        t.addNode(new TreeNode(2));
        t.addNode(new TreeNode(3));
        t.addNode(new TreeNode(1));
        TreeNode x = t.getLeftNode();
        TreeNode y = x.getLeftNode();
        assertEquals(1,y.getValue());
    }

}
