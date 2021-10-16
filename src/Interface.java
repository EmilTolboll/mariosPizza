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
    }
}
