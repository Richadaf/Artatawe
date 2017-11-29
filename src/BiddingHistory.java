import java.util.ArrayList;

public class BiddingHistory {
	
	ArrayList<Bid> userBids;
	ArrayList<Bid> wonArtworks;
	ArrayList<Bid> completedAuction;
	
	public BiddingHistory() {
		userBids = new ArrayList<Bid>();
		wonArtworks= new ArrayList<Bid>();
		completedAuction= new ArrayList<Bid>();
		
	}
	public BiddingHistory(ArrayList<Bid> userBids, ArrayList<Bid> wonArtworks,ArrayList<Bid> completedAuction){
		userBids = new ArrayList<Bid>();
		wonArtworks= new ArrayList<Bid>();
		completedAuction= new ArrayList<Bid>();
		
		this.userBids = userBids;
		this.wonArtworks = wonArtworks;
		this.completedAuction = completedAuction;
	}
	public boolean addUserBid(Bid bid){
		return userBids.add(bid);
	}
	public ArrayList<Bid> getUserBids() {
		return userBids;
	}

	public boolean addWonArtworks(Bid bid) {
		return wonArtworks.add(bid);
	}
	public ArrayList<Bid> getWonArtworks() {
		return wonArtworks;
	}
	public boolean addCompletedAuctions(Bid bid){
		return completedAuction.add(bid);
	}
	public ArrayList<Bid> getCompletedAuction() {
		return completedAuction;
	}
}
