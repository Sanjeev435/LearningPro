package thread;

public class TestThread1 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		System.out.println("Method Main runs in thread " + " : "
				+ Thread.currentThread().getName());
		Counter1 counter1 = new Counter1("Counter1");
		Counter1 counter2 = new Counter1("Counter2");

		System.out.println("Exit from main() thread.");
	}
}

class Counter1 extends Thread {
	private int currentValue;

	public Counter1(String threadName) {
		super(threadName);
		currentValue = 0;
		System.out.println(this);
		setDaemon(true);
		start();
	}

	public int getValue() {
		return currentValue;
	}

	public void run() {
		try {
			while (currentValue < 5) {
				System.out.println(getName() + ":" + (currentValue++));
				Thread.sleep(200);
			}
		} catch (InterruptedException e) {
			System.out.println(getName() + " Interrepted");
		}
		System.out.println("Exit from thread" + getName());
	}
}

/**
 * Output
 * 
 * **************Without Daemon*************
 * 
 * Method Main runs in thread : main 
 * Thread[Counter1,5,main]
 * Thread[Counter2,5,main] 
 * Exit from main() thread. 
 * Counter2:0 
 * Counter1:0
 * Counter1:1 
 * Counter2:1 
 * Counter1:2 
 * Counter2:2 
 * Counter1:3 
 * Counter2:3 
 * Counter1:4
 * Counter2:4 
 * Exit from threadCounter1 
 * Exit from threadCounter2
 * 
 * 
 **************With Daemon*************
 * 
 * Method Main runs in thread  : main
 * Thread[Counter1,5,main]
 * Thread[Counter2,5,main]
 * Counter1:0
 * Exit from main() thread.
 * Counter2:0
 */
