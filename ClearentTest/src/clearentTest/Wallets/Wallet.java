package clearentTest.Wallets;

import clearentTest.Cards.*;
import java.util.ArrayList;

public class Wallet {

	protected String WalletID;
	protected String Owner;
	protected ArrayList<Card> cards;
	
	public Wallet(String WalletID, String Owner){
		this.WalletID = WalletID;
		this.Owner = Owner;
		this.cards = new ArrayList<Card>();
	}
	
	public String getID(){
		return this.WalletID;
	}
	
	public String getOwner(){
		return this.Owner;
	}
	
	public ArrayList<Card> getCards(){
		return this.cards;
	}
	
	public void addCard(Card card){
		this.cards.add(card);
	}
	
	public String toString(){
		String cardlist = "";
		if (this.cards.size()!=0){
			for (int i=0; i<(this.cards.size()-1); i++){					//creates a list of the card IDs
				cardlist = cardlist+this.cards.get(i).getID()+", ";
			}
			cardlist=cardlist+this.cards.get(this.cards.size()).getID();	//last card ID separate for formating reasons
		}
		return "WalletID: "+this.WalletID+" Owned by: "+this.Owner+" Contains Cards: "+cardlist;
	}
	
	public double getBalance(){
		double walletBalance = 0;
		if (this.cards.size()!=0){
			for (int i=0; i<this.cards.size(); i++){
				walletBalance+=this.cards.get(i).getBalance();				//calculates and adds the balance of each card
			}
		}
		return walletBalance;
	}
	
	public double getInterest(){
		double walletInterest = 0;
		if (this.cards.size()!=0){
			for (int i=0; i<this.cards.size(); i++){
				walletInterest+=this.cards.get(i).getInterest(); 		//calculates and adds the interest of each card
			}
		}
		return walletInterest;
	}
	
	public double getNewBalance(){
		double walletNewBalance = 0;
		if (this.cards.size()!=0){
			for (int i=0; i<this.cards.size(); i++){
				walletNewBalance+=this.cards.get(i).newBalance();			//calculates and adds the new balance of each card
			}
		}
		return walletNewBalance;
	}
}
