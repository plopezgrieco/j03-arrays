package teoria;

public class Array02 {

//	public static double media(double n1, double n2) {
//		System.out.println("2 param");
//		return (n1 + n2) / 2;
//	}
//	
//	public static double media(double n1, double n2, double n3) {
//		System.out.println("3 param");
//		return (n1 + n2 + n3) / 3;
//	}
	
	public static double media(double... nums) {
		System.out.println("array param");
		double suma = 0;
		for (int i = 0; i < nums.length; i++) {
			suma += nums[i];
		}
		return suma / nums.length;
	}
	
	
	public static void main(String[] args) {
		System.out.println(media(7));
		System.out.println(media(10.5, 7));
		System.out.println(media(10.5, 7, 9));
		
		System.out.println(media(new double[] {10.5, 7, 9, 4.6}));
		
		double[] numeritos = {1,5,98,5.9, 32};
		System.out.println(media(numeritos));
		
	}
}
