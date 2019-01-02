package mastermind;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jeu {
	public static ArrayList<Integer> pion = new ArrayList<>();
	
	public Jeu () {}
	

	public static int random() {
		Random r = new Random();
		int valeur = 1 + r.nextInt(7 - 1);
		return valeur;
	}
	
	public static void init_combinaison() {
		int valeur;
	
	pion.add(random());
	for (int i = 0; i < 3; i++) {
		if (pion.size() < 2) {
			do {
				valeur = random();
			} while (valeur == pion.get(0));
			pion.add(valeur);
		}
		if (pion.size() < 3) {	
			do {
				valeur = random();
			} while (valeur == pion.get(0) || valeur == pion.get(1));
		pion.add(valeur);
	}
		if (pion.size() < 4) {
			do {
				valeur = random();
			} while (valeur == pion.get(0) || valeur == pion.get(1) || valeur == pion.get(2));
		pion.add(valeur);
		}
	}
	
		System.out.println("Combinaison secrète:" + pion);
}
	
	public static void main(String[] args) {
		
		init_combinaison();
		int coup=0;
		int malplace=0;
		int bienplace=0;
		do {
			System.out.println("Ecrire combinaison");
			Scanner sc = new Scanner(System.in);
			int choix = sc.nextInt();
			Scanner sc2 = new Scanner(System.in);
			int choix2 = sc.nextInt();
			Scanner sc3 = new Scanner(System.in);
			int choix3 = sc.nextInt();
			Scanner sc4 = new Scanner(System.in);
			int choix4 = sc.nextInt();
			ArrayList<Integer> combinaison = new ArrayList<>();
			combinaison.add(choix);
			combinaison.add(choix2);
			combinaison.add(choix3);
			combinaison.add(choix4);
			System.out.println("Combinaison:" + combinaison);
			

			for (int i = 0; i < 4; i++) {
				if (pion.contains(combinaison.get(i))) {
					malplace++;
					if (combinaison.get(i) == pion.get(i)) {
						malplace--;
						bienplace++;
					}
				}
			}
			System.out.println("(" + malplace + "," + bienplace + ")");	
			coup++;
		} while ( coup != 10 || bienplace != 4);
		if ( coup == 10) {
			System.out.println("Vous avez perdu!");
		}
			
		if (bienplace == 4) {
			System.out.println("Vous avez trouver la bonne combinaison, bien joué!");
		}
		
	}
}
