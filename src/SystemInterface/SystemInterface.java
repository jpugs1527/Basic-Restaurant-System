package SystemInterface;

import Aggregator.*;
import Commands.Invoker;
import java.util.ArrayList;

public class SystemInterface {
    private Invoker inv;
    
    public SystemInterface(Invoker inv) {
        this.inv = inv;
    }
    
    public String[] getMenu() {
        Menu menu = Invoker.getMenu();
        String[] menuArr = new String[2];
        ArrayList<String> displayLines = new ArrayList<>();

        menu.reset();
        while (menu.hasNext()) {
            displayLines.add(menu.getNextItem().toString());
        }

        // convert ArrayList<String> to array of Strings
        menuArr = displayLines.toArray(menuArr);
        return menuArr;
    }

    public String[] submitOrders() {
        Orders order = Invoker.submitOrder();
        String[] orderArr = new String[2];
        ArrayList<String> displayOrder = new ArrayList<>();

        order.reset();
        while (order.hasNext()) {
            displayOrder.add(order.getNextOrder().toString());
        }
        
        orderArr = displayOrder.toArray(orderArr);
        return orderArr;
    }
}
