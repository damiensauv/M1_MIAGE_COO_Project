package Jeu;

public abstract class Territoire {

	private Ville ville;
	private Coordonnees coordonnees;
	

	//Quand on génère un territoire, il n'y a pas de ville implantée de base
	public Territoire() {
		super();
		this.ville = null;
	}


	public Ville getVille() {
		return ville;
	}

	//On assigne un joueur directement pour déclarer l'existence de la ville
	public void setVille(Joueur j) {
		this.ville = new Ville(j);
	}


	public Coordonnees getCoordonnees() {
		return coordonnees;
	}


	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}
	
	
	
	
}
