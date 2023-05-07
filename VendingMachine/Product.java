public class Product {
    private String name;
    private int price;
    private int quantity;
    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    /* You may add other properties and methods */
    public void addQuantity(int n){
        this.quantity += (n);
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getPrice(){
        return this.price;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
}