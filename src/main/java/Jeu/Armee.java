package Jeu;

public class Armee {

	private Joueur joueur;
	private Coordonnees coordonnees;
	
	
	public Armee(Joueur joueur, Coordonnees coordonnees) {
		super();
		this.joueur = joueur;
		this.coordonnees = coordonnees;
	}


	public Joueur getJoueur() {
		return joueur;
	}


	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}


	public Coordonnees getCoordonnees() {
		return coordonnees;
	}


	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}
	
	
	
	
	
}
