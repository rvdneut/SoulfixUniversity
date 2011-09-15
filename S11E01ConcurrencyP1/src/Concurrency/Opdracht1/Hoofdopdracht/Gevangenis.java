package Concurrency.Opdracht1.Hoofdopdracht;

public class Gevangenis {
	
	private static Counter counter;
	private static Thread[] krakers;
	public static void main(String [] args) {
		int l = 0;
		int b = 1;
		int e = 100;
		int m = 11;
		int p = 4;
		krakers = new Thread[p];
		hack(l, b, e, m, p);
	}
	
	public static int hack(int l, int b, int e, int m, int p) {
		counter = new Counter(l,b,e);
		
		for (int i = 0; i < krakers.length; i++) {
			krakers[i] = new Thread(new Kraker(m, counter));
			krakers[i].start();
		}
		while(!counter.isDone()) {}
		System.out.print("Tussen de " + b + " en de " + e + " zijn er " +  counter.giveNumberOfPossibleNumbers() + " getallen die voldoen aan de " + m + "-proef");
		
		return 0;
	}
}
