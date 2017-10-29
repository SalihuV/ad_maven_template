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
public interface TreeInterface<T extends Comparable<T>> {

    TreeNode getRootNode();

    void addNode(final T value);

    void removeNode(final T value);

    Tree search(final T value);
}
