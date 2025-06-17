
package com.auction;

public class AuctionItem {
    private String itemName;
    private String description;
    private double startingPrice;
    private double currentBid;
    private String highestBidder;

    public AuctionItem(String itemName, String description, double startingPrice) {
        this.itemName = itemName;
        this.description = description;
        this.startingPrice = startingPrice;
        this.currentBid = startingPrice;
        this.highestBidder = "None";
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public String getHighestBidder() {
        return highestBidder;
    }

    public boolean placeBid(double bidAmount, String bidderUsername) {
        if (bidAmount > currentBid) {
            currentBid = bidAmount;
            highestBidder = bidderUsername;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "AuctionItem{" +
                "itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", startingPrice=" + startingPrice +
                ", currentBid=" + currentBid +
                ", highestBidder='" + highestBidder + '\'' +
                '}';
    }
}