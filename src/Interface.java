public class Interface {
    private static Pizza myFirstPizza;
    private static Pizza mySecondPizza;

    public static void main(String[] args) {
        Pizza myFirstPizza = new Pizza(1,"testName","testdesc",50);
        Pizza mySecondPizza = new Pizza(2,"testName2","testdjnjdesc2",52);
        //System.out.println("The Pizza price is " + myFirstPizza.getPizzaPrice());
        Pizza addPizzaObj = new Pizza(3,"Pizza3","Pizza 3 added",1000);

        Pizza[] myPizzaArr = {myFirstPizza,mySecondPizza,addPizzaObj};
        /*
        MenuCard myMenuCard = new MenuCard(myFirstPizza);
        System.out.println("My First menu card");
        //myMenuCard.printMenuCard();
        //myMenuCard.printMenuLine(myFirstPizza);

*/

        MenuCard myMenuCardArr = new MenuCard(myPizzaArr);


        System.out.println("Array menu is" );
        myMenuCardArr.printMenuCardArr();



        //myMenuCardArr.addPizzaToMenuCard(addPizzaObj);

        //myMenuCardArr.printMenuCardArr();

    }
}
