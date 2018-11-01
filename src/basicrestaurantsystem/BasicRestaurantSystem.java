package basicrestaurantsystem;

import java.util.Scanner;
import SystemInterface.SystemInterface;
import Commands.Invoker;
import Aggregator.*;

public class BasicRestaurantSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Aggregator agg = new Aggregator();
        populate(agg.getMenu());
        Invoker invoker = new Invoker(agg);
        SystemInterface si = new SystemInterface(invoker);
        Scanner scan = new Scanner(System.in);
        Integer[] orderNum = new Integer[10];
        int orderCount = 0;

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
                    String[] menu = si.getMenu();
                    for (String item : menu) {
                        System.out.println(item);
                    }
                    break;

                case 2:
                    String[] orderMenu = si.getMenu();
                    for (String item : orderMenu) {
                        System.out.println(item);
                    }
                    System.out.print("Please enter your order by item number (0 to submit): ");
                    int order = scan.nextInt();
                    if (order == 0) {
                        System.out.println("Order Submitted");
                        System.out.println();
                        si.submitOrders();
                    } else {
                        int i = 0;
                        while (order != 0) {
                            
                            orderCount++;
                            orderNum[i] = order;
                            order = scan.nextInt();
                            if (i == 10) {
                                System.err.println("Max order items reached...Submitting order.");
                                si.submitOrders();
                                break;
                            }
                            i++;
                        }
                        System.out.println("Order Submitted");
                        for (int j = 0; j < orderNum.length; j++){
                            System.out.println(orderNum[j]);
                        }
                        si.submitOrders();

                    }
                    break;

                case 3:
                    double tab = 0;

                    for (int i = 0; i < orderCount; i++) {
                        if (orderNum[i] == 1) {
                            tab += 12.5;
                        } else if (orderNum[i] == 2) {
                            tab += 9.5;
                        }
                    }
                    System.out.println("Your total is: $" + tab);
                    loop = false;
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
