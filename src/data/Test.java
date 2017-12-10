/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static data.Data.FILE_NAME;
import static data.Data.populate;
import static data.FileReader.readFile;
import users.User;

/**
 *
 * @author Smith
 */
public class Test {
        public static void main(String[] args) {
            readFile(FILE_NAME);
                   
            //Populate users.txt            
            populate();
            User admin = new users.User("admin", "John", "Smith", "123", "Swansea", "images/User_Avatar.png");
            User User1 = new User("numbah1", "Simon", "Jones", "321", "Cardiff", "images/User_Avatar.png");
            User User2 = new User("2nd", "Mike", "Phillips", "029378478547", "Wales", "images/User_Avatar.png");
//            saveUser(admin);
//            saveUser(User1);
//            saveUser(User2);
            
            //Read users.txt          
                        
            BSTreeNode root = null;
            BSTree userTree = new BSTree(root);

            userTree.insertProfile(admin);
            userTree.insertProfile(User1);
            userTree.printLeftToRight();
            System.out.println("=========");
            System.out.println("Adding 2");
            System.out.println("=========");
            userTree.insertProfile(User2);
            userTree.printLeftToRight();
            
            String p = "admin";  
            
            //TODO: impliment tree search to return user profile.
                        
        }
    
    
}
