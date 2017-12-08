package users;

/**
 * The Browsing class is responsible for holding all the necessary behaviours
 * needed for the right functionality of the Browsing GUI.
 * @author Siddhartha Gurung (912318)
 */

public class Browsing {
    private User currentUser;

    public Browsing() {}

    /**
     * Marks a seller as a favourite for the logged in user
     * @param favUser The seller which the user wants to favourite
     * @return {@code true} if the seller has been successfully added as a
     *        'favourite';
     *        {@code false} otherwise
     */
    public boolean markFavorite(User favUser) {
        for (int i=0; i < currentUser.getFavoriteUsers().size(); i++) {
            if (currentUser.getFavoriteUsers().get(i).getUserName().equals(favUser.getUserName())) {
              return false;
            }
        }
        currentUser.addFavoriteUser(favUser);
        return true;
    }
}
