/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @Akhil Patel
 */
import java.util.Scanner;

public class VendingMachine {

    private Product[] items;

    public VendingMachine() {
        items = new Product[5];
        items[0] = new Product("Chips", 20.0, 20);
        items[1] = new Product("Pepsi", 40.0, 10);
        items[2] = new Product("Mazza", 40.0, 10);
        items[3] = new Product("Bingo", 40.0, 10);
        items[4] = new Product("Dairy Milk", 20.0, 20);
    }

    public void displayInventory() {
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i].getName());
            System.out.print('\t');
            System.out.print(items[i].getQty());
            System.out.println();
        }
    }

    public void Productdispenser(int itemCode) {
        Scanner in = new Scanner(System.in);
        if (items[itemCode].getQty() <= 0) {
            System.out.println("Oops!.., out of stock"); // Check for stock
        } else {

            System.out.println("MRP: " + items[itemCode].getPrice()); // Prints MRP
            System.out.print("Insert the coin: "); // Insert coin
            double amt = in.nextDouble();
            if (amt < items[itemCode].getPrice()) {
                System.out.println("Insufficient money paid, can't dispense "
                        + items[itemCode].getName());
                System.out.println("Refunding " + amt);
            } else {
                System.out.println("Dispensing one " + items[itemCode].getName());
                double changeAmt = amt - items[itemCode].getPrice();
                if (changeAmt > 0) {
                    System.out.println("Here is your change amount of " + changeAmt);
                }
                items[itemCode].reduceQty();
            }
        }
    }

    Product[] getItems() {
        return items;
    }

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        VendingMachine v = new VendingMachine();
        Product[] Vending_Items = v.getItems();

        System.out.println("Vending Machine Menu");
        for (int i = 0; i < Vending_Items.length; i++) {
            System.out.println("Enter " + (i + 1) + " for " + Vending_Items[i].getName()); // Display Product List with the MRP
        }

        System.out.println("Enter 6 to stop the Vending Machine");

        int option;
        do {
            System.out.print("Enter your option: ");
            option = in.nextInt();

            if (option < 1 || option > 6) {
                System.out.println("Incorrect...!! Please choose another option");
            } else if (option == 6) {
                System.out.println("Stopping Vending Machine...Thank you");
            } else {
                v.Productdispenser(option - 1);
            }
        } while (option != 6);

    }
}

class Product {

    private String name;
    private double price;
    private int qty;

    public Product(String itemName, double itemPrice, int itemQty) {
        name = itemName;
        price = itemPrice;
        qty = itemQty;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void reduceQty() {
        if (qty > 0) {
            qty -= 1;
        }
    }
}
