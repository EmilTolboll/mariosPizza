import java.util.ArrayList;
import java.util.List;
// Class made by Emil
public class MenuCard<PizzaMenuCardArrList> {
    public static int getPizza;
    private  Pizza PizzaMenuCard;
    private  Pizza[] PizzaMenuCardArr;
    public   List<Pizza> PizzaMenuCardArrList = new ArrayList <Pizza>();


    private static int lengthOfMenuLines = 100;


    public MenuCard(Pizza Pizza){
        this.PizzaMenuCard = Pizza;
    }

    public MenuCard(Pizza[] PizzaArr){
        this.PizzaMenuCardArr = PizzaArr;
    }

    public MenuCard(){
        Pizza Vesuvio = new Pizza(1,"Vesuvio","tomatsauce,ost,skinke og oregano",57);
        Pizza Amerikaner = new Pizza(2,"Amerikaner","tomatsauce,ost,oksefars og oregano",53,true);
        Pizza Cacciatore = new Pizza(3,"Cacciatore","tomatsauce,ost,pepperoni og oregano",57);
        Pizza Carbona = new Pizza(4,"Carbona","tomatsauce,ost,kødsauce,spaghetti,cocktailpølser og oregano",63);
        Pizza Dennis = new Pizza(5,"Dennis","tomatsauce,ost,skinke,pepperoni,cocktailpølser og oregano",65);
        Pizza Bertil = new Pizza(6,"Bertil","tomatsauce,ost,bacon og oregano",57);
        Pizza Silvia = new Pizza(7,"Silvia","tomatsauce,ost,pepperoni,rød peber,løg,oliven og oregano",61);
        Pizza Victoria = new Pizza(8,"Victoria","tomatsauce,ost,skinke,ananas,champignon,løg og oregano",61);
        Pizza Toronfo = new Pizza(9,"Toronfo","tomatsauce,ost,skinke,bacon,kebab,chili og oregano",61,true);
        /*Pizza Capricciosa = new Pizza(10,"Capricciosa","tomatsauce,ost,skinke,champignon og oregano",61);
        Pizza Hawaii = new Pizza(11,"Hawaii","tomatsauce,ost,skinke,ananas og oregano",61);
        Pizza Blissola = new Pizza(12,"Blissola","tomatsauce,ost,skinke,rejer og oregano",61);
        Pizza Venezia = new Pizza(13,"Venezia","tomatsauce,ost,skinke,bacon og oregano",61);
        Pizza Mafia = new Pizza(14,"Mafia","tomatsauce,ost,pepperoni,bacon,løg og oregano",61,true);
*/

        this.PizzaMenuCardArr = new Pizza[] {Vesuvio,Amerikaner,Cacciatore,Carbona,Dennis};
        this.PizzaMenuCardArrList.add(Vesuvio);
        this.PizzaMenuCardArrList.add(Amerikaner);
        this.PizzaMenuCardArrList.add(Cacciatore);
        this.PizzaMenuCardArrList.add(Carbona);
        this.PizzaMenuCardArrList.add(Dennis);
        this.PizzaMenuCardArrList.add(Bertil);
        this.PizzaMenuCardArrList.add(Silvia);
        this.PizzaMenuCardArrList.add(Victoria);
        this.PizzaMenuCardArrList.add(Toronfo);
    }

    public static void printMenuLine(Pizza PizzaObj){
        String tmpString = "";
        String tmpPeriodString = ".";
        String periodString = "";
        if(PizzaObj.isNyhed()) {
            tmpString = PizzaObj.getPizzaNumber() + ".   " + PizzaObj.getPizzaName() + ":(Nyhed) " + PizzaObj.getPizzaDescription() + PizzaObj.getPizzaPrice() + ",-";
            periodString = tmpPeriodString.repeat(lengthOfMenuLines-tmpString.length());
            System.out.println(PizzaObj.getPizzaNumber()+ ".   " + PizzaObj.getPizzaName() + ":(Nyhed) " + PizzaObj.getPizzaDescription()  + periodString + PizzaObj.getPizzaPrice() + ",-");
        }else {
            tmpString = PizzaObj.getPizzaNumber() + ".   " + PizzaObj.getPizzaName() + ": " + PizzaObj.getPizzaDescription() + PizzaObj.getPizzaPrice() + ",-";
            periodString = tmpPeriodString.repeat(lengthOfMenuLines-tmpString.length());
            System.out.println(PizzaObj.getPizzaNumber()+ ".   " + PizzaObj.getPizzaName() + ": " + PizzaObj.getPizzaDescription() + periodString + PizzaObj.getPizzaPrice() + ",-");
        }
    }

    public void printMenuCard(){
        System.out.println("                                          PIZZAER                                          ");
        for (int i = 0; i < PizzaMenuCardArrList.size(); i++){
            printMenuLine(PizzaMenuCardArrList.get(i));
        }
    }

    public void addPizzaToMenuCard(Pizza pizzaObj){
        PizzaMenuCardArrList.add(pizzaObj);
    }

    public void removePizzaFromMenuCard(int pizzaNumber){
        for (int i = 0;i<PizzaMenuCardArrList.size();i++){
            if (pizzaNumber== PizzaMenuCardArrList.get(i).getPizzaNumber()){
                PizzaMenuCardArrList.remove(i);
            }
        }
    }

    public int getPizzaPrice(int pizzaNumber){
        int pizzaPrice = 0;
        for (int i = 0;i<PizzaMenuCardArrList.size();i++){
            if (pizzaNumber== PizzaMenuCardArrList.get(i).getPizzaNumber()){
                pizzaPrice = PizzaMenuCardArrList.get(i).getPizzaPrice();
            }
        }
        return pizzaPrice;
    }

    public String getPizzaName(int pizzaNumber){
        String pizzaName = "";
        for (int i = 0;i<PizzaMenuCardArrList.size();i++){
            if (pizzaNumber== PizzaMenuCardArrList.get(i).getPizzaNumber()){
                pizzaName = PizzaMenuCardArrList.get(i).getPizzaName();
            }
        }
        return pizzaName;
    }

}
