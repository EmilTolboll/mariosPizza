import java.util.Arrays;

public class Order {
    private int orderNo;
    private int totalPrice;
    private String deliveryTime;
    private boolean isReady;
    private int[] listOfItems;
    
    private OrderLine OrderLine;
    private OrderLine[] OrderLineArr;
    
    public Order(OrderLine OrderLine, int orderNo, String deliveryTime, boolean isReady){
        this.OrderLine = OrderLine;
        this.totalPrice = OrderLine.getItemPrice();
        this.orderNo = orderNo;
        this.deliveryTime = deliveryTime;
        this.isReady = isReady;
    }

    public Order(OrderLine[] OrderLineArr, int orderNo, String deliveryTime, boolean isReady){
        this.OrderLineArr = OrderLineArr;
        this.listOfItems = new int[OrderLineArr.length];
        int tempPrice = 0;
        for (OrderLine OrderLine: OrderLineArr) {
            tempPrice += OrderLine.getItemPrice();
        }
        for (int i = 0; i<OrderLineArr.length;i++){
            this.listOfItems[i] = OrderLineArr[i].getItemNo();
        }
        this.totalPrice = tempPrice;
        this.orderNo = orderNo;
        this.deliveryTime = deliveryTime;
        this.isReady = isReady;
    }

    public OrderLine[] getOrderLineArr(){
        return this.OrderLineArr;
    }

    public int getTotalPrice(){
        return this.totalPrice;
    }

    public int getOrderNo(){
        return this.orderNo;
    }

    public int[] getListOfItems(){
        return this.listOfItems;
    }

    public String getDeliveryTime(){
        return this.deliveryTime;
    }

    public boolean getIsReady(){
        return this.isReady;
    }

    public void setIsReady(boolean isReady){
        this.isReady = isReady;
    }

    @Override
    public String toString() {
        return "orderNo=" + orderNo +
                ", totalPrice=" + totalPrice +
                ", deliveryTime='" + deliveryTime +
                ", Ready="+ isReady;
    }

    public static Order[] addOrder(Order[] OrderArr, Order NewOrder){
        OrderArr = Arrays.copyOf(OrderArr, OrderArr.length +1);
        OrderArr[OrderArr.length - 1] = NewOrder;
        return OrderArr;
    }

    public static int getTotalSales(Order[] OrderArr){
        int totalSales = 0;
        for (int i = 0; i<OrderArr.length; i++){
            totalSales += OrderArr[i].getTotalPrice();
        }
        return totalSales;
    }

//    public static int[] getListOfChoices(Order[] OrderArr){
//        int[] choices = new int[0];
//        int[] tmpChoices1 = new int[0];
//        int[] tmpChoices2 = new int[0];
//        int len1 = tmpChoices1.length;
//        int len2 = tmpChoices2.length;
//
//        for (Order Order: OrderArr){
//            tmpChoices2 = Order.getListOfItems();
//            len2 = tmpChoices2.length;
//            choices = new int[len1 + len2];
//            System.arraycopy(tmpChoices1, 0, choices, 0, len1);
//            System.arraycopy(tmpChoices2, 0, choices, len1, len2);
//        }
//        return choices;
//    }

}
