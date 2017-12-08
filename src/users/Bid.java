package users;
/**
 * This class represents values of a Bid.
 * @author Corey Kopotsha
 * @version 1.8
 */
public class Bid {
	private double newBid;
	private double oldBid;
	private int bidsLeft;
	private String bidTime;
	private String bidderName;
	private String sellerName;
	private String artworkName;
	private boolean wonBid;
	/**
	 * Initialises a new Bid.
	 * 
	 * @param newBid The price the user is submitting as a new bid.
	 * @param oldBid The last bid price that a previous user has set or the reserve price.
	 * @param bidsLeft The amount of bids left on the Artwork after the bid has been placed.
	 * @param bidderName The name of the user that is placing the bid.
	 * @param sellerName The name of the user that is auctioning the Artwork.
	 * @param artworkName The name of the Artwork that the bid is being placed on.
	 * @param bidTime The time the bid is being placed.
	 */
	public Bid(double newBid, double oldBid, int bidsLeft, String bidderName,
			String sellerName, String artworkName, String bidTime) {
		this.setNewBid(newBid);
		this.bidsLeft = bidsLeft;
		this.setBidderName(bidderName);
		this.setSellerName(sellerName);
		this.setArtworkName(artworkName);
		this.oldBid = oldBid;
		this.setBidTime(bidTime);
	}
	
	/**
	 * Get the last bid price or reserve price that has been set.
	 * @return The last bid price or reserve price.
	 */
	public double getOldBid() {
		return oldBid;
	}
	/**
	 * Get the amount of bids that are left for the auction
	 * @return The amount of bids left for the auction.
	 */
	public int getBidsLeft() {
		return bidsLeft;
	}
	/**
	 * Get the amount of bids that are left for the auction
	 * @return The amount of bids left for the auction.
	 */
	public void setBidsLeft(int bidsLeft) {
		this.bidsLeft = bidsLeft;
	}

	public double getNewBid() {
		return newBid;
	}

	public void setNewBid(double newBid) {
		this.newBid = newBid;
	}

	public String getBidTime() {
		return bidTime;
	}

	public void setBidTime(String bidTime) {
		this.bidTime = bidTime;
	}

	public String getBidderName() {
		return bidderName;
	}

	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getArtworkName() {
		return artworkName;
	}

	public void setArtworkName(String artworkName) {
		this.artworkName = artworkName;
	}

	public boolean isWonBid() {
		return wonBid;
	}

	public void setWonBid(boolean wonBid) {
		this.wonBid = wonBid;
	}
}
