package TP2;

import java.io.*;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.lang.String;

public class Main {

	public static void main(String[] args) {

		Affichage TA = new Affichage("AAA\n");
		Affichage TB = new Affichage("BB\n");

		TB.start();
		TA.start();
	}

}
