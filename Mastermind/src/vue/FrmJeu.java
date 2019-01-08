package vue;

import mastermind.Jeu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Controle;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;

public class FrmJeu extends JFrame {

	/**
	 * propriétés
	 */
	
	private JPanel contentPane;
	private Controle controle;
	public int coup = 1;
	public  ArrayList<JComboBox> jComboList = new ArrayList<>();
	public  ArrayList<JLabel> jColonnes = new ArrayList<>();
	public static ArrayList<Integer> pion = new ArrayList<>();

	
	/**
	 * Create the frame.
	 */
	public FrmJeu(Controle controle) {
		this.controle = controle;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titreJeu = new JLabel("Mastermind");
		titreJeu.setForeground(new Color(75, 0, 130));
		titreJeu.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
		titreJeu.setBounds(187, -16, 170, 87);
		contentPane.add(titreJeu);
		

		/**
		 * Création et placement des pions de chaque couleur.
		 */
		JButton pionBleu = new JButton("");
		Image cercleBleu = new ImageIcon(this.getClass().getResource("/cercle bleu.jpg")).getImage();
		pionBleu.setIcon(new ImageIcon(cercleBleu));
		pionBleu.setBounds(222, 518, 35, 33);
		contentPane.add(pionBleu);
		
		JButton pionNoir = new JButton("");
		Image cercleNoir = new ImageIcon(this.getClass().getResource("/cercle noir.jpg")).getImage();
		pionNoir.setIcon(new ImageIcon(cercleNoir));
		pionNoir.setBounds(132, 518, 35, 33);
		contentPane.add(pionNoir);
		
		JButton pionRouge = new JButton("");
		Image cercleRouge = new ImageIcon(this.getClass().getResource("/cercle rouge.jpg")).getImage();
		pionRouge.setIcon(new ImageIcon(cercleRouge));
		pionRouge.setBounds(177, 518, 35, 33);
		contentPane.add(pionRouge);
		
		JButton pionVert = new JButton("");
		Image cercleVert = new ImageIcon(this.getClass().getResource("/cercle vert.jpg")).getImage();
		pionVert.setIcon(new ImageIcon(cercleVert));
		pionVert.setBounds(267, 518, 35, 33);
		contentPane.add(pionVert);
		
		JButton pionViolet = new JButton("");
		Image cercleViolet = new ImageIcon(this.getClass().getResource("/cercle violet.jpg")).getImage();
		pionViolet.setIcon(new ImageIcon(cercleViolet));
		pionViolet.setBounds(312, 518, 35, 33);
		contentPane.add(pionViolet);
		
		JButton pionJaune = new JButton("");
		Image cercleJaune = new ImageIcon(this.getClass().getResource("/cercle jaune.jpg")).getImage();
		pionJaune.setIcon(new ImageIcon(cercleJaune));
		pionJaune.setBounds(357, 518, 35, 33);
		contentPane.add(pionJaune);
		
		JPanel plateauJeu = new JPanel();
		plateauJeu.setBounds(67, 58, 350, 435);
		contentPane.add(plateauJeu);
		plateauJeu.setBackground(new Color(222, 184, 135));
		plateauJeu.setLayout(new GridLayout(10, 4, 20, 20));
		
		JPanel colonnes = new JPanel();
		colonnes.setBounds(10, 58, 47, 435);
		colonnes.setBackground(new Color(222, 184, 135));
		contentPane.add(colonnes);
		colonnes.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel validationPanel = new JPanel();
		validationPanel.setBounds(427, 58, 47, 435);
		contentPane.add(validationPanel);
		validationPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(402, 503, 72, 48);
		contentPane.add(textPane);
		
		/**
		 * Ne fonctionne pas, ne peux pas récuperer l'indice du jComboList pour l'actionListener.
		 */
		for (int i = 0; i < 10; i++) {
			
		JButton btnValider = new JButton("ok");
		btnValider.addActionListener(new Ecouteur()); 
		validationPanel.add(btnValider);
		}
		
		int nb=10;
		for (int i = 0; i < 10; i++) {
			jColonnes.add(new JLabel(""+ nb));
			jColonnes.get(i).setForeground(new Color(75, 0, 130));
			jColonnes.get(i).setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
			colonnes.add(jColonnes.get(i));
			nb--;
		}
		
		String [] pions = {"Noir", "Rouge", "Bleu", "Vert", "Violet", "Jaune"};
		for (int i = 0; i < 40; i++) {
			jComboList.add(new JComboBox(pions));
			jComboList.get(i).setSelectedItem(null); 
			jComboList.get(i).addItemListener(new ItemListener(){
				  public void itemStateChanged(ItemEvent event) {
				    switch (event.getStateChange()) {  
				      case ItemEvent.SELECTED: { 
				        System.out.println(jComboList.get(36).getSelectedItem().toString());
				      }
				      //
				      case ItemEvent.DESELECTED: 
				      default: { 
				        // traitement 2     
				      }
				    }
				  }	
				});
		
//			comboBox.setModel(new DefaultComboBoxModel(new String[] {""+i}));
			plateauJeu.add(jComboList.get(i));
		}
		jComboList.get(39).addActionListener(new Ecouteur());
	}


class Ecouteur implements ActionListener
{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("OK");
		}
}
	
}
