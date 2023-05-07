import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
 public static void main(String[] args) {
 BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
 String inputLine = "";

 VendingMachine v = new VendingMachine();
 // Adds products to the vending machine
 v.addProduct(new Product("Cocacola", 4, 1)); // Price: $4, Quantity: 1
 v.addProduct(new Product("Pepsi", 5, 3)); // Price: $5, Quantity: 3
 System.out.println("Welcome to COMP2396 Assignment 2 - Vending Machine");
 // Reads user inputs continuously
 while (true) {
 try {
 inputLine = input.readLine();
 } catch (IOException e) {
 System.out.print("Input Error!");
 e.printStackTrace();
 }
 // Split the input line
 String[] cmdParts = inputLine.split(" ");
 if (cmdParts[0].equalsIgnoreCase("Exit")) {
 break;
 } else if (cmdParts[0].equalsIgnoreCase("Insert")) {
 System.out.println(((Command) new CmdInsertCoin()).execute(v, cmdParts[1]));
 } else if (cmdParts[0].equalsIgnoreCase("Reject")) {
 System.out.println(((Command) new CmdRejectCoins()).execute(v, ""));
 } else if (cmdParts[0].equalsIgnoreCase("Buy")) {
 System.out.println(((Command) new CmdPurchase()).execute(v, cmdParts[1]));
 } else {
 System.out.println("Unknown input.");
 }
 inputLine = "";
 }
 System.out.println("Bye");
 }
} 