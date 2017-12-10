/**
 * 
 * @author 863266
 *
 */
package data;
import java.io.*;
import java.util.Scanner;
import users.User;

/**
 * class to read user text file and construct user profiles
 * TODO: implement users artwork and favorite users 
 *  * @author Smith
 */
public class FileReader {
     
	private static User constructProfile (String userName, String firstName, String lastName, String phoneNumber, String address, String avatar) {
                        
            User newUser = new User(userName, firstName, lastName, phoneNumber, address, avatar);
            //Testing
            System.out.println(newUser.toString());
            
            return newUser;
        }  
    
	/**
	 * Reads the data file
	 * @param in the scanner of the file
	 * @return 
	 */
	private static BSTree readDataFile (Scanner in) {
            BSTreeNode root = null;
            BSTree newTree = new BSTree(root);
		
            while (in.hasNext()){

                String userName = in.next();
                String username = userName;                
                String firstName;
                String lastName;
                String phoneNumber;
                String address;
                String avatar;
                //TODO; List of users artworks, list of favorite profiles  
                //String[] favoriteUsers = {"user1", "user2"};                
         
                firstName = in.next();
                lastName = in.next();
                phoneNumber = in.next();
                address = in.next();
                avatar = in.next();
                
                constructProfile(username, firstName, lastName, phoneNumber, address, avatar);
                break;                                        
                }             
                return newTree;
        }        
	
        /**
         *
         * @param filename
         * @return
         */
        public static BSTree readFile (String filename) {
                File inputFile = new File (filename);
                Scanner in = null;
                try {
                    in = new Scanner (inputFile);
                }
                catch (FileNotFoundException e) {
                    System.out.println ("Cannot open " + filename);
                    System.exit (0);
                }                  

                return FileReader.readDataFile(in);
        }

   }