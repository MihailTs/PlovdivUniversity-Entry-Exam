import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class PU2016_2 {

	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Song> songs = new ArrayList<Song>();
	
	public static void main(String[] args) {

		part1();
		//part2();
		//part3();
		part4();
		
	}
	
	public static void part1() {
		int c = sc.nextInt();
		
		for(int i = 0; i < c; i++) 	
			songs.add(new Song(sc));
	}
	
	public static void part2() {
		
		songs.sort(new sort1());
		for (Song song : songs) 
			System.out.println(song);
	}

	public static void part3() {
		ArrayList<Song> rock = new ArrayList<Song>();
		for (Song song : songs) 
			if(song.isRock() && song.getYear() > 2000) rock.add(song);
		
		rock.sort(new sort2());
		
		for (Song song : rock) 
			System.out.println(song);
		
	}
	
	public static void part4() {
		
		String name = "";
		int max = -1;
		
		for (Song song : songs) {
			if(song.getCount() > max) {
				max = song.getCount();
				name = song.getSinger();
			}
		}
		
		for (Song song : songs) {
			if(song.getSinger().equals(name))
				System.out.println(song);
		}
		
	}
	
}


class Song{
	
	private String name;
	private int style;
	private String singer;
	private int year;
	private String album;
	private int count;
	
	public Song(Scanner sc) {
		
		System.out.print("Song name: ");
		sc.nextLine();
		name = sc.nextLine();
		System.out.print("Style: ");
		style = sc.nextInt();
		sc.nextLine();
		System.out.print("Singer: ");
		singer = sc.nextLine();
		System.out.print("Year: ");
		year = sc.nextInt();
		sc.nextLine();
		System.out.print("Album: ");
		album = sc.nextLine();
		System.out.print("Count: ");
		count = sc.nextInt();
		
		System.out.println();
	}
	
	public String toString() {
		
		String s = name + "; " + style + "; " + singer + "; " +
				   year + "; " + album + "; " + count;			   
		return s;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isRock() {
		return style == 3;
	}
	
	public int getYear() {
		return year;
	}

	public String getSinger() {
		return singer;
	}

	public int getCount() {
		return count;
	}
}

class sort1 implements Comparator<Song>{
	public int compare(Song o1, Song o2) {
		if(o1.getName().compareTo(o2.getName()) > 0) return 1;
		return -1;
	}
}

class sort2 implements Comparator<Song>{
	public int compare(Song o1, Song o2) {
		if(o1.getSinger().compareTo(o2.getSinger()) > 0) return 1;
		if(o1.getSinger().compareTo(o2.getSinger()) < 0) return -1;
		return yearSort(o1, o2);
	}
	
	private int yearSort(Song o1, Song o2) {
		if(o1.getYear() > o2.getYear()) return 1;
		return -1;
	}

}




