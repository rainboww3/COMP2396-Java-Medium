import java.util.ArrayList;
import java.util.Collections;

public class VendingMachine {
    // ArrayList of Integers represents inserted coins in Coin Slot
    private ArrayList<Integer> insertedCoins;
    // ArrayList of Product represents inventories of products
    private ArrayList<Product> products;
    
    private int[] coinStorage = {10, 5, 2, 1};
    private ArrayList<Integer> changeList;
    private int totalAmount;
    
    public VendingMachine() {
        insertedCoins = new ArrayList<Integer>();
        products = new ArrayList<Product>();
        changeList = new ArrayList<Integer>();
        totalAmount = 0;
    }
    
    public ArrayList<Product> getProducts(){
        return this.products;
    }
    
    public void addProduct(Product p) {
        products.add(p);
    }
    
    
    public void insertCoin(Integer c) {
        totalAmount += c; // increase total amount
        insertedCoins.add(c); // add to inserted coins
        Collections.sort(insertedCoins);
    }
    
    public ArrayList<Integer> getInsertedCoins(){
        return this.insertedCoins;
    }
    
    public int getTotalAmount(){
        return this.totalAmount;
    }

    public void emptyCoins(){
        this.totalAmount = 0;
        this.insertedCoins.clear();
    }

    ArrayList<Integer> calculateChange(int remaining){
        for(int i=0; i<4; i++){
            if(remaining != 0) {
                int numCoins = remaining / coinStorage[i]; // Give the largest coins as many as possible!
                if(numCoins != 0) {
                    for(int j = 0; j < numCoins; j++){
                        changeList.add(coinStorage[i]);
                    }
                    remaining -= (numCoins * coinStorage[i]);
                }
            }
        }
        Collections.reverse(changeList);
        return changeList;
    }

    public void emptyChangeList(){
        this.changeList.clear();
    }

    /* You may add other properties and methods */
}

