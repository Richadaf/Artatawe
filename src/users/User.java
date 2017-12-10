package users;
import java.util.ArrayList;


/**
 * This Class stores information about a user.
 * @author 869298 & 863266
 */
public class User {
    private final String USER_NAME;
    private final String FIRST_NAME;
    private final String LAST_NAME;
    private final String PHONE_NUMBER;
    private final String ADDRESS;
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
     * @param avatar The user's avatar
     */
    public User(String userName, String firstName, String lastName,
            String phoneNumber, String address, String avatar ) {
        this.USER_NAME = userName;
        this.FIRST_NAME = firstName;
        this.LAST_NAME = lastName;
        this.PHONE_NUMBER = phoneNumber;
        this.ADDRESS = address;
        this.avatar = avatar;
        this.favoriteUsers = new ArrayList<>();
        this.biddingHistory = new BiddingHistory();
        
    }
        /**
     * 
     * User Class constructor (Without avatar)
     * @param userName The user's username
     * @param firstName The user's First name
     * @param lastName The user's Last name
     * @param phoneNumber The user's Phone Number
     * @param address  The user's Address
     */
        public User(String userName, String firstName, String lastName,
            String phoneNumber, String address) {
        this.USER_NAME = userName;
        this.FIRST_NAME = firstName;
        this.LAST_NAME = lastName;
        this.PHONE_NUMBER = phoneNumber;
        this.ADDRESS = address;
        this.avatar = "images/User_Avatar.png"; // default avatar
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
        return USER_NAME;
    }
    /**
     *  Get this user's FirstName
     * @return  The First Name
     */
    public String getFirstName() {
        return FIRST_NAME;
    }
    /**
     *  Get this user's Last Name
     * @return  The Last Name
     */
    public String getLastName() {
        return LAST_NAME;
    }
    /**
     *  Get this user's PhoneNumber
     * @return The user's PhoneNumber
     */
    public String getPhoneNumber() {
        return PHONE_NUMBER;
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
        return ADDRESS;
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
    /** 
     * To String method
     * @return This Object as a String
     */
    @Override
    public String toString(){
        return "UserName:-" + USER_NAME + "\n" + "First Name:-" + FIRST_NAME +
                "\n"  + "Last Name:-" + LAST_NAME + "\n" + "Phone Number:-" + 
                PHONE_NUMBER + "\n" + "Address:-" + ADDRESS + "\n" + 
                "Image:-" + avatar;
    }
}

