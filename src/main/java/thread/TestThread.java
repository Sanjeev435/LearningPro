package thread;

public class TestThread {
	public static void main(String[] args) {
		Counter counter1 = new Counter();
		Thread worker = new Thread(counter1, "Counter1");
		System.out.println(worker);
		worker.start();

		try {
			int val;
			do {
				val = counter1.getValue();
				System.out.println("Counter Value read by"
						+ Thread.currentThread().getName() + ":" + val);
				Thread.sleep(1000);
			} while (val < 5);
		} catch (InterruptedException e) {
			System.out.println("The Main Thread is interrupted.");
		}
		System.out.println("Exit from main() method.");
	}

}

class Counter implements Runnable {
	private int currentValue;

	public Counter() {
		currentValue = 0;
	}

	public int getValue() {
		return this.currentValue;
	}

	public void run() {
		try {
			while (currentValue < 5) {
				System.out.println(Thread.currentThread().getName() + ":"
						+ (currentValue++));
				Thread.sleep(250);
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName());
		}
		System.out.println("Exit from Thread"
				+ Thread.currentThread().getName());
	}

}