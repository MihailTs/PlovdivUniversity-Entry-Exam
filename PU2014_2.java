import java.util.Scanner;

public class PU2014_2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int [] arr = new int[33];
		
		for (int i = 0; i < 33; i++) {
			System.out.printf("Type %d: ", i+1);
			arr[i] = sc.nextInt();
			sc.nextLine();
		}
		
		
		
		double perc = sc.nextDouble();
		if(arr[percentToType(perc)-1] != 0) System.out.println(percentToType(perc));
		else System.out.println("No such type today!");
		
		boolean b = true;
		for (int i = 0; i < 33; i++) {
			if(arr[i] != 0 && i != 9) {b = false; break;}
		}
		
		if(b) {
			double total = arr[9]*(0.3 + (23)*0.02);
			System.out.printf("%.2f", total);				
		}
				
	}
	
	
	//0.2*i+2
	public static int percentToType(double t) {
		return (int)((t-2)*5);	
	}
	
	
}
