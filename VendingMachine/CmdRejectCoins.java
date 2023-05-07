import java.util.ArrayList;

public class CmdRejectCoins implements Command{
    @Override
    public String execute(VendingMachine v, String cmdPart) {
        int totalAmount = v.getTotalAmount();
        if(totalAmount == 0){
            return "Rejected no coin!";
        }
        
        String message = "Rejected ";
        ArrayList<Integer> coins = v.getInsertedCoins();
        for(int i=0; i < coins.size(); i++){
            String delim = "";
            if (i == coins.size() - 1) {
                delim = ". ";
            } else {
                delim = ", ";
            }
            
            message += ("$" + coins.get(i) + delim);
        }
        message += ("$" + totalAmount + " in total.");
        v.emptyCoins();
        return message;
    }
}