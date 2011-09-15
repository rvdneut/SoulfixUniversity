package Concurrency.Opdracht1.Hoofdopdracht;

public class Kraker implements Runnable {

	private int currentNumber;
	private int m;
	private Counter counter;
	
	public Kraker(int m, Counter counter) {
		this.currentNumber = counter.getAndIncrement();
		this.m = m;
		this.counter = counter;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!counter.isDone()) {
			if(doorstaatmproef()){
				counter.numberFound();
				System.out.println(currentNumber + " doorstaat de "+ m + "-proef!");
			}
			currentNumber = counter.getAndIncrement();
		}
	} 
	
	public boolean doorstaatmproef() {
		int som = 0;
		int factor = 1;
		int tempNumber = currentNumber;
		while(tempNumber != 0) {
			int cijfer = tempNumber%10;
			tempNumber /= 10;
			som += cijfer*factor++;
		}
		return (som % m == 0);
	}

}
