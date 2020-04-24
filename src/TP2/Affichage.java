package TP2;

/**
 * 
 */
import java.io.*;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.lang.String;


//class Exclusion{};



public class Affichage extends Thread{
	
	String texte;
	
	//static Exclusion exclusionMutuelle = new Exclusion();
	static semaphoreBinaire sem = new semaphoreBinaire(246546);

	public Affichage (String txt){texte=txt;}
	
	public void run(){
		
		/*
		synchronized(exclu) { 
			for (int i=0; i<texte.length(); i++){
			    System.out.print(texte.charAt(i));
			    try {sleep(100);} catch(InterruptedException e){};
			}
		
		}*/
		
		sem.syncWait();
		System.out.println("J'entre dans la section critique.");
		for (int i=0; i<texte.length(); i++){
		    System.out.print(texte.charAt(i));
		    try {sleep(100);} catch(InterruptedException e){};
		}
		System.out.println("Je sors de la section critique.\n");
		sem.syncSignal();
		
		
		
		

	}
}
