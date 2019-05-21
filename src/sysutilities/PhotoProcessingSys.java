package sysutilities;

import javax.swing.JOptionPane;

public class PhotoProcessingSys {
	private String customerName;
	private Address customerAddress;
	private double balance;
	private static final double BASIC_COST = 1.0;
	private StringBuffer transactions;
	private int transactionsCount;
	
	public PhotoProcessingSys(String customerName, String customerStreet,
						      String customerCity, String customerState, String customerZipcode) {
		this.customerName = customerName;
		try {
			customerAddress = new Address(customerStreet, customerCity, customerState, customerZipcode);
		} catch(IllegalArgumentException e) {
			customerAddress = new Address();
		}
		balance = 0;
		transactions = new StringBuffer();
		transactions.append("Image Transactions\n");
		transactionsCount = 0;
	}
	
	public PhotoProcessingSys() {
		this.customerName = "NONAME";
		this.customerAddress = new Address();
		balance = 0;
	}

	public String toString() {
		String answer = "Customer Name: " + customerName + "\n";
		
		answer += "Customer Address: " + customerAddress + "\n";
		answer += "Balance: " + balance + "\n";
		
		return answer;
	}

	public String imageTransaction(String imageName, String task, String taskOptions, boolean graphicalMode) {
		String message = null;
		
		if (graphicalMode) {
			PictureManager.graphicalModeOn();
		} else {
			PictureManager.graphicalModeOff();
		}
		
		task = task.toLowerCase();
	
		balance += BASIC_COST;
		
		switch(task) {
			case "display":
				message = PictureManager.displayPicture(imageName);
				break;
			case "clear":
				message = PictureManager.clearScreen();
				break;
			case "displaylast":
				message = PictureManager.displayLastPicture();
				break;
			case "blackandwhite":
				message = PictureManager.displayPictureBlackWhitePosterize(imageName, true, false);
				break;
			case "posterize":
				message = PictureManager.displayPictureBlackWhitePosterize(imageName, false, true);
				break;
			case "blackandwhiteposterize":
				message = PictureManager.displayPictureBlackWhitePosterize(imageName, true, true);
				break;
			case "selectcolors":
				/* this one uses taskOptions and costs twice */
				balance += BASIC_COST;
				
				/* Parsing colors */
				boolean red = false, green = false, blue = false;

				if (taskOptions != null) {
					for (int idx = 0; idx < taskOptions.length(); idx++) {
						if (taskOptions.charAt(idx) == 'r' || taskOptions.charAt(idx) == 'R') {
							red = true;
						}
						if (taskOptions.charAt(idx) == 'g' || taskOptions.charAt(idx) == 'G') {
							green = true;
						}
						if (taskOptions.charAt(idx) == 'b' || taskOptions.charAt(idx) == 'B') {
							blue = true;
						}
					}
				}
				message = PictureManager.displayPictureSelectRedGreenBlue(imageName, red, green, blue);
				break;
			default:
				balance -= BASIC_COST;  /* There is no cost associated with invalid transaction */
				message = "Invalid photoProcessing option";
				break;
		}
		
		if (graphicalMode) {
			JOptionPane.showMessageDialog(null, "Continue");
		}
		
		addTransaction(message);
		
		return message;
	}
	
	public String getTransactions() {
		return transactions.toString();
	}
	
	public double getBalance() {
		return balance;
	}
	
	private void addTransaction(String message) {
		transactions.append("Transaction #" + ++transactionsCount + ": " + message);
	}
}
