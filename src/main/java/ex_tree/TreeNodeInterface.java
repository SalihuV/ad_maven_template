/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_tree;

/**
 *
 * @author Valon
 */
public interface TreeNodeInterface {

    int getValue();

    void setValue(final int value);

    void addNode(TreeNode node);
    
    TreeNode parent(TreeNode node);

    TreeNode getParent(TreeNode root, TreeNode node);
    
    TreeNode getLeftNode();

    TreeNode getRightNode();

    TreeNode search(int value);
}
