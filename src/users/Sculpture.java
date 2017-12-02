package users;

/**
 * @author Sam Huxtable
 */

public class Sculpture extends Artwork {

    private double depth;
    private String material;
    private String[] adPhotos;

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
     * @param depth
     * @param material
     * @param adPhotos
     */
    public Sculpture(String seller, String title, String description, String photo, String nameOfCreator, int yearMade, double reservePrive, double currentPrice,
                     int bidsAllowed, String timeEntered, double height, double width, double depth, String material, String[] adPhotos) {
        super(seller, title, description, photo, nameOfCreator, yearMade, reservePrive, currentPrice, bidsAllowed, timeEntered, height, width);
        this.depth = depth;
        this.material = material;
        this.adPhotos = adPhotos;
    }

    /**
     *
     * @return depth
     */
    public double getDepth() {
        return depth;
    }

    /**
     *
     * @return material piece is made from
     */
    public String getMaterial() {
        return material;
    }

    /**
     *
     * @return additional photos
     */
    public String[] getAdPhotos() {
        return adPhotos;
    }

}
