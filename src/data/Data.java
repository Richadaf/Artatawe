package data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import users.Artwork;
import users.User;

/**
 * The Data class is responsible for saving information about all users, artwork
 * and other related information to file
 *
 * @author Richard Famoroti & 863266
 *
 *
 */
public class Data {

    private static final String FILE_DELIMETER = "--end--";
    public static final String FILE_NAME = "users.txt"; //gloably change filename
    private static ArrayList<User> users = new ArrayList<User>();
    private static ArrayList<Artwork> artworks = new ArrayList<Artwork>();
    //TOEO: Artwor, Bidding History
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

    /**
     * Returns all the artworks registered to Artatawe.
     *
     * @return the artworks registered to Artatawe
     */
    public static ArrayList<Artwork> getAllArtworks() {
        return artworks;
    }

    /**
     * Responsible for saving user to file
     *
     * @param mUser user
     * @return {@code true} if file was successfully saved to file;
     * {@code false} otherwise.
     */
    public static boolean saveUser(User mUser) {
        File file = new File(FILE_NAME);
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

    /**
     * Responsible for saving user to file
     *
     * @param u user
     * @return User information needed to be printed into the file
     */
    public static String userToTxt(User u) {
        String txtProfile = "";
        txtProfile += u.getUserName() + "\t";
        txtProfile += u.getFirstName() + "\t";
        txtProfile += u.getLastName() + "\t";
        txtProfile += u.getPhoneNumber() + "\t";
        txtProfile += u.getAddress() + "\t";
        return txtProfile;
    }

    /**
     * Resets all files back to empty
     */
    public static void reset() {
        File file = new File(FILE_NAME);
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
    public static User getUser(User username) {
        for (User u : users) {
            if (u.getUserName().equalsIgnoreCase(username.getUserName())) {
                return u;
            }
        }
        return null;
    }

    /**
     * Check if there's already a user in the database {@code user}
     *
     * @see User
     * @param userName user-defined username
     * @return {@code true} if a user is found in the database
     * {@code false} otherwise
     */
    private static Boolean checkUserExistInFile(String userName) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(FILE_NAME));
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

    /**
     * Responsible for saving artwork to file
     *
     * @param art Artwork
     * @return {@code true} if artwork was successfully saved to file;
     * {@code false} otherwise.
     */
    public static boolean saveArtwork(Artwork art) {

        File file = new File("artworks.txt");
        BufferedWriter writer = null;

        try {
            if (!file.isFile()) {
                file.createNewFile();
            }

            //if artwork isnt in list, add and refresh database
            if (getArtwork(art.getTitle()) == null) {
                artworks.add(art);

                Data.reset();
                writer = new BufferedWriter(new FileWriter(file));
                for (Artwork a : getAllArtworks()) {
                    writer.write(a.toString());
                    writer.write("\n");
                    writer.write(FILE_DELIMETER);
                    writer.write("\n");
                }
            }

           /* Artwork foundArtwork = null;
            foundArtwork = checkArtExistInFile(art.getTitle());

            if (foundArtwork == null) {
                artworks.add(art);
                writer = new BufferedWriter(new FileWriter(file, true));
                writer.write(art.toString());
                writer.write("\n");
                writer.write(FILE_DELIMETER);
                writer.write("\n");
            }*/
            if (writer != null) {
                writer.close();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Searches user database for username that matches {@code username}
     *
     * @see User
     * @param username user-defined username
     * @return User instance with matching username
     */
    public static User getUser(String username) {
        for (User u : users) {
            if (u.getUserName().equalsIgnoreCase(username)) {
                return u;
            }
        }
        return null;
    }

    /**
     * Searches artwork database for artwork that matches {@code artwork}
     *
     * @see Artwork
     * @param title user-defined title of the artwork
     * @return Artwork instance with matching title
     */
    public static Artwork getArtwork(String title){
        for(Artwork a: artworks){
            if(a.getTitle().equalsIgnoreCase(title)){
                return a;
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

    public static ArrayList<Artwork> getArtworkBySellerName(String seller){
        ArrayList<Artwork> everyArtworks = getAllArtworks();
        ArrayList<Artwork> temp = new ArrayList<Artwork>();
        for(int i=0;i<everyArtworks.size();i++){
            if (everyArtworks.get(i).getSeller().equalsIgnoreCase(seller)) {
                temp.add(everyArtworks.get(i));
            }
        }
      /*//User isnt found in arrayList, so check file name
      User checkedUser = checkUserExistInFile(username);
      if(checkedUser != null){
         users.add(checkedUser);
         return checkedUser;
      }*/
        return temp;
    }

    public static void populate(){
        File file = new File("users.txt");
        if(!file.isFile()){
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
        int phoneNumber = -1;
        String address = "";
        String avatar = "";
        while(fileScan.hasNextLine()){

            Scanner line = new Scanner(fileScan.nextLine());
            line.useDelimiter(":-|\n|".concat(FILE_DELIMETER));
            while(line.hasNext()){
                String userField = line.next();
                String value = line.next();
                if (userField.equals("UserName")) {
//             userName = line.next();
                    userName = value;
                }
                if (userField.equals("First Name")) {
//             firstName = line.next();
                    firstName = value;
                }
                if (userField.equals("Last Name")) {
//             lastName = line.next();
                    lastName = value;
                }
                if (userField.equals("Phone Number")) {
//             phoneNumber = line.nextInt();
                    phoneNumber = Integer.parseInt(value);
                }
                if (userField.equals("Address")) {
//             address = line.next();
                    address = value;
                }
                if (userField.equals("Image")) {
                    avatar = value;
                }
            }
            //line.close();
        }
        if(getUser(userName) == null){
            User u = new User(userName,firstName,lastName,String.valueOf(phoneNumber),address);
            u.setAvatar(avatar);
            users.add(u);
        }
    }

    public static void populateArtwork(){
        File file = new File("artworks.txt");
        if(!file.isFile()){
            return;
        }
        Scanner fileScan = null;
        try {
            fileScan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        fileScan.useDelimiter(FILE_DELIMETER);
        String seller = "";
        String title = "";
        String description = "";
        String photo = "";
        String nameOfCreator = "";
        int yearMade = -1;
        double reservePrice = -1.0;
        double currentPrice = -1.0;
        int bidsAllowed = -1;
        String timeEntered  = "";
        double height = -1.0;
        double width = -1.0;
        while(fileScan.hasNextLine()){

            Scanner line = new Scanner(fileScan.nextLine());
            line.useDelimiter(":-|\n|".concat(FILE_DELIMETER));
            while(line.hasNext()){
                String artworkField = line.next();
                String value = line.next();
                if (artworkField.equals("Seller")) {
//             userName = line.next();
                    seller = value;
                }
                if (artworkField.equals("Title")) {
//             firstName = line.next();
                    title = value;
                }
                if (artworkField.equals("Description")) {
//             lastName = line.next();
                    description = value;
                }
                if (artworkField.equals("Photo")) {
//             phoneNumber = line.nextInt();
                    photo = value;
                }
                if (artworkField.equals("Creator")) {
//             address = line.next();
                    nameOfCreator = value;
                }
                if (artworkField.equals("YearMade")) {
                    yearMade = Integer.parseInt(value);
                }
                if (artworkField.equals("reservePrice")) {
                    reservePrice = Double.parseDouble(value);
                }
                if (artworkField.equals("CurrentPrice")) {
                    currentPrice = Double.parseDouble(value);
                }
                if (artworkField.equals("BidsAllowed")) {
                    bidsAllowed = Integer.parseInt(value);
                }
                if (artworkField.equals("TimeEntered")) {
                    timeEntered = value;
                }
                if (artworkField.equals("Height")) {
                    height = Double.parseDouble(value);
                }
                if (artworkField.equals("Width")) {
                    width =  Double.parseDouble(value);
                }
            }
            //line.close();
        }
        if(getArtwork(seller) == null){
            Artwork a = new Artwork(seller, title, description, photo, nameOfCreator, yearMade, reservePrice,
                    currentPrice, bidsAllowed, timeEntered, height, width);
            artworks.add(a);
        }
    }

    /**
     * Check if there's already an artwork in the database {@code artwork}
     *
     * @see Artwork
     * @param title user-defined title of the artwork
     * @return {@code true} if an artwork is found in the database
     * {@code false} otherwise
     */
    private static Artwork checkArtExistInFile(String title) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("artworks.txt"));
            String currentLine;

            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                if (currentLine.contains(title)) {
                    return getArtwork(title);
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
}
