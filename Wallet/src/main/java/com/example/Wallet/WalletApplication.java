package com.example.Wallet;

import com.example.Wallet.Service.WalletService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class WalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletApplication.class, args);

		WalletService service = new WalletService();
		Scanner sc = new Scanner(System.in);

		while (true) {
			printMenu();
			int choice = getUserChoice(sc); // Fixed: Using `nextLine()` to read integers safely

			switch (choice) {
				case 1:
					createWallet(service, sc);
					break;
				case 2:
					transferAmount(service, sc);
					break;
				case 3:
					printAccountStatement(service, sc);
					break;
				case 4:
					printOverview(service);
					break;
				case 5:
					topUpWallet(service, sc);
					break;
				case 6:
					System.out.println("Exiting the application.");
					sc.close();
					return;
				default:
					System.out.println("Invalid option, please try again.");
			}
		}
	}

	private static void printMenu() {
		System.out.println("\nOptions");
		System.out.println("1. Create wallet");
		System.out.println("2. Transfer Amount");
		System.out.println("3. Account Statement");
		System.out.println("4. Overview");
		System.out.println("5. TopUp");
		System.out.println("6. Exit");
		System.out.print("Enter your choice: ");
	}

	private static int getUserChoice(Scanner sc) {
		while (true) {
			try {
				String input = sc.nextLine().trim(); // Read full line (fixes skipping issue)
				return Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("Invalid input! Please enter a number between 1 and 6.");
			}
		}
	}

	private static void createWallet(WalletService service, Scanner sc) {
		System.out.println("\nCreating Wallet");
		System.out.print("Enter Name: ");
		String name = sc.nextLine().trim();
		System.out.print("Enter Number: ");
		String number = sc.nextLine().trim();
		service.createWallet(name, number);
		System.out.println("Wallet created successfully!");
	}

	private static void transferAmount(WalletService service, Scanner sc) {
		System.out.println("\nTransfer Money Initiated");
		System.out.print("Enter account number of sender: ");
		String senderAccountNumber = sc.nextLine().trim();
		System.out.print("Enter account number of receiver: ");
		String receiverAccountNumber = sc.nextLine().trim();
		BigDecimal amount = getValidBigDecimal(sc, "Enter Amount: ");
		service.transfer(senderAccountNumber, receiverAccountNumber, amount);
		System.out.println("Transfer successful!");
	}

	private static void printAccountStatement(WalletService service, Scanner sc) {
		System.out.print("\nEnter account number for statement: ");
		String accountNumber = sc.nextLine().trim();
		service.accountStatement(accountNumber);
	}

	private static void printOverview(WalletService service) {
		System.out.println("\nPrinting all statements:");
		service.overview();
	}

	private static void topUpWallet(WalletService service, Scanner sc) {
		System.out.print("\nEnter your account number: ");
		String topUpAccountNumber = sc.nextLine().trim();
		BigDecimal topUpAmount = getValidBigDecimal(sc, "Enter your top-up amount: ");
		service.topUp(topUpAccountNumber, topUpAmount);
		System.out.println("Top-up successful!");
	}

	private static BigDecimal getValidBigDecimal(Scanner sc, String message) {
		while (true) {
			try {
				System.out.print(message);
				String input = sc.nextLine().trim();
				return new BigDecimal(input);
			} catch (NumberFormatException e) {
				System.out.println("Invalid amount! Please enter a valid number.");
			}
		}
	}
}
