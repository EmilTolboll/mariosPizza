import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Scanner;

public class Interface {
    private static Pizza myFirstPizza;
    private static Pizza mySecondPizza;
    private static int orderNoNew = 1;
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
                OrderArr = Order.addOrder(OrderArr,getOrderFromUser(myMenuCardArr));
                System.out.println("####################################################################################################");
            }else if (menuChoice==3){
                Scanner scannerClose = new Scanner(System.in);  // Create a Scanner object
                System.out.println("Indtast ordre nummer:");
                int closeOrderNo = scannerClose.nextInt();
                OrderClosed = closeOrder(myMenuCardArr,OrderClosed,OrderArr,closeOrderNo);
                System.out.println("####################################################################################################");
            }else if (menuChoice==4){
                // Print bestillingsliste
                System.out.println("Bestillingsliste:");
                if(OrderArr.length>0){
                    for (Order Order: OrderArr){
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
            }else if (menuChoice==5){
                totalRevenue = Order.getTotalSales(OrderClosed);
                System.out.println("Dagens omsætning er: "+totalRevenue+ " (kun lukkede ordre)");
                System.out.println("####################################################################################################");
            }else if (menuChoice==6){
                // Mest populære pizza
                System.out.println("####################################################################################################");
            }else{
                System.out.println("Ugyldigt valg - prøv igen!");
                System.out.println("####################################################################################################");
            }
        }

        // Testing orders
//
//        OrderArr = Order.addOrder(OrderArr,getOrderFromUser(myMenuCardArr));
//        OrderArr = Order.addOrder(OrderArr,getOrderFromUser(myMenuCardArr));
//        OrderArr = Order.addOrder(OrderArr,getOrderFromUser(myMenuCardArr));
//        System.out.println(OrderArr[0].toString());
//        System.out.println(OrderArr[1].toString());
//        System.out.println(OrderArr[2].toString());
//        Scanner scannerInt = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("Enter which orderNo to close:");
//        int closeOrderNo = scannerInt.nextInt();
//        OrderClosed = closeOrder(myMenuCardArr,OrderClosed,OrderArr,closeOrderNo);
//        int totalPrice = Order.getTotalSales(OrderClosed);
////        int[] listOfItems = OrderArr[0].getListOfItems();
////        for (int items: listOfItems){
////            System.out.println(items);
////        }
//
//        int[] choices = Order.getListOfChoices(OrderArr);
//        for (int choice: choices){
//            System.out.println(choice);
//        }
//        System.out.println("Length of choices = "+choices.length);
    }

    public static Order getOrderFromUser(MenuCard myMenuCardArr){

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm");
        String deliveryTime = myDateObj.format(myFormatObj);

        OrderLine[] OrderLineArr = new OrderLine[0];
        Scanner scannerInt = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Indtast pizza nummer (tast 0 for at afslutte):");
        int itemNo = scannerInt.nextInt();
        if(itemNo>0){
            OrderLine OrderLine = new OrderLine(itemNo,orderNoNew,myMenuCardArr);
            OrderLineArr = OrderLine.addOrderLine(OrderLineArr, OrderLine);
        }
        while(itemNo > 0){
            System.out.println("Indtast pizza nummer (tast 0 for at afslutte):");
            itemNo = scannerInt.nextInt();
            if(itemNo>0){
                OrderLine OrderLine = new OrderLine(itemNo,orderNoNew,myMenuCardArr);
                OrderLineArr = OrderLine.addOrderLine(OrderLineArr, OrderLine);
            }
        }
        Order SingleOrder= new Order(OrderLineArr,orderNoNew,deliveryTime,false);
        orderNoNew += 1;
        return SingleOrder;
    }

    public static Order[] closeOrder(MenuCard myMenuCardArr,Order[] OrderClosed,Order[] OrderArr, int orderNo){
        int index = orderNo-1;

        if(OrderArr[index].getIsReady()==false){ // Only if the order is not ready
            OrderArr[index].setIsReady(true);
            OrderClosed = Order.addOrder(OrderClosed,OrderArr[index]);
//
//
//            // Create a proxy array of size one less than original array
//            Order[] proxyArray = new Order[OrderArr.length - 1];
//
//            // copy all the elements in the original to proxy array except the one at index
//            for (int i = 0, k = 0; i < OrderArr.length; i++) {
//                // check if index is crossed, continue without copying
//                if (i == index) {
//                    continue;
//                }
//                // else copy the element
//                proxyArray[k++] = OrderArr[i];
//            }
        }else{
            System.out.println("Ordre er allerede lukket!");
        }
        return OrderClosed;
    }

    public static void printInterface(){
        System.out.println("Hovedmenu:");
        System.out.println("1: Se Menukort");
        System.out.println("2: Tilføj ordre telefon ordre:");
        System.out.println("3: Tilføj ordre ():");
        System.out.println("3: Luk ordre");
        System.out.println("4: Se bestillingsliste");
        System.out.println("5: Se omsætning");
        System.out.println("6: Se mest populære pizza");
    }

}
