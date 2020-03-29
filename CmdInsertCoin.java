import java.util.Collections;

public class CmdInsertCoin extends Command {
	/**
	 *@override method
	 * @param v stores vending machine object
	 * @param cmdPart stores command value appropriate to command type
	 * @return string according to command type
	 */
	@Override  
	 	public String execute(VendingMachine v, String cmdPart){   
		 	Integer coin = Integer.valueOf(cmdPart);
		 	// Add the coin to Coin Slot
		 	v.coinSlot.add(coin);
		 	Collections.sort(v.coinSlot);
		 	int sum=0;
		 	for(int i = 0; i < v.coinSlot.size(); i++)
		 	{
		 	    sum=sum+v.coinSlot.get(i);
		 	}
		 	String out="Inserted a $" + coin +" coin. $"+ sum+" in Total.";
		 	return  out;
		} 
}