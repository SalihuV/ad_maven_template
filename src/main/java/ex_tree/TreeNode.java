/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_tree;

import java.util.Comparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.omg.CORBA.SystemException;

/**
 *
 * @author Valon
 */
public class TreeNode implements TreeNodeInterface {
    
    static Logger Log = LogManager.getLogger(TreeNode.class);
    private int value;
    private TreeNode leftNode;
    private TreeNode rightNode;
    private TreeNode parent;
    
    public TreeNode(final int value) {
        this.value = value;
    }
    
    @Override
    public int getValue() {
        return this.value;
    }
    
    @Override
    public void setValue(final int value) {
        this.value = value;
    }
    
    @Override
    public void addNode(TreeNode node) {
        if (node.getValue() == this.getValue()) {
            throw new ArrayIndexOutOfBoundsException("same value");
        }
        if (node.getValue() < this.getValue()) {
            if (this.leftNode == null) {
                this.leftNode = node;
            } else {
                this.leftNode.addNode(node);
            }
            
        } else {
            if (this.rightNode == null) {
                this.rightNode = node;
            } else {
                this.rightNode.addNode(node);
            }
        }
    }
    
    @Override
    public TreeNode getLeftNode() {
        return this.leftNode;
    }
    
    @Override
    public TreeNode getRightNode() {
        return this.rightNode;
    }
    
    @Override
    public TreeNode search(int value) {
        if (this.getValue() == value) {
            return this;
        } else if (value < this.getValue()) {
            if (this.getLeftNode() == null) {
                throw new ArrayIndexOutOfBoundsException("Value could not be found");
            }
            return this.getLeftNode().search(value);
        } else {
            if (this.getRightNode() == null) {
                throw new ArrayIndexOutOfBoundsException("Value can not be found");
            }
            return this.getRightNode().search(value);
        }
        
    }
    
    @Override
    public TreeNode parent(TreeNode node) {
        return getParent(this.parent, node);
    }
    
    @Override
    public TreeNode getParent(TreeNode root, TreeNode node) {
        if (node == root || root == null) {
            return null;
        } else if (root.getLeftNode() == node || root.getRightNode() == node) {
            return root;
        } else {
            if (root.getValue() < node.getValue()) {
                return getParent(root.getRightNode(), node);
            } else {
                return getParent(root.getLeftNode(), node);
            }
            
        }
        
    }
    
}
