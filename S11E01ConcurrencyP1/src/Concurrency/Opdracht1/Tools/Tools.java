package Concurrency.Opdracht1.Tools;

public class Tools {

	public static void main(String [] args) {
		System.out.println(doorstaatmproef(274856190, 11));
	}
	
	public static boolean doorstaatmproef(int getal, int m) {
		int som = 0;
		int factor = 1;
		System.out.println("Initieel getal: " + getal);
		while(getal != 0) {
			int cijfer = getal%10;
			getal /= 10;
			som += cijfer*factor++;
		}
		System.out.println("Som: " + som);
		System.out.println("Is " + som + " deelbaar door " + m+"?");
		return (som % m == 0);
	}
}
