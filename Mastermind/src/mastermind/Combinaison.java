package mastermind;

import java.util.ArrayList;
import java.util.Random;

public class Combinaison {
	
	private static ArrayList<Integer> pion = new ArrayList<>();
	
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
	
	  public ArrayList<Integer> getPion() {
		    return pion;
		  }
	
	
}
