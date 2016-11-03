package clearentTest.Owners;

import java.util.ArrayList;
import clearentTest.Cards.*;
import clearentTest.Wallets.*;

public class Owner {

	private String name;
	private ArrayList<Wallet> wallets;
	
	public Owner(String name){
		this.name = name;
		this.wallets = new ArrayList<Wallet>();
	}
	
	public String getName(){
		return this.name;
	}
	
	public void addWallet(Wallet wallet){
		this.wallets.add(wallet);
	}
	
	public ArrayList<Wallet> getWallets(){
		return this.wallets;
	}
	
	public String toString(){
		String walletlist = "";
		if (this.wallets.size()!=0){
			for (int i=0; i<(this.wallets.size()-1); i++){							//creates a list of the wallet IDs
				walletlist = walletlist+this.wallets.get(i).getID()+", ";
			}
			walletlist=walletlist+this.wallets.get(this.wallets.size()).getID();	//last wallet ID separate for formating reasons
		}
		return "Owner: "+this.name+" Wallets owned: "+walletlist;
	}
	
	public double getBalance(){
		double ownerBalance = 0;
		if (wallets.size()!=0){
			for (int i=0; i<wallets.size(); i++){
				ownerBalance+=wallets.get(i).getBalance();							//calculates and adds the balance of each wallet
			}
		}
		return ownerBalance;
	}
	
	public double getInterest(){
		double ownerInterest = 0;
		if (wallets.size()!=0){
			for (int i=0; i<wallets.size(); i++){
				ownerInterest+=wallets.get(i).getInterest();						//adds up the total interest for the wallet
			}
		}
		return ownerInterest;
	}
}
