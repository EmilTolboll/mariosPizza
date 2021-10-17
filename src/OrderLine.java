public class OrderLine {
    private int maxOrderLines = 1000;
    private int itemPrice;
    private int itemNo;
    private int orderNo;

    public OrderLine(int itemNo, int orderNo, MenuCard MenuCard){
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

}
