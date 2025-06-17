
package com.auction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an Auction System
        Auction auction = new Auction();

        // Create Users
        User seller = new User("JohnDoe", "Seller");
        User bidder1 = new User("Alice", "Bidder");
        User bidder2 = new User("Bob", "Bidder");

        // Add auction items
        AuctionItem item1 = new AuctionItem("Laptop", "Brand new laptop", 500);
        AuctionItem item2 = new AuctionItem("Smartphone", "Latest model smartphone", 300);

        auction.addItem(item1);
        auction.addItem(item2);

        // Main interaction loop
        while (true) {
            System.out.println("\n--- Auction System ---");
            System.out.println("1. Display Auction Items");
            System.out.println("2. Place a Bid");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    auction.displayItems();
                    break;
                case 2:
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter bid amount: ");
                    double bidAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter bidder username: ");
                    String bidderUsername = scanner.nextLine();
                    auction.placeBid(itemName, bidAmount, bidderUsername);
                    break;
                case 3:
                    System.out.println("Exiting Auction System.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}