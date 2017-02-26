package edu.cpp.cs240.lab3;

import java.util.Random;

public class Inventory{
	
	private ArrayStack<Bun> buns;
	private ArrayStack<Patty> patties;
	private ArrayStack<Cheese> cheese;
	private ArrayStack<Onion> onions;
	private ArrayStack<Lettuce> lettuce;
	private ArrayStack<Tomato> tomatoes;
	
	public Inventory(){
		this.buns = new ArrayStack<Bun>();
		this.patties = new ArrayStack<Patty>();
		this.cheese = new ArrayStack<Cheese>();
		this.onions = new ArrayStack<Onion>();
		this.lettuce = new ArrayStack<Lettuce>();
		this.tomatoes = new ArrayStack<Tomato>();
	}
	public boolean makeBurger(){
		if( buns.isEmpty() || patties.isEmpty() || tomatoes.isEmpty() 
			|| onions.isEmpty() || lettuce.isEmpty()){
			return false;
		} else {
			buns.pop();
			patties.pop();
			cheese.pop();
			onions.pop();
			lettuce.pop();
			tomatoes.pop();
		}
		return true;
	}
	public boolean makeCheeseBurger(){
		if(cheese.isEmpty() || buns.isEmpty() || patties.isEmpty()
			|| lettuce.isEmpty() || tomatoes.isEmpty() || onions.isEmpty()){
			return false;
		} else {
			cheese.pop();
			buns.pop();
			patties.pop();
			lettuce.pop();
			tomatoes.pop();
			onions.pop();
		}
		return true;
	}
	public boolean makeVeganBurger(){
		if(lettuce.size() < 2 || tomatoes.isEmpty() || onions.isEmpty()){
			return false;
		} else {
			lettuce.pop();
			lettuce.pop();
			tomatoes.pop();
			onions.pop();
		}
		return true;
	}
	public boolean makeNoOnionBurger(){
		if(buns.isEmpty() || patties.isEmpty() || lettuce.isEmpty()
			|| tomatoes.isEmpty()){
			return false;
		} else {
			buns.pop();
			patties.pop();
			lettuce.pop();
			tomatoes.pop();
		}
		return true;
	}
	public boolean makeNoOnionCheeseBurger(){
		if(cheese.isEmpty() || buns.isEmpty() || patties.isEmpty()
			|| lettuce.isEmpty() || tomatoes.isEmpty()){
			return false;
		} else {
			cheese.pop();
			buns.pop();
			patties.pop();
			lettuce.pop();
			tomatoes.pop();
		}
		return true;
	}
	public boolean makeBurgerNoTomato(){
		if(buns.isEmpty() || patties.isEmpty() || lettuce.isEmpty()
				|| onions.isEmpty()){
			return false;
		} else {
			buns.pop();
			patties.pop();
			lettuce.pop();
			onions.pop();
		}
		return true;
	}
	public void receiveShipment(int deliveryDate){
		Random rand = new Random();
		int numBuns = rand.nextInt(301)+700;
		for (int i = 0; i < numBuns; i++){
			Bun b = new Bun();
			b.setExpirationDate( deliveryDate + 5);
			buns.push(b);
		}
		int numCheese = rand.nextInt(301)+700;
		for (int i = 0; i < numCheese; i++){
			Cheese c = new Cheese();
			c.setExpirationDate( deliveryDate + 2);
			cheese.push(c);
		}
		int numLettuce = rand.nextInt(301)+700;
		for (int i = 0; i < numLettuce; i++){
			Lettuce l = new Lettuce();
			l.setExpirationDate( deliveryDate + 3);
			lettuce.push(l);
		}
		int numOnion = rand.nextInt(301)+700;
		for (int i = 0; i < numOnion; i++){
			Onion o = new Onion();
			o.setExpirationDate( deliveryDate + 5);
			onions.push(o);
		}
		int numPatty = rand.nextInt(301)+700;
		for (int i = 0; i < numPatty; i++){
			Patty p = new Patty();
			p.setExpirationDate( deliveryDate + 4);
			patties.push(p);
		}
		int numTomatoes= rand.nextInt(301)+700;
		for (int i = 0; i < numTomatoes; i++){
			Tomato t = new Tomato();
			t.setExpirationDate( deliveryDate + 3);
			tomatoes.push(t);
		}
	}
	
	public void sortInventory( int currentDate){
		FoodItem[] bunArray = new Bun[buns.size()];
		for ( int i = 0; i < bunArray.length; i++){
			bunArray[i] = buns.pop();
		}
		selectionFoodSort( bunArray );
		for ( int i = 0; i < bunArray.length; i++){
			Bun b = (Bun)bunArray[i];
			if( currentDate < b.getExpirationDate() ){
				buns.push(b);
			}
		}
		
	}
	
	public void selectionFoodSort( FoodItem[] items) {

		for (int i = 0; i < items.length - 1; ++i) {
			int minIndex = i;

			for (int j = i + 1; j < items.length; ++j) {
				if ( items[j].getExpirationDate() < items[minIndex].getExpirationDate() )
					minIndex = j;
			}

			swap(items, minIndex, i);
		}
	}
	private void swap(FoodItem[] items, int i, int j) {
		FoodItem temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}

}
