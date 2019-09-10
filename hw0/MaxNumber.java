public class MaxNumber {
	public static int max(int[] m){
		int ans = m[0];
		for (int i = 1; i < m.length; i++){
			if (ans < m[i]){
				ans = m[i];
			}
		}
		return ans;
   	}

   	public static void main(String[] args) {
      	int[] numbers = new int[] {9, 2, 15, 2, 22, 10, 6};
      	System.out.println(max(numbers));      
   	}
}