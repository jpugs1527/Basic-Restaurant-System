/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicrestaurantsystem;

import java.util.Scanner;
import SystemInterface.SystemInterface;
import Commands.Invoker;
import Aggregator.*;

/**
 *
 * @author dierbach
 */
public class BasicRestaurantSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Aggregator agg = new Aggregator();
        agg.populateMenu();
        Invoker invoker = new Invoker(agg);
        SystemInterface si = new SystemInterface(invoker);
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        int option;

        while (loop) {
            displayMenu();
            System.out.print("Please choose an option: ");
            option = scan.nextInt();

            switch (option) {
            case 0:
                System.err.println("Quitting...");
                loop = false;
                break;
            case 1:
                si.getMenu();
                break;

            case 2:
                si.submitOrders();
                break;

            case 3:
                // si.displayTab();
                break;

            default:
                System.err.println("Invalid Option");
                loop = false;
            }
        }
    }

    public static void displayMenu() {
        System.out.println("1. Display Menu");
        System.out.println("2. Submit Order");
        System.out.println("3. Display Tab");
    }

    public static void populate(Menu menu) {
        menu.addItem(new MenuItem(1, "Food", 10));
    }
}
