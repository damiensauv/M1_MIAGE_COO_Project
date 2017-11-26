package Jeu.Entity;

public class Ville {

	private Joueur joueur;

	//Constructeur, une ville appartient à un joueur
	public Ville(Joueur joueur) {
		super();
		this.joueur = joueur;
	}
	
	//On récupère le joueur possédant la ville
	public Joueur getJoueur() {
		return joueur;
	}
	
	//On assigne un joueur à une ville
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	
	
}
