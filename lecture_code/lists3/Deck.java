public class Deck {
     public static int[] cards;

     public Deck() {
         cards = new int[]{1, 3, 4, 10};
     }

     public void print() {
     	int leng = cards.length;
     	for (int i = 0; i < leng; ++i) {
     		System.out.print(cards[i]);
     		System.out.println();
     	}
     	System.out.println();
     }	
 }