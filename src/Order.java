public class Order {
    private int orderId;
    private int totalPrice;
    private String deliveryTime;
    
    private static OrderLine OrderLine;
    private static OrderLine[] OrderLineArr;
    
    public Order(OrderLine OrderLine, int orderId, String deliveryTime){
        this.OrderLine = OrderLine;
        this.totalPrice = OrderLine.getItemPrice();
        this.orderId = orderId;
        this.deliveryTime = deliveryTime;
    }

    public Order(OrderLine[] OrderLineArr, int orderId, String deliveryTime){
        this.OrderLineArr = OrderLineArr;
        int tempPrice = 0;
        for (OrderLine OrderLine: OrderLineArr) {
            tempPrice += OrderLine.getItemPrice();
        }
        this.totalPrice = tempPrice;
        this.orderId = orderId;
        this.deliveryTime = deliveryTime;
    }

    public int getTotalPrice(){
        return this.totalPrice;
    }

}
