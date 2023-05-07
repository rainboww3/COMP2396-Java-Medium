import java.util.ArrayList;
public class CmdPurchase implements Command{
    @Override
    public String execute(VendingMachine v, String cmdPart) {

        ArrayList<Product> currentProducts = v.getProducts();
        Product targetProduct = null;
        for(Product p: currentProducts){
            if(p.getName().equals(cmdPart)){
                targetProduct = p;
            }
        }
        
        int totalAmount = v.getTotalAmount();
        int targetProductPrice = targetProduct.getPrice();
        
        if(targetProduct.getQuantity() == 0){
            return (cmdPart + " is out of stock!");
        }

        if(totalAmount < targetProductPrice){
            return ("Not enough credit to buy Pepsi! Inserted $"+v.getTotalAmount()+" but needs $"+targetProduct.getPrice()+".");
        }
        
        // Inserted coins exactly match the target product price
        if(totalAmount == targetProductPrice){
            targetProduct.addQuantity(-1);
            v.emptyCoins();
            return ("Dropped "+cmdPart+". Paid $"+targetProduct.getPrice()+". No change.");
        }

        // Insert coins greater than the target product price -> must give changes
        if(totalAmount > targetProductPrice){
            String message = ("Dropped " + cmdPart + ". Paid $" + v.getTotalAmount() + ". Your change: ");
            int remainingAmount = totalAmount - targetProductPrice;
            ArrayList<Integer> changeList = v.calculateChange(remainingAmount);

            for(int i=0; i<changeList.size(); i++){
                String delim = "";
                if (i == changeList.size() - 1) {
                    delim = ".";
                }else {
                    delim = ", ";
                }
                message += ("$" + changeList.get(i) + delim);
            }
            v.emptyCoins();
            v.emptyChangeList();
            return message;
        }

        return "";


    }
}