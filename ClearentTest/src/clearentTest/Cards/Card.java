package clearentTest.Cards;

public abstract class Card {

	protected String cardID;
	protected double rate;
	protected double balance;
	
	
	public String getID(){
		return this.cardID;
	}
	
	public double getRate(){
		return this.rate;													//returns the interest rate for the card
	}
	
	public double getBalance(){
		return this.balance;												//returns the current balance on the card
	}
	
	public double getInterest(){
		return Math.round((this.balance*this.rate)*100/100);				//returns the interest for the card
	}
	
	public double newBalance(){
		this.balance+=this.getInterest();									//calculates the new balance based on the interest
		return this.balance;
	}
	
	public String toString(){
		return "CardID: "+this.cardID+" Interest rate: "+this.rate+" Balance: "+this.balance;
	}
}
