/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import users.User;

/**
 *
 * @author Smith
 */
public class BSTreeNode {
    User data;
    BSTreeNode leftChild;
    BSTreeNode rightChild;
    
    /**
     *
     * @param data
     */
    public BSTreeNode(User data){    
    this.data = data;

    }

    
    public User getUser(){
        return data;
    }
    
    /**
     *
     * @param l
     */
    public void setLeft(BSTreeNode l){
        this.leftChild = leftChild;        
        
    }
    
    /**
     *
     * @param r
     */
    public void setRight(BSTreeNode r){
        this.rightChild = rightChild;
    }
        
    BSTreeNode getLeft(){
        return leftChild;
    }
    
    BSTreeNode getRight(){
        return rightChild;
    }

    /**
     *
     * @return
     */
    public String NodeToString(){        
        return data.getUserName();
    }

    
}
