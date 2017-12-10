package users;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * This Class stores information about a user.
 * @author 869298 & 863266
 */
public class User {
    private static final AtomicInteger count = new AtomicInteger(0); 
    // Josh: Could these be constants?
//    private int userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String avatar;
    private ArrayList<User> favoriteUsers;
    private BiddingHistory biddingHistory;
    /**
     * 
     * User Class constructor
     * @param userName The user's username
     * @param firstName The user's First name
     * @param lastName The user's Last name
     * @param phoneNumber The user's Phone Number
     * @param address  The user's Address
     */
    public User(String userName, String firstName, String lastName, String phoneNumber, String address ) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
//        userId = count.incrementAndGet(); 
        avatar = "";//images/User_Avatar.png"; // TODO: default avatar
        this.favoriteUsers = new ArrayList<>();
        this.biddingHistory = new BiddingHistory();
        
    }
    /**
     * Get the user's userID
     * @return The userID
     */
//    public int getUserId() {
//        return userId;
//    }
    /**
     *  Get this user's username
     * @return The username
     */
    public String getUserName() {
        return userName;
    }
    /**
     *  Get this user's FirstName
     * @return  The First Name
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     *  Get this user's Last Name
     * @return  The Last Name
     */
    public String getLastName() {
        return lastName;
    }
    /**
     *  Get this user's PhoneNumber
     * @return The user's PhoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * get a list of the user's favorite users
     * @return a list of the user's favorite users.
     */
    public ArrayList<User> getFavoriteUsers() {
        return favoriteUsers;
    }
    /**
     * Get the user's Address
     * @return The user's Address
     */
    public String getAddress() {
        return address;
    }
    /**
     * Get the user's Avatar
     * @return The user's Avatar
     */
    
    public String getAvatar(){
        return avatar;
    }
    /**
     * Returns an list of user bids as bid objects
     * @return The arrayList of bid objects that this user has bid on.
     */
    
    public ArrayList<Bid> getBids(){
        return biddingHistory.getUserBids();
    }
    /**
     * Change the user's avatar
     * @param avatar the URL of the user's avatar
     */
    
    public void setAvatar(String avatar) {
         this.avatar = avatar;
    }
     /**
     * Add a user to the list of favorite users
     * @param user The user to be added
     */
    
    public void addFavoriteUser(User user) {
        favoriteUsers.add(user);
    }

    @Override
    public String toString(){
        return "UserName:-" + userName + "\n" + "First Name:-" + firstName + "\n"  + "Last Name:-" + lastName + "\n" + "Phone Number:-" + phoneNumber + "\n" + "Address:-" + address + "\n" + "Image:-" + avatar;
    }



}
