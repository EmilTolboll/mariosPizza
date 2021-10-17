public class Interface {
    private static Pizza myFirstPizza;
    private static Pizza mySecondPizza;

    public static void main(String[] args) {
        Pizza addPizzaObj = new Pizza(6,"Pizza3","Pizza 3 added",1000);


        MenuCard myMenuCardArr = new MenuCard();

        myMenuCardArr.printMenuCard();

        myMenuCardArr.addPizzaToMenuCard(addPizzaObj);

        myMenuCardArr.printMenuCard();

        //myMenuCardArr.removePizzaFromMenuCard(2);
        //myMenuCardArr.removePizzaFromMenuCard(3);

        myMenuCardArr.printMenuCard();

        System.out.println(myMenuCardArr.getPizzaPrice(4));

        // Testing orders
        OrderLine OrderLine1 = new OrderLine(1,1,myMenuCardArr);
        OrderLine OrderLine2 = new OrderLine(2,1,myMenuCardArr);
        OrderLine[] OrderLineArr1 = new OrderLine[] {OrderLine1,OrderLine2};

        Order Order1 = new Order(OrderLineArr1,1,"15:00");
        System.out.println("Price of order 1 is = "+Order1.getTotalPrice());

    }
}
