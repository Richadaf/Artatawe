// to-do delete artwork from browsing if won, how to get exact artwork thats on GUI,
// make sure bid is a number and not alphabet (might be done in another class).
/**
 * This class uses the class Bid to place a Bid on an artwork.
 * @author Corey Kopotsha
 * @version 1.8
 */
import javax.swing.JOptionPane;

public class PlaceBid {
	private double newBid;
	private Bid bidObject;
	private Artwork artworkObject;
	private User userObject;
	private Time timeObject;
	private BiddingHistory bidHistoryObject;
	
	/**
	 * Initialises PlaceBid with the bid the user wants to place on the Artwork.
	 * Creates the bid, checks whether the bid's price is valid and if it is then 
	 * run successfulBid method. Then clears the bid.
	 * @param newBid The bid the user wants to place on the Artwork.
	 */
	public PlaceBid(double newBid) {
		this.newBid = newBid;
		bidObject = createBid(newBid);
		if (priceValid(bidObject.getOldBid())) {
			successfulBid(bidObject.getBidsLeft());
		}
		bidObject = null;
	}
	/**
	 * Creates a new bid with the bid the user wants to place on the Artwork
	 * @param newBid The bid the user wants to place on the Artwork
	 * @return The newly created bid.
	 */
	public Bid createBid(double newBid) {
		return new Bid(newBid, artworkObject.getCurrentPrice(), artworkObject.getBidsLeft(),
				userObject.getUserName(), artworkObject.getSeller(), artworkObject.getTitle(),
				timeObject.getTime());
	}
	/**
	 * Checks whether the bid the user has placed is valid.
	 * @param oldBid The last bid placed or the reserve price of the Artwork.
	 * @return {@code false} If the new bid is less than or equal to the old bid price/ reserve price.
	 * 		   {@code true} Otherwise 		   
	 */
	public boolean priceValid(double oldBid) {
		if (newBid <= oldBid) {
			JOptionPane
					.showMessageDialog(
							null,
							"Bid is too low.\nYou Can Only Bid Higher\nThan The Reserve Price\nOr The Last Bid",
							"Bid", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return true;
	}
	/**
	 * Changes the bids left to -1 of the original value.
	 * Sets the new bids left value to the bids left in Artwork and Bid.
	 * Set the new current price of the Artwork as the newly placed Bid.
	 * Add this bid to the user's Bidding History.
	 * Displays message that bid was successfully placed.
	 * @param bidsLeft The amount of bids that are left before the current user's bid has been placed.	   
	 */
	public void successfulBid(int bidsLeft){
		int newBidsLeft = bidsLeft - 1;
		artworkObject.setBidsLeft(newBidsLeft);
		bidObject.setBidsLeft(newBidsLeft);
		artworkObject.setCurrentPrice(newBid);
		bidHistoryObject.addUserBid(bidObject);	
		
		if (newBidsLeft == 0){
			bidObject.setWonBid(true);
			wonAuction();
		}else {
			JOptionPane.showMessageDialog(null, "Bid Successfully Placed.",
					"Bid", JOptionPane.INFORMATION_MESSAGE);
			bidObject.setWonBid(false);
		}
	}
	/**
	 * Only ran if the bid placed by the user was the last bid and successful.
	 * Displays message that the user has won the auction.
	 * Adds the bid to the Won Artworks and Completed Auctions in the Bidding History.
	 */
	public void wonAuction() {
		
		JOptionPane.showMessageDialog(null,
					"Congratulations, You've Won The Auction", "Bid",
					JOptionPane.INFORMATION_MESSAGE);
			bidHistoryObject.addWonArtworks(bidObject);
			bidHistoryObject.addCompletedAuctions(bidObject);

	}

}
