package TP3;

public class Consommateur extends Thread {
	private BAL bal;
	private String message;
	
	public Consommateur(BAL c, String m) {
		this.bal = c;
		this.message = m;
	}
	
	public void run() {
		String m = "";
		for (int i=0; i<100; i++) {
			System.out.println("Conso " + i);
			bal.getMail();
			try {sleep(1000);}
			catch(InterruptedException e) {};
		}
	}
}
