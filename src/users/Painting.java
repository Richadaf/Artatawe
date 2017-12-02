package users;

/**
 * @author Sam Huxtable
 */

public class Painting extends Artwork {
    /**
     *
     * @param seller
     * @param title
     * @param description
     * @param photo
     * @param nameOfCreator
     * @param yearMade
     * @param reservePrive
     * @param currentPrice
     * @param bidsAllowed
     * @param timeEntered
     * @param height
     * @param width
     */
    public Painting(String seller, String title, String description, String photo, String nameOfCreator, int yearMade, double reservePrive,
                    double currentPrice, int bidsAllowed, String timeEntered, double height, double width) {
        super(seller, title, description, photo, nameOfCreator, yearMade, reservePrive, currentPrice, bidsAllowed, timeEntered, height, width);
    }



}
