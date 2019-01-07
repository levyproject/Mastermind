package controleur;

import vue.FrmJeu;

public class Controle {
	
	//propriétés
	private FrmJeu frmJeu;

	public static void main(String[] args) {
		new Controle();
	}
	
	public Controle() {
		frmJeu = new FrmJeu(this);
		frmJeu.setVisible(true);
	}

}
