package mastermind;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Deroulement {


	public Deroulement() {};


	public void lancementPartie() {
		int coup=1, malplace=0, bienplace=0;
		Combinaison c = new Combinaison();
		ArrayList<Integer> pion = c.getPion();
		
		do {
			malplace = 0;
			bienplace=0;
			System.out.println("Coup numero: " + coup + "\n" + "Ecrire combinaison");
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
		} while ( coup != 11 && bienplace != 4);
		if ( coup == 11) {
			System.out.println("Vous avez perdu!");
		}
			
		if (bienplace == 4) {
			System.out.println("Vous avez trouver la bonne combinaison, bien joué!");
		}
		
	}
	

}