
package SystemInterface;

import Aggregator.*;
import Commands.Invoker;
import java.util.ArrayList;

/**
 *
 * @author dierbach
 */
public class SystemInterface {
    private Invoker inv;
    
    public SystemInterface(Invoker inv) {
        this.inv = inv;
    }
    
    public String[] getMenu() {
        Menu menu = Invoker.getMenu();

        ArrayList<String> displayLines = new ArrayList<>();

        menu.reset();
        while (menu.hasNext()) {
            displayLines.add(menu.getNextItem().toString());
        }

        // convert ArrayList<String> to array of Strings
        return (String[]) displayLines.toArray();
    }

    public String[] submitOrders() {
        Orders order = Invoker.submitOrder();

        ArrayList<String> displayOrder = new ArrayList<>();

        order.reset();
        while (order.hasNext()) {
            displayOrder.add(order.getNextOrder().toString());
        }

        return (String[]) displayOrder.toArray();
    }
}
