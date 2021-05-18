package br.com.dio.parallel;

public class ThreadExample {
	public static void main(String[] args) {
		//new Process1().run();
		//new Process2().run();
		
		Thread t1 = new Thread(new Process1());
		Thread t2 = new Thread(new Process2());
		t1.start();
		t2.start();
		
	}
}

class Process1 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Runing process 1: " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
}

class Process2 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Runing process 2: " + i*10);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
}