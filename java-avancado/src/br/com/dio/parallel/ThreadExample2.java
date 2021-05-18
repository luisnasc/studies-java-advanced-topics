package br.com.dio.parallel;

public class ThreadExample2 {

	public static void main(String[] args) {
		CreatePDF createPDF = new CreatePDF();
		
		
		LoadingBar loading = new LoadingBar(createPDF);
		createPDF.start();
		loading.start();
	}

}

class CreatePDF extends Thread{
	@Override
	public void run() {
		
		try {
			Thread.sleep(5000);
			System.out.print("\nPDF generated sucessfully!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}

class LoadingBar extends Thread {
	
	private Thread loadPDF;
	
	public LoadingBar(Thread thread) {
		this.loadPDF = thread;
	}
	
	@Override
	public void run() {
		try {
			System.out.print("Loading");
			while(loadPDF.isAlive()) {
				System.out.print(".");
				Thread.sleep(200);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}