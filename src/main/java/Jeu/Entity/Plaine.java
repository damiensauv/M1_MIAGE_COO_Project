package Jeu.Entity;

public class Plaine extends Territoire{

	public Plaine(Coordonnees coordonnees) {
		super(coordonnees);
		// TODO Auto-generated constructor stub
	}

	
	public void AfficherTypeTerritoire(){
		System.out.print('P');
		
	}

	public Type getType() {
		return Type.plaine;
	}
}
