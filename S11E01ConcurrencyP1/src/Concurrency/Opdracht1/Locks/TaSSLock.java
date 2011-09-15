package Concurrency.Opdracht1.Locks;

import java.util.concurrent.atomic.AtomicBoolean;

public class TaSSLock implements Lock {

	private AtomicBoolean state = new AtomicBoolean(false);
	@Override
	public void lock() {
		// TODO Auto-generated method stub
		while(true) {
			while(state.get()) {}
			if(!state.getAndSet(true))
				return;
		}
	}

	@Override
	public void unlock() {
		// TODO Auto-generated method stub
		state.set(false);
	}

}
