package JellyStockOrder;
public class jelly {

    private String manufacturer;
    private double sellPrice;
    private double buyPrice;	
    private String flavour;
    private double noCalories;
    private String expiryDate;
    private int stock;
    private int quantityOrder;


    
    //all itens
    public jelly(String manufacturer, double buyPrice, String flavour, double noCalories,
            String expiryDate, int stock) {
        this.manufacturer = manufacturer;
        this.buyPrice = buyPrice;
        this.flavour = flavour;
        this.noCalories = noCalories;
        this.expiryDate = expiryDate;
        this.stock = stock;
        priceJellySell(buyPrice);
    } 

    

    //customer orders construc
    public jelly(String manufacturer, String flavour, double noCalories, String expiryDate, double sellPrice, int quantityOrder) {
        this.manufacturer = manufacturer;
        this.sellPrice = sellPrice;
        this.flavour = flavour;
        this.noCalories = noCalories;
        this.expiryDate = expiryDate;
        this.quantityOrder = quantityOrder;
    }




    public void priceJellySell(double buyPrice){

        this.sellPrice = this.buyPrice * 1.60;

        
    }

    public void stockJellyAfter(int stock){
        this.stock = this.stock - this.quantityOrder;
    }

    public String formattedPrice(){
        return String.format("%.2f", sellPrice);
    }



    

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getSellPrice() {
        return sellPrice;
    }
                       
    public void setSellPrice(double sellPrice2) {
        this.sellPrice = sellPrice2;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public double getNoCalories() {
        return noCalories;
    }

    public void setNoCalories(float noCalories) {
        this.noCalories = noCalories;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getQuantityOrder() {
        return quantityOrder;
    }

    public void setQuantityOrder(int quantityOrder) {
        this.quantityOrder = quantityOrder;
    }    




   
    public void setInstructions(){
        System.out.println("Leave Jelly to set in a cool environment for 1hr");
    }

    public void displayJellyADMIN(){

        System.out.println("Brand : " + manufacturer +
                        "\nFlavour : " + flavour +
                        "\nPrice buy : " + buyPrice +
                        "\nPrice to sell : " + formattedPrice() +
                        "\nCalories : " + noCalories +
                        "\nExpery Date : " + expiryDate +
                        "\nStock avaible " + stock 
                        );

    

    }

    public void displayJellyCustomer(){

        System.out.println("Brand : " + manufacturer +
                        "\nFlavour : " + flavour +
                        "\nPrice : " + formattedPrice() +
                        "\nCalories : " + noCalories +
                        "\nExpery Date : " + expiryDate +
                        "\nQuantity orderded " + quantityOrder
                        );

        


    }
    @Override
    public String toString(){
        return "Brand : " + manufacturer +
                        "\nFlavour : " + flavour +
                        "\nPrice : " + formattedPrice() +
                        "\nCalories : " + noCalories +
                        "\nExpery Date : " + expiryDate +
                        "\nStock avaible :" + stock ;


    }

   
    public String toStringADMIN(){
        return "Brand : " + manufacturer +
                        "\nFlavour : " + flavour +
                        "\nPrice buy : " + buyPrice +
                        "\nPrice to sell : " + formattedPrice() +
                        "\nCalories : " + noCalories +
                        "\nExpery Date : " + expiryDate +
                        "\nStock avaible " + stock ;


    }





    
    
}
