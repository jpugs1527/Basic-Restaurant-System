
package Commands;

import Aggregator.*;

/**
 *
 * @author dierbach
 */
public class Invoker {
    private static Aggregator agg;
    
    public Invoker(Aggregator agg) {
        this.agg = agg;
    }

    public static Menu getMenu() {
        return (Menu) new CMDGetMenu(agg).execute();
    }

    public static Orders submitOrder() {
        return (Orders) new CMDSubmitOrders(agg).execute();
    }

}
