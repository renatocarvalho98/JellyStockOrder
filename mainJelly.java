package JellyStockOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class mainJelly {

    //list about stock itens  String manufacturer, float buyPrice, String flavour, float noCalories, String expiryDate, int stock
    public static void addStockItens(List<jelly> stockJelly, String manufacturer, double buyPrice,  String flavour, double noCalories,
    String expiryDate, int stock ){
        jelly newJelly = new jelly(manufacturer, buyPrice, flavour, noCalories, expiryDate, stock);
        stockJelly.add(newJelly);
        
    }

    //list about orders
    public static void addOrdersItens(List<jelly> orderList, String manufacturer, String flavour, double noCalories, String expiryDate, double sellPrice, int quantityOrder){
        jelly newOrderJelly = new jelly(manufacturer, flavour, noCalories, expiryDate, sellPrice,  quantityOrder);
        newOrderJelly.setSellPrice(sellPrice);
        orderList.add(newOrderJelly);
    } 



    public static void main(String[] args) {
        
    Scanner scanner =  new Scanner(System.in);
    List<jelly> stockJelly = new ArrayList<>();
    List<jelly> orderList = new ArrayList<>();



    //titens that i have at supplier

    addStockItens(stockJelly, "Nestle",  1.50, "Strawberry", 32.5f, "02/07/2026", 100);
    addStockItens(stockJelly, "Nestle", 2.50, "Banana", 23.5f, "02/07/2026", 100);
    addStockItens(stockJelly, "Haribbo", 1.50, "Strawberry iced", 35.5f, "02/07/2026", 100);    




    for (jelly jelly : stockJelly) {
        System.out.println(jelly.toStringADMIN() + "\n");
        
    }
        



    System.out.println("------Renato Candys Supplier------"+
                        "\nWe have Jellys about many flavours and Brands"+
                        "\nTell us your order about your Jellys "  +  
                        "\nYou are ADM (Put more stock) / Customer (Make List and buy)");


        String customerOrADMIN = scanner.nextLine();
    


        while (true) {
            
        
        //using while to make sure about imput admin or customer
        while (true) {
            if (customerOrADMIN.equalsIgnoreCase("admin") || customerOrADMIN.equalsIgnoreCase("customer")) {
                break;
            }else{
                System.out.println("Please, only customer or ADMIN(stock)");
            }  
        }

        //here check about admin and giving option to add new jelly
        if (customerOrADMIN.equalsIgnoreCase("admin")) {

            System.out.println("You want to add new stock? ? (yes/no)");
            String response = scanner.nextLine();    
            while (response.equalsIgnoreCase("yes")) {

                System.out.println("Brand : ");
                String brand = scanner.nextLine();

                System.out.println("Price Buy: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Please enter a valid double value for Price Buy:");
                    scanner.next();
                }
                double price = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Flavor : ");
                String flavor = scanner.nextLine();
                
                System.out.println("Calories : ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Please enter a valid double value for Calories:");
                    scanner.next();
                }double calories = scanner.nextDouble();
                scanner.nextLine();


                System.out.println("Expery Date : ");
                String date = scanner.nextLine();

                System.out.println("Stock : ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid integer value for Stock:");
                    scanner.next();
                }
                int stock = scanner.nextInt();
                scanner.nextLine();
                ;
    
                addStockItens(stockJelly, brand, price, flavor, calories, date, stock);
                
                //show the list that already have and add new 
                for (jelly jelly : stockJelly) {
                    System.out.println(jelly.toStringADMIN() + "\n");
                    
                }

                //aasking if the admin want to add more itens(jelly)
                System.out.println("Would like to add new item? (Yes/No)");
                response = scanner.nextLine();
                
            }
        }    

                
         if (customerOrADMIN.equalsIgnoreCase("customer")) {
            System.out.println("You want to add new order ? (yes/no)");
            String response = scanner.nextLine();    

            while (response.equalsIgnoreCase("yes")) {
                System.out.println("Perfect! Lets add some itens at your order." +
                                    "\nFollow the items list : ");
                                    for (jelly jelly : stockJelly) {
                                        System.out.println(jelly.toString() + "\n");
                                        
                                    }     
                
                System.out.println("Tell about the flavour : ");
                String flavour = scanner.nextLine();
                System.out.println("Tell about the brand : ");
                String brand = scanner.nextLine();   
                System.out.println("How many your would like to order (make sure about stoke avaible) : ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid integer value for quantity:");
                    scanner.next();
                }
                int quantity = scanner.nextInt();
                scanner.nextLine();//clean the buffer scanner         
                
                boolean itemFound = false;
                for (jelly jelly : stockJelly) {
                    if (jelly.getFlavour().equalsIgnoreCase(flavour) && jelly.getStock() >= quantity && jelly.getManufacturer().equalsIgnoreCase(brand)) {
                        itemFound = true;
                        addOrdersItens(orderList, jelly.getManufacturer(), jelly.getFlavour(), jelly.getNoCalories(), jelly.getExpiryDate(), jelly.getSellPrice(), quantity);
                        jelly.setStock(jelly.getStock() - quantity);
                        break;
                    }
                 }
                    if (!itemFound) {
                        System.out.println("Item not found or there is no stock");
                    }
        
                    System.out.println("Would like to order new one? (yes/no)");
                    response = scanner.nextLine();    
            }
            
        }
       
            //checking list and make price
        double totalPrice = 0;
        for (jelly jelly : orderList) {
        totalPrice += jelly.getSellPrice() * jelly.getQuantityOrder();
             
        }


            System.out.println("Customer Order:");
            for (jelly jelly : orderList) {
                jelly.displayJellyCustomer();
                System.out.println();
            }





           
        // Exibe o preço total
        System.out.printf("Total Price: %.2f%n", totalPrice);
        scanner.close();
        break;

               


        
    
    
    
}
    }}