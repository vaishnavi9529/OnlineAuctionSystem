/ Sample auction items (replace with dynamic data from backend in real application)
const auctionItems = [
    {
        name: "Laptop",
        description: "A high-end gaming laptop with the latest specs.",
        startingPrice: 500.00,
        currentBid: 500.00,
        highestBidder: "None"
    },
    {
        name: "Smartphone",
        description: "Latest model smartphone with cutting-edge features.",
        startingPrice: 300.00,
        currentBid: 300.00,
        highestBidder: "None"
    }
];

// Function to display auction items
function displayAuctionItems() {
    const auctionItemsList = document.getElementById("auction-items-list");
    auctionItemsList.innerHTML = ""; // Clear previous items

    auctionItems.forEach(item => {
        const itemElement = document.createElement("div");
        itemElement.classList.add("item");
        itemElement.innerHTML = `
            <h3>${item.name}</h3>
            <p>${item.description}</p>
            <p>Starting Price: $${item.startingPrice}</p>
            <p>Current Bid: $${item.currentBid} (Highest Bidder: ${item.highestBidder})</p>
        `;
        auctionItemsList.appendChild(itemElement);
    });
}

// Function to handle bid submission
function handleBidSubmit(event) {
    event.preventDefault(); // Prevent form submission

    const itemName = document.getElementById("item-name").value;
    const bidAmount = parseFloat(document.getElementById("bid-amount").value);
    const bidderUsername = document.getElementById("bidder-username").value;

    let itemFound = false;
    let bidPlaced = false;

    // Find the auction item by name
    auctionItems.forEach(item => {
        if (item.name.toLowerCase() === itemName.toLowerCase()) {
            itemFound = true;
            if (bidAmount > item.currentBid) {
                // Place the bid if valid
                item.currentBid = bidAmount;
                item.highestBidder = bidderUsername;
                bidPlaced = true;
            }
        }
    });

    if (itemFound) {
        if (bidPlaced) {
            alert("Bid placed successfully!");
        } else {
            alert("Bid must be higher than the current bid!");
        }
    } else {
        alert("Item not found!");
    }

    // Update the auction items display
    displayAuctionItems();
}

// Add event listener to bid form
document.getElementById("bid-form").addEventListener("submit", handleBidSubmit);

// Display auction items initially
displayAuctionItems();