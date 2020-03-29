import java.util.*;

public class CmdPurchase extends Command {
	
	 /**
	 *@override method
	 * @param v stores vending machine object
	 * @param cmdPart stores command value appropriate to command type
	 * @return string according to command type
	 */
	@Override  
	 	public String execute(VendingMachine v, String cmdPart) {   
		 	ArrayList<Integer> coinUsed;
		 	coinUsed = new ArrayList<Integer>();	
		 	// Buy product
		 	String out="Purchasing "+cmdPart+"... ";
		 	int price=0;
		 	int productQ=0;
		 	for(int i = 0; i < v.softDrinkSlots.size(); i++)
		 	{
		 		if (v.softDrinkSlots.get(i).name==cmdPart) {
		 			price=v.softDrinkSlots.get(i).price;
		 			productQ=v.softDrinkSlots.get(i).quantity;
		 			v.softDrinkSlots.get(i).quantity=v.softDrinkSlots.get(i).quantity-1;
		 			productQ=v.softDrinkSlots.get(i).quantity;
		 		}
		 	}
		 	int sum=0;
		 	for(int i = 0; i < v.coinSlot.size(); i++)
		 	{
		 	    sum=sum+v.coinSlot.get(i);
		 	}
		 	//System.out.println("Sum is "+sum);
		 	//System.out.println("Price is "+price);
		 	//System.out.println("Quantity is "+productQ);
		 	if (price>sum) {
		 		out=out+ "Insufficient amount! Inserted $"+sum+" but needs $"+price+".";
		 	}
		 	else{
		 		int total=0;
		 		int change=sum-price;
		 		String coinChange="";
		 		Collections.sort(v.coinChanger);
		 		Collections.reverse(v.coinChanger);
		 		for(int i = 0; i < v.coinChanger.size(); i++)
			 	{
		 				if ((v.coinChanger.get(i)+total)>change) {
		 					
		 				}
		 				else {
		 					total=total+v.coinChanger.get(i);
		 					coinUsed.add(v.coinChanger.get(i));
		 				}
			 	}
		 		if (productQ<0) {
			 		out=out+"Out of stock!";
			 		return out;
			 	}
		 		else if (change==0) {
		 			out=out+"Success! Paid $"+price+".";
		 			out=out+" No change.";
		 		}
		 		else if (total==change) {
		 			//System.out.println("total is "+total);
		 			//System.out.println("change is "+change);
		 			out=out+"Success! Paid $"+sum+".";
		 			Collections.sort(coinUsed);
		 			for(int i = 0; i < coinUsed.size(); i++) {
		 				coinChange=coinChange+" $"+coinUsed.get(i)+",";
		 			}
		 			out=out+" Change:"+coinChange.substring(0,coinChange.length()-1)+".";
		 		}
		 		else {
		 			out=out+"Insufficient change!";
		 			return out;
		 		}
		 		
		 		
		 		//updating coinChanger
		 		for(int i = 0; i < v.coinSlot.size(); i++) {
		 			v.coinChanger.add(v.coinSlot.get(i));
		 		}
		 		while (!(v.coinSlot.isEmpty())) 
		        { 
			 		v.coinSlot.remove(0); 
		        }
		 		while(!(coinUsed.isEmpty()))
			 	{
		 			for(int i = 0; i < v.coinChanger.size(); i++)
		 			{
		 				if (!(coinUsed.isEmpty()) && coinUsed.get(0)==(v.coinChanger.get(i))) 
		 				{
		 					v.coinChanger.remove(i);
		 					coinUsed.remove(0);
		 				}
		 			}
		 		}
		 		
		 	}
		 	return out;
		 	}
		}