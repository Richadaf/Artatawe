package users;

/**
 * @author Sam Huxtable
 */

public class Artwork {


    private String seller;
    private String title;
    private String description;
    private String photo;
    private String nameOfCreator;
    private int yearMade;
    private double reservePrive;
    private double currentPrice;
    private int bidsAllowed;
    private int bidsLeft;
    private String timeEntered;
    private double height;
    private double width;

    /**
     * Constructs an Artowrk instance
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
    public Artwork(String seller, String title, String description, String photo, String nameOfCreator, int yearMade, double reservePrive,
                   double currentPrice, int bidsAllowed, String timeEntered, double height, double width) {
        this.seller = seller;
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.nameOfCreator = nameOfCreator;
        this.yearMade = yearMade;
        this.reservePrive = reservePrive;
        this.currentPrice = currentPrice;
        this.bidsAllowed = bidsAllowed;
        this.bidsLeft = bidsAllowed;

        this.timeEntered = timeEntered;
        this.height = height;
        this.width = width;
    }

    /**
     * Sets the current price
     * @param currentPrice
     */
    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    /**
     * Sets the number of bids left until the end of the auction
     * @param bidsLeft
     */
    public void setBidsLeft(int bidsLeft) {
        this.bidsLeft = bidsLeft;
    }

    /**
     * Gets seller
     * @return seller
     */
    public String getSeller() {
        return seller;
    }

    /**
     * Gets title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets photo
     * @return photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * Gtes name of creator
     * @return nameOfCreator
     */
    public String getNameOfCreator() {
        return nameOfCreator;
    }

    /**
     * Gets year it was made
     * @return yearMade
     */
    public int getYearMade() {
        return yearMade;
    }

    /**
     * Gets the reserve price
     * @return reservePrice
     */
    public double getReservePrive() {
        return reservePrive;
    }

    /**
     * Gets the current price
     * @return currentPrice
     */
    public double getCurrentPrice() {
        return currentPrice;
    }

    /**
     * Gets the number of bids allowed
     * @return bidsAllowed
     */
    public int getBidsAllowed() {
        return bidsAllowed;
    }

    /**
     * Gets the number of bids left
     * @return bidsLeft
     */
    public int getBidsLeft() {
        return bidsLeft;
    }

    /**
     *Gets the time the artwork was entered
     * @return timeEntered
     */
    public String getTimeEntered() {
        return timeEntered;
    }

    /**
     * Gets the height
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     *Gets the width
     * @return width
     */
    public double getWidth() {
        return width;
    }
}
