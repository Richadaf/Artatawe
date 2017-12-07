/*
 *
 */
package users;

/**
 * This Class stores information about a user.
 * @author 869298
 */
public class User {
    // Josh: Could these be constants?
    private String userName;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
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
    }
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
     * Get this user's Address
     * @return The user's Address
     */
    public String getAddress() {
        return address;
    }
}
