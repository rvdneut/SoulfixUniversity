package Concurrency.Opdracht1.Hoofdopdracht;


import Concurrency.Opdracht1.Locks.ArrayLock;
import Concurrency.Opdracht1.Locks.Lock;
import Concurrency.Opdracht1.Locks.TaSLock;
import Concurrency.Opdracht1.Locks.TaSSLock;

public class Counter {
	int currentNumber;
	int numberOfPossibleNumbers;
	int upperbound;
	Lock lock;
	
	
	public Counter(int l, int b, int e) {
		int upperbound = e;
		switch(l) {
		case 0:
			lock = new TaSLock();
			break;
		case 1:
			lock = new TaSSLock();
			break;
		case 2:
			lock = new ArrayLock(e-b+1);
			break;
		default:
			lock = new TaSLock();
		}
		
		currentNumber = b;
		numberOfPossibleNumbers = 0;
	}
	
	public boolean isDone(){
		return (currentNumber == upperbound);
	}
	
	public int getAndIncrement() {
		lock.lock();
		int temp = currentNumber;
		currentNumber++;
		lock.unlock();
		return temp;
	}
	
	public void numberFound() {
		lock.lock();
		numberOfPossibleNumbers++;
		lock.unlock();
	}
}
