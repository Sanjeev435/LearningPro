package thread;

public class Implementer implements Runnable {

	public static void main(String[] args) {

		new Extender(new Implementer()).start();
		new Extender().start();
		new Thread(new Implementer()).start();
	}

	public void run() {
		System.out.println("|Implementer|");
	}
}

class Extender extends Thread {
	// Default Constructor
	public Extender() {
	}

	// argumented constructor
	public Extender(Runnable runnable) {
		super(runnable);
	}

	public void run() {
		System.out.println("|Extender|");
	}
}

/*
 * |Extender|2 times |Implementer|
 */

