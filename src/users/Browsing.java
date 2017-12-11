package users;

import gui.SystemController;

/**
 * The Browsing class is responsible for holding all the necessary behaviours
 * needed for the right functionality of the Browsing GUI.
 * @author Siddhartha Gurung (912318)
 */

public class Browsing {

    /**
     * Marks a seller as a favourite for the logged in user
     * @param favUser The seller which the user wants to favourite
     * @return {@code true} if the seller has been successfully added as a
     *        'favourite';
     *        {@code false} otherwise
     */
    public boolean markFavorite(User favUser) {
        for (int i=0; i < SystemController.user.getFavoriteUsers().size(); i++) {
            if (SystemController.user.getFavoriteUsers().get(i).getUserName().equals(favUser.getUserName())) {
              return false;
            }
        }
        SystemController.user.addFavoriteUser(favUser);
        return true;
    }
}
