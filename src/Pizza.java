public class Pizza {
    private int number;
    private String name;
    private String description;
    private int price;
    private boolean isNyhed;

    public Pizza(int number,String name, String description,int price){
        this.number = number;
        this.name = name;
        this.description = description;
        this.price = price;
        this.isNyhed = false;
    }
    public Pizza(int number,String name, String description,int price,boolean isNyhed){
        this.number = number;
        this.name = name;
        this.description = description;
        this.price = price;
        this.isNyhed = isNyhed;
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
    public boolean isNyhed(){
        return(isNyhed);
    }
}
