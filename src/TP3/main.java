package TP3;

public class main {
	
	public static void main(String[] args) {
		
		BAL baba = new BAL();
		Producteur produ = new Producteur(baba, "titi");
		Consommateur conso = new Consommateur(baba, "");
		
		produ.start();
		conso.start();
		
		
		
	}

}
