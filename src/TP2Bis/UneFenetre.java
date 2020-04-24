package TP2Bis;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

class UneFenetre extends JFrame {
    

	List<Thread> threadList;
	List<UnMobile> listMobiles;
	
	semaphoreGeneral sem;
    
    private final int LARG=400, HAUT=400;
    
    public UneFenetre(int telNbMobiles, int telNbRessources) {
		super("Le Mobile");
		setSize(LARG, HAUT);
		setVisible(true);
		setResizable(true);

		
	    final int nbMobiles = telNbMobiles;

		
		setBackground(new Color(45,45,225));
		
		Container leConteneur = getContentPane();
		leConteneur.setLayout (new GridLayout(nbMobiles, 1));
		
		threadList = new ArrayList<Thread>();
		listMobiles = new ArrayList<UnMobile>();

		sem = new semaphoreGeneral(telNbRessources);
		
		for(int i = 0; i < nbMobiles; i++) {
			listMobiles.add(new UnMobile(LARG, HAUT/nbMobiles, 100, sem));
			threadList.add(new Thread(listMobiles.get(i)));
			threadList.get(i).start();
			leConteneur.add(listMobiles.get(i));

			
		}
		
    }


}
