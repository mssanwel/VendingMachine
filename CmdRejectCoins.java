 
public class CmdRejectCoins extends Command {
	/**
	 *@override method
	 * @param v stores vending machine object
	 * @param cmdPart stores command value appropriate to command type
	 * @return string according to command type
	 */
	@Override  
	 	public String execute(VendingMachine v, String cmdPart) {      
		 	// Reject coin from coin slot
		 	int sum=0;
		 	if (v.coinSlot.isEmpty()){
		 		return "Rejected no coin!";
		 	}
		 	String out="Rejected"; 
		 	for(int i = 0; i < v.coinSlot.size(); i++)
		 	{
		 	    sum=sum+v.coinSlot.get(i);
		 	    out=out+" $"+v.coinSlot.get(i)+",";
		 	}
		 	while (!(v.coinSlot.isEmpty())) 
	        { 
		 		v.coinSlot.remove(0); 
	        } 
		 	out=out.substring(0,out.length()-1);
		 	out=out + ". $" + sum +" in Total.";
		 	return  out;
		} 
	}