package TP2Bis;
import java.awt.*;
import javax.swing.*;

class UnMobile extends JPanel implements Runnable {
	
	
	semaphoreGeneral sem;
    int largeur, hauteur, debutDessin, saVitesse;
    final int sonPas = 10, sonCote=40;
    Color col;
     
    
    UnMobile(int telleLargeur, int telleHauteur, int telleVitesse, semaphoreGeneral telSem) {
		super();
		largeur = telleLargeur;
		hauteur = telleHauteur;
		saVitesse=telleVitesse;
		sem = telSem;
		setSize(telleLargeur, telleHauteur);

    }

    public void run() {
    	while(true) {
    		
    		
    		int debutSecCrit = (largeur/3);
    		int finSecCrit = 2*(largeur/3);
    		
    		for (debutDessin=0; debutDessin < debutSecCrit; debutDessin+= sonPas) {
    			col = Color.red;
    			repaint();
    			try{Thread.sleep(saVitesse);}
    			catch (InterruptedException telleExcp)
    			    {telleExcp.printStackTrace();}
    		    }
    		
    		sem.syncWait();
    		for (; debutDessin<finSecCrit; debutDessin+=sonPas) {
    			col = Color.black;
    			repaint();
    			try{Thread.sleep(saVitesse);}
    			catch (InterruptedException telleExcp)
    			    {telleExcp.printStackTrace();}
    		    }
    		sem.syncSignal();
    		
    		for (;debutDessin < largeur; debutDessin+= sonPas) {
    			col = Color.red;
    			repaint();
    			try{Thread.sleep(saVitesse);}
    			catch (InterruptedException telleExcp)
    			    {telleExcp.printStackTrace();}
    		    }
    		
    		
    	}
		
    }

    public void paintComponent(Graphics telCG){
    	telCG.setColor(col);
		super.paintComponent(telCG);
		telCG.fillRect(debutDessin, hauteur/2, sonCote, sonCote);
    }
}