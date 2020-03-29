import java.util.*; 

/**
 * @author Muhammad Saad Shahid
 *
 */
public class VendingMachine {  
	/**
	 * coinChanger is array list of change coins
	 * coinSlot is array list of entered coins
	 * softDrinkSlots is array list drinks information in SoftDrinkSlot objects
	 */
	public ArrayList<Integer> coinChanger;
	public ArrayList<Integer> coinSlot;
	public ArrayList<SoftDrinkSlot> softDrinkSlots; 
	
/**
 * constructor
 */
public VendingMachine() {
	coinChanger = new ArrayList<Integer>();
	coinSlot = new ArrayList<Integer>();
	softDrinkSlots = new ArrayList<SoftDrinkSlot>();  
	}

 /**
 * @param c is variable for coin input
 */
public void addCoinToCoinChanger(Integer c) {
	 coinChanger.add(c);
	 Collections.sort(coinChanger);
	 Collections.reverse(coinChanger);
	 }
 
 /**
 * @param s is variable for SoftDrinkSlot object
 */
public void addSoftDrinkSlot(SoftDrinkSlot s) {
	 softDrinkSlots.add(s);  
	 }
 /* You may add other non-static properties and methods */ 
 }
