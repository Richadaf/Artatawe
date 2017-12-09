package data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import users.User;

/**
 * The Data class is responsible for saving information about all users, artwork
 * and other related information to file
 *
 * @author Richard Famoroti modified by 863266
 *
 *
 */
public class Data {

    private static final String FILE_DELIMETER = "--end--";
    private static ArrayList<User> users = new ArrayList<User>();
    //ArtworkTree artworks;	
    //+GET_ALL_USERS(): UserFile[]	

    /**
     * Returns all the Users registered to Artatawe.
     *
     * @return the Users registered to Artatawe
     */
    public static ArrayList<User> getAllUsers() {
        return users;
    }

    //SAVE_USERFILE(file: UserFile): Boolean
    /**
     * Responsible for saving user to file
     *
     * @param mUser user
     * @return {@code true} if file was successfully saved to file;
     * {@code false} otherwise.
     */
    private static User mUser;

    public static boolean saveUser(User mUser) {
        File file = new File("users.txt");
        BufferedWriter writer = null;

        try {
            if (!file.isFile()) {
                file.createNewFile();
            }

            //if user isnt in list, add and refresh database
            if (checkUserExistInFile(mUser.getUserName()) == null) {
                users.add(mUser);
                Data.reset();
                writer = new BufferedWriter(new FileWriter(file));
                for (User u : getAllUsers()) {
                    writer.write(userToTxt(u));
                    writer.write("\n");
                    writer.write(FILE_DELIMETER);
                    writer.write("\n");
                }
            }
            
            //User foundProfile = null;
            //foundProfile = checkUserExistInFile(mUser.getUserName());

            if (checkUserExistInFile(mUser.getUserName()) == null) {
                users.add(mUser);
                writer = new BufferedWriter(new FileWriter(file, true));
                writer.write(userToTxt(mUser));
                writer.write("\n");
                writer.write(FILE_DELIMETER);
                writer.write("\n");
            }
             
            if (writer != null) {
                writer.close();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String userToTxt(User u) {
        String txtProfile = "";
        txtProfile += u.getUserName() + " ";
        txtProfile += u.getFirstName()+ " ";
        txtProfile += u.getLastName()+ " ";
        txtProfile += u.getPhoneNumber()+ " ";
        txtProfile += u.getAddress()+ " ";                        
        return txtProfile;
    }

    //Resets all files
    /**
     * Resets all files back to empty
     */
    public static void reset() {
        File file = new File("users.txt");
        if (file.isFile()) {
            file.delete();
            return;
        }
    }

    /**
     * Searches user database for username that matches {@code username}
     *
     * @see User
     * @param username user-defined username
     * @return User instance with matching username
     */
    public static User getUser(User user) {
        for (User u : users) {
            if (u.getUserName().equalsIgnoreCase(user.getUserName())) {
                return u;
            }
        }
        /*//User isnt found in arrayList, so check file name
         User checkedUser = checkUserExistInFile(username);
         if(checkedUser != null){
         users.add(checkedUser);
         return checkedUser;
         }*/
        return null;
    }

    //+GET_USER_ID(file: UserFile): int
    //Should be in User\
    //+ART_INORDER():Artworks[]   should be in artwork tree 
    //Check file if user exists in file
    private static Boolean checkUserExistInFile(String userName) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("users.txt"));
            String currentLine;

            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                if (currentLine.contains(userName)) {
                    return true;
                } else if (currentLine.contains(FILE_DELIMETER)) {
                    return false;
                }
            }

            if (scanner != null) {
                scanner.close();
            }
        } catch (FileNotFoundException e) {
            return null;
        }
        return null;

    } 
    
    private Scanner x;
    
    public static void populate() {

        File file = new File("users.txt");
        if (!file.isFile()) {
            return;
        }
        
        Scanner fileScan = null;
        
        try {
            fileScan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        fileScan.useDelimiter(FILE_DELIMETER);
        String userName = "";
        String firstName = "";
        String lastName = "";
        String phoneNumber = "";
        String address = "";
        
        while (fileScan.hasNextLine()) {

            Scanner line = new Scanner(fileScan.nextLine());
            line.useDelimiter(":|\n|".concat(FILE_DELIMETER));
            
            while (line.hasNext()) {
                String userField = line.next();
//                String value = line.next();
                if (userField.equals("UserName")) {
                    userName = line.next();
//                    userName = value;
                }
                if (userField.equals("First Name")) {
                    firstName = line.next();
//                    firstName = value;
                }
                if (userField.equals("Last Name")) {
                    lastName = line.next();
//                    lastName = value;
                }
                if (userField.equals("Phone Number")) {
                    phoneNumber = line.next();
                }
                if (userField.equals("Address")) {
                    address = line.next();
//                    address = value;
                }
            }
            //line.close();
        }
        if (getUser(mUser) == null) {
            users.add(new User(userName, firstName, lastName, String.valueOf(phoneNumber), address));
        }    
    }
}
