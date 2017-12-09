/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import users.User;

/**
 *
 * @author 863266
 */
public class Test {
        public static void main(String[] args) {
            //Populate users.txt            
            Data.populate();
            users.User admin = new users.User("admin", "John", "Smith", "123", "Swansea");
            Data.saveUser(admin);     
            
            //Read users.txt
            if (Data.getUser(admin) == null) {
                System.err.println("USER NOT FOUND");
            }
            Data.userToTxt(Data.getUser(admin));
            
            
        }
                    
            //Find user data from users.txt
}
