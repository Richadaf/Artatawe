package gui;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import users.Bid;

import java.util.ArrayList;

/**
 * BiddingHistory is responsible for handling all the operations involving the user Bidding History for each user
 * 
 * @author Richard Famoroti
 *
 */
public class BiddingHistory {
	
	ArrayList<Bid> userBids;
	ArrayList<Bid> wonArtworks;
	ArrayList<Bid> completedAuction;
	
	/**
	 * Initializes Bidding history
	 */
	public BiddingHistory() {
		userBids = new ArrayList<Bid>();
		wonArtworks= new ArrayList<Bid>();
		completedAuction= new ArrayList<Bid>();
		
	}
	
	/**
	 * Initializes Bidding History with specified bids
	 * @param userBids Bids user has currently running
	 * @param wonArtworks Bids user has won 
	 * @param completedAuction Bids user has made, and did not win
	 */
	public BiddingHistory(ArrayList<Bid> userBids, ArrayList<Bid> wonArtworks,ArrayList<Bid> completedAuction){
		userBids = new ArrayList<Bid>();
		wonArtworks= new ArrayList<Bid>();
		completedAuction= new ArrayList<Bid>();
		
		this.userBids = userBids;
		this.wonArtworks = wonArtworks;
		this.completedAuction = completedAuction;
	}
	
	/**
	 * Adds Bid to user's current bid
	 * @param bid user's bid
	 * @return {@code true} if it was added successfully;
	 * 		   {@code false} otherwise
	 */
	public boolean addUserBid(Bid bid){
		return userBids.add(bid);
	}
	/**
	 * Returns all current bids made by user
	 * @return current bids made by user 
	 */
	public ArrayList<Bid> getUserBids() {
		return userBids;
	}

	/**
	 * Adds bid to user's won artwork
	 * @param bid user's bid
	 * @return {@code true} if it was added successfully;
	 * 		   {@code false} otherwise
	 */
	public boolean addWonArtworks(Bid bid) {
		return wonArtworks.add(bid);
	}
	/**
	 * Returns all bids won by user
	 * @return bids won by user 
	 */
	public ArrayList<Bid> getWonArtworks() {
		return wonArtworks;
	}
	/**
	 * Adds bid to user's completed artwork
	 * @param bid user's bid
	 * @return {@code true} if it was added successfully;
	 * 		   {@code false} otherwise
	 */
	public boolean addCompletedAuctions(Bid bid){
		return completedAuction.add(bid);
	}
	
	/**
	 * Returns all bids completed by user, but not necessarily won. 
	 * @return bids completed by user 
	 */
	public ArrayList<Bid> getCompletedAuction() {
		return completedAuction;
	}

	public void backToProfile(ActionEvent event) {
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		try{
			Parent userProfile = FXMLLoader.load(getClass().getResource("UserProfile.fxml"));
			window.setScene(new Scene(userProfile,600,400));
		}catch(Exception f){
			f.printStackTrace();
		}
	}
}
