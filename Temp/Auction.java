
package com.auction;

import java.util.ArrayList;
import java.util.List;

public class Auction {
    private List<AuctionItem> items;

    public Auction() {
        items = new ArrayList<>();
    }

    public void addItem(AuctionItem item) {
        items.add(item);
    }

    public void displayItems() {
        System.out.println("\nAvailable Auction Items:");
        for (AuctionItem item : items) {
            System.out.println(item);
        }
    }

    public void placeBid(String itemName, double bidAmount, String bidderUsername) {
        for (AuctionItem item : items) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                if (item.placeBid(bidAmount, bidderUsername)) {
                    System.out.println("Bid placed successfully!");
                } else {
                    System.out.println("Bid must be higher than the current bid!");
                }
                return;
            }
        }
        System.out.println("Item not found!");
    }
}