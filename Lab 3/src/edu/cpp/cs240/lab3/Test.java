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
		int countCBnoOnion = 0;
		int countBurgerNoTomato = 0;
		
		Inventory inv = new Inventory();
		for(int i=10; i<20; i++){
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
						countCBnoOnion++;
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
		

	}

}
