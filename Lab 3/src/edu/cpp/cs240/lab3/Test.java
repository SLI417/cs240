package edu.cpp.cs240.lab3;
import java.util.Random;

public class Test {
	
	public static void main(String[] args) {
		Random rand = new Random();
		
		int lostCustomerDay = 0;
		
		int countBurger = 0;
		int countCB = 0;
		int countVeganBurger = 0;
		int countBurgerNoOnion = 0;
		int countCBNoOnion = 0;
		int countBurgerNoTomato = 0;
		
		int wasteCheese = 0;
		int wasteBun = 0;
		int wastePatty = 0;
		int wasteLettuce = 0;
		int wasteTomato = 0;
		int wasteOnion = 0;
		
		Inventory inv = new Inventory();
		int currentDate = 301;
		for(int days = 0; days < 31; days++,currentDate++){ //DAY LOOP - 31 days
			
			//Shipment arrives every 3rd day
			if ( days % 3 == 0 ){
				inv.receiveShipment(currentDate);
			}
			
			for(int hour=10; hour<20; hour++){  //HOUR LOOP - 10 hours
				

				
				//Generating customer queue
				int numCustomers = rand.nextInt(100)+1;
				ArrayQueue<Customer> customers = new ArrayQueue<Customer>(50);
				if( numCustomers > 50 ){
					lostCustomerDay += numCustomers - 50;
					numCustomers = 50;
				}
				for(int j=0; j<numCustomers; j++){
					Customer c = new Customer();
					customers.enqueue(c);
				}
				
				//Making customer orders
				while( !customers.isEmpty() ){
					int itemNum = rand.nextInt(6);
					boolean success = false;
					switch(itemNum){
					case 0:
						if(inv.makeBurger()){
							countBurger++;
							success = true;
						}
						break;
					case 1:
						if(inv.makeCheeseBurger()){
							countCB++;
							success = true;
						}
						break;
					case 2:
						if(inv.makeVeganBurger()){
							countVeganBurger++;
							success = true;
						}
						break;
					case 3:
						if(inv.makeNoOnionBurger()){
							countBurgerNoOnion++;
							success = true;
						}
						break;
					case 4:
						if(inv.makeNoOnionCheeseBurger()){
							countCBNoOnion++;
							success = true;
						}
						break;
					case 5:
						if(inv.makeBurgerNoTomato()){
							countBurgerNoTomato++;
							success = true;
						}
					}
					if (!success){
						lostCustomerDay++;
					}
					customers.dequeue();
				}
				
			}
			// Sorting inventory, disposing of expired food 
			int[] waste = inv.sortInventory(currentDate);
			wasteCheese = waste[0];
			wasteBun = waste[1];
			wastePatty = waste[2];
			wasteLettuce = waste[3];
			wasteTomato = waste[4];
			wasteOnion = waste[5];
			
			// System.out.printlining everything
			System.out.println( "Date: " + stupidDateParse(currentDate));
			System.out.println( "Customers Lost: " + lostCustomerDay);
			System.out.println( "Cheese wasted: " + wasteCheese);
			System.out.println( "Buns wasted: " + wasteBun);
			System.out.println( "Patties wasted: " + wastePatty);
			System.out.println( "Lettuce wasted: " + wasteLettuce);
			System.out.println( "Tomato wasted: " + wasteTomato);
			System.out.println( "Onion wasted: " + wasteOnion);
			System.out.println( "Burgers made: " + countBurger);
			System.out.println( "Cheeseburgers made: " + countCB);
			System.out.println( "Vegan burgers made: " + countVeganBurger);
			System.out.println( "Onionless burgers made: " + countBurgerNoOnion);
			System.out.println( "Onionless cheeseburgers made: " + countCBNoOnion);
			System.out.println( "Tomatoless burgers made: " + countBurgerNoTomato);
			System.out.println( "\n");
			

			
			// reset everything.
			lostCustomerDay = 0;
			
			countBurger = 0;
			countCB = 0;
			countVeganBurger = 0;
			countBurgerNoOnion = 0;
			countCBNoOnion = 0;
			countBurgerNoTomato = 0;
			
			wasteCheese = 0;
			wasteBun = 0;
			wastePatty = 0;
			wasteLettuce = 0;
			wasteTomato = 0;
			wasteOnion = 0;
		}
	}
	
	private static String stupidDateParse(int date){
		return "March " + ( date - 300 );
	}

}
