package Jeu.Entity;

import java.util.ArrayList;
import java.util.Random;


public class Carte {

	private Territoire[][] carte;
	ArrayList<Ville> listeVilles;
	ArrayList<Armee> listeArmee;

	// On déclare la carte avec ses dimensions

	// possede un Id

	public Carte(int x, int y) {

		super();
		this.carte = new Territoire[x][y];

		// Il nous faut un nombre aléatoire pour générer les cases de la map
		Random randomGenerator = new Random();
		int randomInt;

		// On crée la carte ligne par ligne
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				randomInt = randomGenerator.nextInt(3);
				this.setTerritoire(new Coordonnees(i, j), randomInt);
			}
		}
	}

	public void setTerritoire(Coordonnees coord, int type) {

		int xpos = coord.getX() ;
		int ypos = coord.getY() ;
		switch (type) {
		case 0:
			this.carte[xpos][ypos] = new Plaine(coord);
			break;
		case 1:
			this.carte[xpos][ypos] = new Champ(coord);
			break;
		case 2:
			this.carte[xpos][ypos] = new Montagne(coord);
			break;

		default:
			break;
		}

	}

	public Territoire[][] getCarte() {
		return carte;
	}

	public void setCarte(Territoire[][] carte) {
		this.carte = carte;
	}

	public ArrayList<Ville> getListeVilles() {
		return listeVilles;
	}

	public void setListeVilles(ArrayList<Ville> listeVilles) {
		this.listeVilles = listeVilles;
	}

	public ArrayList<Armee> getListeArmee() {
		return listeArmee;
	}

	public void setListeArmee(ArrayList<Armee> listeArmee) {
		this.listeArmee = listeArmee;
	}

	public void AfficherCarteDebug() {

		for (int i = 0; i < this.carte.length; i++) {
			for (int j = 0; j < this.carte[i].length; j++) {

				this.carte[i][j].AfficherTypeTerritoire();

			}
			// A la ligne
			System.out.println("");
		}

	}
}
