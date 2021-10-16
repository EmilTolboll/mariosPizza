public class Pizza {
    private int number;
    private String name;
    private String description;
    private int price;

    public Pizza(int number,String name, String description,int price){
        this.number = number;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getPizzaNumber(){
        return(number);
    }
    public String getPizzaName(){
        return(name);
    }
    public String getPizzaDescription(){
        return(description);
    }
    public int getPizzaPrice(){
        return(price);
    }
}
