/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda_virtual;

/**
 *
 * @author fanat
 */
public class treeNode <T> {
    public T key;
    public treeNode<T> father;
    public treeNode<T> leftSon;
    public treeNode<T> rightSon;
    public int Height;

    public treeNode(T key, treeNode father) {
        this.key = key;
        this.father = father;
    }
    
    
}
