package users;

import java.util.ArrayList;

/**
 * @author Sam Huxtable
 */

public class Sculpture extends Artwork {

    private double depth;
    private String material;
    private ArrayList<String> adPhotos = new ArrayList();

    /**
     * Constructs and instance of sculpture
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
                     int bidsAllowed, String timeEntered, double height, double width, double depth, String material, ArrayList adPhotos) {
        super(seller, title, description, photo, nameOfCreator, yearMade, reservePrive, currentPrice, bidsAllowed, timeEntered, height, width);
        this.depth = depth;
        this.material = material;
        this.adPhotos = adPhotos;
    }

    /**
     * Gets the depth
     * @return depth
     */
    public double getDepth() {
        return depth;
    }

    /**
     * Gets material the sculpture is amde from
     * @return material
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Gets additional photos
     * @return aadPhotos
     */
    public ArrayList<String> getAdPhotos() {
        return adPhotos;
    }

    /**
     * Overrides toString()
     * @return Artwork as a string
     */
    @Override
    public String toString() {
        String photos = "";
        for(int i = 0; i < adPhotos.size(); i ++) {
            photos = photos + "Photo:-" + adPhotos.get(i) + "\n";
        }
        return super.toString() + "\n" +
                "Depth:-"+ depth + "\n" +
                "Material:-"+ material + "\n" +
                photos;

    }

}
