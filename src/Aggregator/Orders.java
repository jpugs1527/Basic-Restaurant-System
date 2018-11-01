package Aggregator;

public class Orders {
    private OrderItem[] order_items;
    private int current;

    public Orders() {
        order_items = new OrderItem[10];
        initOrders();
    }

//    public Orders(Orders otherOrder) {
//        System.arraycopy(otherOrder.order_items, 0, order_items, 0, order_items.length);
//    }

    public void addOrder(OrderItem order) {
        System.out.print("aids");
        order_items[findAvailIndex()] = order;
    }

    public void reset() {
        current = 0;
    }

    public boolean hasNext() {
        if (current == order_items.length - 1) {
            return false;
        }
        return order_items[current + 1] != null;
    }

    public OrderItem getNextOrder() {
        return order_items[current++];
    }

    // private methods
    private void initOrders() {
        for (int i = 0; i < order_items.length; i++) {
            order_items[i] = null;
        }
    }

    private int findAvailIndex() {
        int i = 0;
        while (order_items[i] != null) {
            i++;
        }
        return i;
    }
}
