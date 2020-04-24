package TP3;

public class main {
	
	public static void main(String[] args) {
		
		BAL baba = new BAL();
		Producteur produ = new Producteur(baba, "Baguette");
		Producteur produ2 = new Producteur(baba, "Pain au chocolat");

		Consommateur conso = new Consommateur(baba, "");
		produ2.start();
		produ.start();
		conso.start();
		
		
		
	}

}
