
package Aggregator;

/**
 *
 * @author dierbach
 */
public class Aggregator {

    private Menu menu;
    private Orders orders;

    public Aggregator() {
        menu = new Menu();
        populateMenu();
        
        orders = new Orders();
    }

    public Menu getMenu() {
        return menu;
    }

    public Orders submitOrders() {
        return orders;
    }

    // --- private methods

    public void populateMenu() {
        menu.addItem(new MenuItem(1, "Roast Beef", 12.50));
        menu.addItem(new MenuItem(2, "Turkey Dinner", 9.50));
        // etc.
    }

}
