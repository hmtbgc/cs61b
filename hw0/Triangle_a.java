public class Triangle_a{
	public static void main(String[] args){
		int row = 1;
		while (row <= 5){
			for (int i = 1; i <= row; i++){
				System.out.print("*");
			}
			row += 1;
			System.out.println();
		}
	}
}