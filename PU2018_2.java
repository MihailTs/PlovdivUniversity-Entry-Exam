import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class PU2018_2 {
	public static ArrayList<Material> materials = new ArrayList<Material>();

	public static void main(String[] args) throws FileNotFoundException {

		File f = new File("Materials.txt");
		Scanner sc = new Scanner(f);

		part1(sc);
		
		
		part2();

	}
	public static void part1(Scanner sc) {
		short c = sc.nextShort();
		for (int i = 0; i < c; i++) {
			if(c > 2000) break;
			Material s = new Material(sc);
			materials.add(s);
		}
	}

	public static void part2() {
		materials.sort(new comp1());
		for (Material material : materials) {
			System.out.println(material.toString());
		}
	}

	public static void part3() {
		materials.sort(new comp2());
		for (Material material : materials) {
			if(material.getGroup() == 'E')
				System.out.println(material.toString());
		}

	}

	public static void part4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Code: ");
		String code = sc.nextLine();
		for (Material mat : materials) {
			if(mat.getCode().equals(code)){
				if(mat.getGroup() == 'E') {System.out.println(mat.getName() + ", " + mat.getQuantity() + ", B%=" + mat.getHumidity()); continue;}
				System.out.println(mat.getName() + ", " + mat.getQuantity());
			}
		}
		
	}

}

class Material{

	private String code;
	private String name;
	private double quantity;
	private int expiry;
	private char group;
	private String date;
	private String position;

	private int humidity = -1;
	private int NumDate;

	Material(Scanner sc){
		sc.nextLine();
		code = sc.nextLine();
		name = sc.nextLine();
		quantity = sc.nextDouble();
		sc.nextLine();
		expiry = sc.nextInt();
		sc.nextLine();
		group = sc.next().charAt(0);
		sc.nextLine();
		date = sc.nextLine();
		NumDate = Integer.parseInt(date.substring(6, 10))*10000 + Integer.parseInt(date.substring(3, 5))*100 + Integer.parseInt(date.substring(0, 2)); 
		position = sc.nextLine();
		if(group == 'E') {humidity = sc.nextInt(); sc.nextLine();}
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public double getQuantity() {
		return quantity;
	}

	public int getExpiry() {
		return expiry;
	}

	public char getGroup() {
		return group;
	}

	public String getDate() {
		return date;
	}

	public int getNumDate() {
		return NumDate;
	}

	public String getPosition() {
		return position;
	}

	public int getHumidity() {
		return humidity;
	}
	
	public String toString() {
		if(group == 'S') return position + ", " + code + ", " + name + ", " + quantity + ", " + date + ", " + expiry;
		return position + ", " + code + ", " + name + ", " + quantity + ", " + date + ", " + expiry + ", B%=" + humidity;    
	}
}

class comp1 implements Comparator<Material>{

	public int compare(Material o1, Material o2) {
		return o1.getPosition().compareTo(o2.getPosition());
	}
}

class comp2 implements Comparator<Material>{

	public int compare(Material o1, Material o2) {
		if(o1.getNumDate() > o2.getNumDate()) return -1;
		if(o1.getNumDate() < o2.getNumDate()) return 1;
		if(o1.getNumDate() == o2.getNumDate()) {
			if(o1.getExpiry() > o2.getExpiry()) return -1;
			if(o1.getExpiry() < o2.getExpiry()) return 1;
		}
		return 0;
	}
}
