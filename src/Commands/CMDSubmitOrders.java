
package Commands;

import Aggregator.*;

/**
 *
 * @author dierbach
 */
public class CMDSubmitOrders {
    
    private Aggregator agg;
    
    public CMDSubmitOrders(Aggregator agg){
        this.agg = agg;
    }
    
    public Object execute(){
//    return new Orders(agg.submitOrders()); // if copy constructor implemented
    // or
     return agg.submitOrders(); // if clone method implemented 
    }
    
}
