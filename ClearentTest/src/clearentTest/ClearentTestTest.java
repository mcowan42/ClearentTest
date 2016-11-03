package clearentTest;

import static org.junit.Assert.*;

import org.junit.Test;
import clearentTest.Cards.*;
import clearentTest.Wallets.*;
import clearentTest.Owners.*;

public class ClearentTestTest {

	@Test
	public void testCase1(){
		Owner owner1 = new Owner("Steve Jobs");
		Wallet wallet1 = new Wallet(owner1.getName()+"'s wallet1", owner1.getName());
		Card Card1 = new Visa("Visa1", 100);
		Card Card2 = new Master("Master1", 100);
		Card Card3 = new Discover("Discover1", 100);
		wallet1.addCard(Card1);
		wallet1.addCard(Card2);
		wallet1.addCard(Card3);
		owner1.addWallet(wallet1);
		
		assertEquals(10.00, owner1.getWallets().get(0).getCards().get(0).getInterest(), 0.01);	//interest on card1
		assertEquals(5.00, owner1.getWallets().get(0).getCards().get(1).getInterest(), 0.01);	//interest on card2
		assertEquals(1.00, owner1.getWallets().get(0).getCards().get(2).getInterest(), 0.01);	//interest on card3
		assertEquals(16.00, owner1.getInterest(), 0.01);										//total interest for this person
	}
	
	@Test
	public void testCase2(){
		Owner owner2 = new Owner("Mark Zuckerberg");
		Wallet wallet1 = new Wallet(owner2.getName()+"'s wallet1", owner2.getName());
		Wallet wallet2 = new Wallet(owner2.getName()+"'s wallet2", owner2.getName());
		Card Card11 = new Visa("Visa1", 100);
		Card Card12 = new Discover("Discover1", 100);
		Card Card21 = new Master("Master1", 100);
		wallet1.addCard(Card11);
		wallet1.addCard(Card12);
		wallet2.addCard(Card21);
		owner2.addWallet(wallet1);
		owner2.addWallet(wallet2);
		
		assertEquals(16.00, owner2.getInterest(), 0.01);									//total interest for this person
		assertEquals(11.00, owner2.getWallets().get(0).getInterest(), 0.01);				//total interest for wallet1
		assertEquals(5.00, owner2.getWallets().get(1).getInterest(), 0.01);					//total interest for wallet2
	}

	@Test
	public void testCase3(){
		Owner owner3 = new Owner("Hillary Clinton");
		Wallet wallet31 = new Wallet(owner3.getName()+"'s wallet1", owner3.getName());
		Card Card31 = new Master("Master31", 100);
		Card Card32 = new Master("Master32", 100);
		owner3.addWallet(wallet31);
		owner3.getWallets().get(0).addCard(Card31);
		owner3.getWallets().get(0).addCard(Card32);
		
		Owner owner4 = new Owner("Donald Trump");
		Wallet wallet41 = new Wallet(owner4.getName()+"'s wallet1", owner4.getName());
		Card Card41 = new Visa("Visa41", 100);
		Card Card42 = new Master("Master42", 100);
		owner4.addWallet(wallet41);
		owner4.getWallets().get(0).addCard(Card41);
		owner4.getWallets().get(0).addCard(Card42);
		
		assertEquals(10.00, owner3.getInterest(), 0.01);									//total interest for this person
		assertEquals(10.00, owner3.getWallets().get(0).getInterest(), 0.01);				//total interest for this wallet
		
		assertEquals(15.00, owner4.getInterest(), 0.01);									//total interest for this person
		assertEquals(15.00, owner4.getWallets().get(0).getInterest(), 0.01);				//total interest for this wallet
	}
}
