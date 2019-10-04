public class DeckTest {
	public static void main(String args[]) {
		Deck dingie = new Deck();
   		dingie.cards[3] = 3;
   		Deck pilates = new Deck();
   		pilates.cards[1] = 2;
   		dingie.print();
   		pilates.print();
   		int[] newArrWhoDis = {2, 2, 4, 1, 3};
   		dingie.cards = pilates.cards;
   		pilates.cards = newArrWhoDis;
   		newArrWhoDis = null;
   		dingie.print();
   		pilates.print();
	}
}