public class Triangle_b{
    public static void main(String[] args){
    	drawTriangle(10);
    }

    public static void drawTriangle(int N){
    	int row = 1;
    	while (row <= N){
    		for (int i = 1; i <= row; i++){
    			System.out.print("*");
    		}
    		row += 1;
    		System.out.println();

    	}
    }
}