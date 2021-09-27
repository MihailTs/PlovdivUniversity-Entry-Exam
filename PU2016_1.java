import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class PU2016_1 {

	static ArrayList<Student> students = new ArrayList<Student>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in, "UTF-8");
		
		task1(sc, students);
		System.out.println();
		task2(students);
		
		
	}
	
	public static void task1(Scanner sc, ArrayList<Student> students) {
		System.out.print("Брой ученици: ");
		int stNum = sc.nextInt();
		
		for (int i = 0; i < stNum; i++) {
			sc.nextLine();
			String name = sc.nextLine();
			
			String spec = sc.nextLine();
			
			int grade = sc.nextInt(); sc.nextLine();
			
			String form = sc.next();
			students.add(new Student(name, spec, grade, form));
			
		}
	}
	
	public static void task2(ArrayList<Student> students) {
		students.sort(new cmp1());
		for (Student student : students) 
			System.out.println(student);
	}
}


class Student{
	
	private String name;
	private String spec;
	private int grade;
	private String form;
	
	Student(String n, String sp, int gr, String f){
		name = n;
		spec = sp;
		grade = gr;
		form = f;
	}
	
	public String toString() {
		return name + "; " + spec + "; " + form + "; " + grade*6;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSpec() {
		return spec;
	}
	
	public String getForm() {
		return form;
	}
	
	public int getGrade() {
		return grade;
	}
}

class cmp1 implements Comparator<Student>{
	public int compare(Student o1, Student o2) {
		if(o1.getSpec().compareTo(o2.getSpec()) > 0) 
			return 1;
		else if(o1.getSpec().compareTo(o2.getSpec()) < 0)
			return -1;
		else return (o1.getGrade() >= o2.getGrade())? -1: 1;
	}
}

class cmp2 implements Comparator<Student>{
	public int compare(Student o1, Student o2) {
		return o1.getName().compareTo(o2.getName());
	}
}
