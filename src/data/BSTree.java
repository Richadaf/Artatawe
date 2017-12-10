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
public class BSTree {
    BSTreeNode root;        

    public BSTree(BSTreeNode root){
        this.root = root;
    }
 
    public void insertProfile(User p){
        
        if(root == null){
            this.root = new BSTreeNode(p);           
        }else{
            recursiveInsert(p);
        }
    }
        
    private void recursiveInsert(User p){
        String rootName = (root.getUser()).getUserName();
        String profileName = (p.getUserName());
        
        if (profileName.compareTo(rootName) > 0){            
            if( root.getRight() == null){
                root.rightChild = new BSTreeNode(p);
            }else{
                root = root.getRight();
                recursiveInsert(p);
            }            
        }else{
            
            if( root.getLeft() == null){
                root.leftChild = new BSTreeNode(p);
            }else{
                root = root.getLeft();
                recursiveInsert(p);
            }
        }
        
    }   
    
    public void printRightToLeft(BSTreeNode node) {
        
        if(node != null) {
            if(node.getRight() != null) {
                printRightToLeft(node.getRight());
            }
            System.out.println(node.NodeToString());
            if(node.getLeft() != null) {
                printRightToLeft(node.getLeft());
            }
        }
    }

    public void printLeftToRight(BSTreeNode node) {
        
        if(node != null) {
            if(node.getLeft() != null) {
                printLeftToRight(node.getLeft());
            }
            System.out.println(node.NodeToString());
            if(node.getRight() != null) {
                printLeftToRight(node.getRight());
            }
        }
    }
    

    public void printRightToLeft() {
        printRightToLeft(this.root);
    }

    public void printLeftToRight() {
        printLeftToRight(this.root);
    }

    public BSTreeNode locate(String p, BSTreeNode node){      
        
        BSTreeNode result = null;
        
        if (node == null) {
            return null;
        }
        if (node.NodeToString().equals(p)) {
            return node;
        }
        if (node.leftChild != null) {
            result = locate(p, node.leftChild);
        }
        if (result == null) {
            result = locate(p, node.rightChild);
        }
        return result;
    }
  

}


