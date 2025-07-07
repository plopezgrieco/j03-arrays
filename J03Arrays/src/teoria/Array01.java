package teoria;

public class Array01 {
	public static void main(String[] args) {
		
		int[] nums = {1, 17, -98, 3};
		
		System.out.println(nums[2]);
		
//		System.out.println(nums);
		
		muestra(nums);
	}
	
	public static void muestra(int[] m) {
		for (int i = 0; i < m.length; i++) {
			System.out.print(m[i] + " ");
		}
		System.out.println();
	}
}
