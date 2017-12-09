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
            userToString(admin);
        }
                //for testing
        public static void userToString(User user){
                System.out.print("User: " + user.getUserName());
                System.out.print("Name: " + user.getFirstName() + user.getLastName());
                System.out.print("Number: " + user.getPhoneNumber());
                System.out.print("Address: " + user.getAddress());

        }
            
            //Find user data from users.txt
}
