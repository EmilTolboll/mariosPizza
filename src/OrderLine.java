import java.util.Arrays;

public class OrderLine {
    private int orderNo;
    private int itemNo;
    private int itemPrice;

    public OrderLine(int itemNo, int orderNo, MenuCard MenuCard){
        this.itemPrice = MenuCard.getPizzaPrice(itemNo);
        this.itemNo = itemNo;
        this.orderNo = orderNo;
    }

    public OrderLine(int itemNo, MenuCard MenuCard){
        this.itemPrice = MenuCard.getPizzaPrice(itemNo);
        this.itemNo = itemNo;
        this.orderNo = orderNo;
    }

    public int getItemPrice(){
        return this.itemPrice;
    }

    public int getItemNo(){
        return this.itemNo;
    }

    public int getOrderNo(){
        return this.orderNo;
    }

    public static OrderLine[] addOrderLine(OrderLine[] OrderLineArr, OrderLine NewOrderLine){
        OrderLineArr = Arrays.copyOf(OrderLineArr, OrderLineArr.length +1);
        OrderLineArr[OrderLineArr.length - 1] = NewOrderLine;
        return OrderLineArr;
    }

    @Override
    public String toString() {
        return "- orderNo=" + orderNo +
                ", itemNo=" + itemNo +
                ", itemPrice=" + itemPrice;
    }
}
