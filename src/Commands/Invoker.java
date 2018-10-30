
package Commands;

import Aggregator.*;

/**
 *
 * @author dierbach
 */
public class Invoker {
    private static Aggregator agg = new Aggregator();

    public static Menu getMenu() {
        return (Menu) new CMDGetMenu(agg).execute();
    }

    public static Orders getOrders() {
        return (Orders) new CMDGETORDERS(agg).execute();
    }

}
