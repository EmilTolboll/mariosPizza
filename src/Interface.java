import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
// Interface made by Osman
public class Interface {
    private static int orderNoNow = 1;
    private static int orderNoPhone = 100;
    private static int totalRevenue = 0;

    public static void main(String[] args) {
        MenuCard myMenuCardArr = new MenuCard();
        Order[] OrderArr = new Order[0];
        Order[] OrderClosed = new Order[0];
        Scanner scannerInt = new Scanner(System.in);  // Create a Scanner object
        while(true){
            printInterface();
            int menuChoice = scannerInt.nextInt();
            if (menuChoice==1){
                myMenuCardArr.printMenuCard();
                System.out.println("####################################################################################################");
            }else if (menuChoice==2){
                OrderArr = Order.addOrder(OrderArr,getOrderFromUserTelephone(myMenuCardArr));
                System.out.println("####################################################################################################");
            }else if (menuChoice==3){
                OrderArr = Order.addOrder(OrderArr,getOrderFromUserNow(myMenuCardArr));
                System.out.println("####################################################################################################");
            }else if (menuChoice==4){
                Scanner scannerClose = new Scanner(System.in);  // Create a Scanner object
                System.out.println("Indtast ordre nummer:");
                int closeOrderNo = scannerClose.nextInt();
                OrderClosed = closeOrder(myMenuCardArr,OrderClosed,OrderArr,closeOrderNo);
                System.out.println("####################################################################################################");
            }else if (menuChoice==5){
                // Print bestillingsliste
                Collections.sort(Arrays.asList(OrderArr)); // Sort based on OrderNo
                System.out.println("Bestillingsliste:");
                if(OrderArr.length>0){
                    for (Order Order: OrderArr){
                        LocalDate.now().atTime(LocalTime.parse(Order.getDeliveryTime()));
                        if (Order.getIsReady()==false){ // If order is closed, then remove from list
                            System.out.println("#############################################################");
                            System.out.println(Order.toString());
                            for (OrderLine OrderLine: Order.getOrderLineArr()){
                                System.out.println(OrderLine.toString());
                            }
                        }
                    }
                }else{
                    System.out.println("Ingen ordrer tilgængelig!");
                }
                System.out.println("####################################################################################################");
            }else if (menuChoice==6){
                totalRevenue = Order.getTotalSales(OrderClosed);
                System.out.println("Dagens omsætning er: "+totalRevenue+ " (kun lukkede ordre)");
                System.out.println("####################################################################################################");
            }else if (menuChoice==7){
                // Mest populære pizza
                int[] listOfItemNo = new int[0];
                int length = listOfItemNo.length;
                for (int i=0; i<OrderArr.length; i++){
                    OrderLine[] tempOrderLineArr = OrderArr[i].getOrderLineArr();
                    for (int j=0; j<tempOrderLineArr.length; j++){
                        OrderLine tempOrderLine = tempOrderLineArr[j];
                        listOfItemNo = Arrays.copyOf(listOfItemNo, listOfItemNo.length+1);
                        length = listOfItemNo.length;
                        listOfItemNo[length - 1] = tempOrderLine.getItemNo();
                    }
                }
                int popularPizza = mostRepeatingNumber(listOfItemNo);
                System.out.println("Den mest solgte pizza er: "+myMenuCardArr.getPizzaName(popularPizza));

                System.out.println("####################################################################################################");
            }else if (menuChoice==8){
                Scanner scannerPizzaInt = new Scanner(System.in);  // Create a Scanner object
                Scanner scannerPizzaString = new Scanner(System.in);  // Create a Scanner object
                System.out.println("Indtast det nummer pizzaen skal have på menuen:");
                int pizzaNumber = scannerPizzaInt.nextInt();
                System.out.println("Indtast navnet på pizzaen:");
                String pizzaName = scannerPizzaString.nextLine();
                System.out.println("Indtast beskrivelsen af pizza:");
                String pizzaDescription = scannerPizzaString.nextLine();
                System.out.println("Indtast prisen på pizzaen:");
                int pizzaPrice = scannerPizzaInt.nextInt();
                Pizza userInputPizza = new Pizza(pizzaNumber,pizzaName,pizzaDescription,pizzaPrice,true);
                myMenuCardArr.addPizzaToMenuCard(userInputPizza);
            }else{
                System.out.println("Ugyldigt valg - prøv igen!");
                System.out.println("####################################################################################################");
            }
        }
    }

    public static Order getOrderFromUserNow(MenuCard myMenuCardArr){

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm");
        String deliveryTime = myDateObj.format(myFormatObj);

        OrderLine[] OrderLineArr = new OrderLine[0];
        Scanner scannerInt = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Indtast pizza nummer (tast 0 for at afslutte):");
        int itemNo = scannerInt.nextInt();
        if(itemNo>0){
            OrderLine OrderLine = new OrderLine(itemNo,orderNoNow,myMenuCardArr);
            OrderLineArr = OrderLine.addOrderLine(OrderLineArr, OrderLine);
        }
        while(itemNo > 0){
            System.out.println("Indtast pizza nummer (tast 0 for at afslutte):");
            itemNo = scannerInt.nextInt();
            if(itemNo>0){
                OrderLine OrderLine = new OrderLine(itemNo,orderNoNow,myMenuCardArr);
                OrderLineArr = OrderLine.addOrderLine(OrderLineArr, OrderLine);
            }
        }
        Order SingleOrder= new Order(OrderLineArr,orderNoNow,deliveryTime,false);
        orderNoNow += 1;
        return SingleOrder;
    }

    public static Order getOrderFromUserTelephone(MenuCard myMenuCardArr){

        LocalDateTime myDateObj = LocalDateTime.now().plusHours(1);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm");
        String deliveryTime = myDateObj.format(myFormatObj);

        OrderLine[] OrderLineArr = new OrderLine[0];
        Scanner scannerInt = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Indtast pizza nummer (tast 0 for at afslutte):");
        int itemNo = scannerInt.nextInt();
        if(itemNo>0){
            OrderLine OrderLine = new OrderLine(itemNo,orderNoPhone,myMenuCardArr);
            OrderLineArr = OrderLine.addOrderLine(OrderLineArr, OrderLine);
        }
        while(itemNo > 0){
            System.out.println("Indtast pizza nummer (tast 0 for at afslutte):");
            itemNo = scannerInt.nextInt();
            if(itemNo>0){
                OrderLine OrderLine = new OrderLine(itemNo,orderNoPhone,myMenuCardArr);
                OrderLineArr = OrderLine.addOrderLine(OrderLineArr, OrderLine);
            }
        }
        Order SingleOrder= new Order(OrderLineArr,orderNoPhone,deliveryTime,false);
        orderNoPhone += 1;
        return SingleOrder;
    }

    public static Order[] closeOrder(MenuCard myMenuCardArr,Order[] OrderClosed,Order[] OrderArr, int orderNo){
        int index = orderNo-1;

        if(OrderArr[index].getIsReady()==false){ // Only if the order is not ready
            OrderArr[index].setIsReady(true);
            OrderClosed = Order.addOrder(OrderClosed,OrderArr[index]);
        }else{
            System.out.println("Ordre er allerede lukket!");
        }
        return OrderClosed;
    }

    public static void printInterface(){
        System.out.println("Hovedmenu:");
        System.out.println("1: Se Menukort");
        System.out.println("2: Tilføj telefon ordre:");
        System.out.println("3: Tilføj direkte ordre:");
        System.out.println("4: Luk ordre");
        System.out.println("5: Se bestillingsliste");
        System.out.println("6: Se omsætning");
        System.out.println("7: Se mest populære pizza");
        System.out.println("8: Tilføj ny pizza til menu:");
    }

    public static int mostRepeatingNumber(int [] arrA){
        int maxCounter = 0;
        int element=0;
        for (int i = 0; i <arrA.length ; i++) {
            int counter =1;
            for (int j = i+1; j <arrA.length ; j++) {
                if(arrA[i]==arrA[j]){
                    counter++;
                }
            }
            if(maxCounter<counter){
                maxCounter=counter;
                element = arrA[i];
            }
        }
        return element;
    }

}
