public class MenuCard {
    private static Pizza PizzaMenuCard;
    private static Pizza[] PizzaMenuCardArr;

    private static int lengthOfMenuLines = 100;

    //public static void addPizzaToMenuCard(int PizzaNumber,String PizzaName,String PizzaDescription,int PizzaPrice ){
    //   PizzaMenuCard = new Pizza(PizzaNumber,PizzaName,PizzaDescription,PizzaPrice);
    //}

    public MenuCard(Pizza Pizza){
        this.PizzaMenuCard = Pizza;
    }

    public MenuCard(Pizza[] PizzaArr){
        this.PizzaMenuCardArr = PizzaArr;
    }
/*
    public MenuCard(){
        Pizza Vesuvio = new Pizza()

        this.PizzaMenuCardArr = {};
    }*/
    public static void printMenuLine(Pizza PizzaObj){
        String tmpString = PizzaObj.getPizzaNumber()+ ".   " + PizzaObj.getPizzaName() + ": " + PizzaObj.getPizzaDescription() + PizzaObj.getPizzaPrice() + ",-";
        String tmpPeriodString = ".";
        String periodString = tmpPeriodString.repeat(lengthOfMenuLines-tmpString.length());
        System.out.println(PizzaObj.getPizzaNumber()+ ".   " + PizzaObj.getPizzaName() + ": " + PizzaObj.getPizzaDescription() + periodString + PizzaObj.getPizzaPrice() + ",-");

    }

    public static void printMenuCard(){
        System.out.println("                        PIZZAER                           ");
        String tmpString = PizzaMenuCard.getPizzaNumber()+ ".   " + PizzaMenuCard.getPizzaName() + ": " + PizzaMenuCard.getPizzaDescription() + PizzaMenuCard.getPizzaPrice() + ",-";
        String tmpPeriodString = ".";
        String periodString = tmpPeriodString.repeat(lengthOfMenuLines-tmpString.length());
        System.out.println(PizzaMenuCard.getPizzaNumber()+ ".   " + PizzaMenuCard.getPizzaName() + ": " + PizzaMenuCard.getPizzaDescription() + periodString + PizzaMenuCard.getPizzaPrice() + ",-");
    }



    public static void printMenuCardArr(){
        System.out.println("                                          PIZZAER                                          ");
        for (int i = 0; i < PizzaMenuCardArr.length; i++){
            printMenuLine(PizzaMenuCardArr[i]);
        }

        //System.out.println(PizzaMenuCardArr[0].getPizzaNumber() + ".   " + PizzaMenuCardArr[0].getPizzaName() + ": " + PizzaMenuCardArr[0].getPizzaDescription() + "......" + PizzaMenuCardArr[0].getPizzaPrice() + ",-");
        //System.out.println(PizzaMenuCardArr[1].getPizzaNumber() + ".   " + PizzaMenuCardArr[1].getPizzaName() + ": " + PizzaMenuCardArr[1].getPizzaDescription() + "......" + PizzaMenuCardArr[1].getPizzaPrice() + ",-");
    }

    public Pizza[] addPizzaToMenuCard(Pizza PizzaObj){
        PizzaMenuCardArr[PizzaMenuCardArr.length] = new Pizza(3,"Pizza3","Pizza 3 added",1000);
        return PizzaMenuCardArr;
    }

}
