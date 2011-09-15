package Concurrency.Opdracht1.Locks;

import java.util.concurrent.atomic.AtomicBoolean;

public class TaSLock implements Lock {

	private AtomicBoolean state = new AtomicBoolean(false);
	@Override
	public void lock() {
		// TODO Auto-generated method stub
		while (state.getAndSet(true)) {}
	}

	@Override
	public void unlock() {
		// TODO Auto-generated method stub
		state.set(false);
	}

}
