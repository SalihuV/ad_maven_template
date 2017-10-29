/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_tree;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Valon
 */
public class Tree<T extends Comparable<T>> implements TreeInterface<T> {

    static Logger LOG = LogManager.getLogger(Tree.class);
    
    private TreeNode rootNode;
    
    @Override
    public TreeNode getRootNode()
    {
        return this.rootNode;
    }
    
    @Override
    public void removeNode(final T value)
    {
       TreeNode node = this.search(value);
       TreeNode leftNode = node.getParent(node, node);
       TreeNode rightNode = node.getParent(node,node);
    }
}
