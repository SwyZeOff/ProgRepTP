package TP3;

public class BAL {
	private String message;
	private Boolean available = false;

	public synchronized void getMail() {
		while(available==false) {
			try {wait();}
			catch(InterruptedException e) {};
		}
		System.out.println(message);
		available=false;
		notifyAll();
	}
	
	public synchronized void setMail(String m) {
		while(available==true) {
			try {wait();}
			catch(InterruptedException e) {};
		}
		message = m;
		available = true;
		notifyAll();
	}
}
