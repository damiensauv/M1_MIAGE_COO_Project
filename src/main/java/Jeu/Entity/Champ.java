package Jeu.Entity;

public class Champ extends Territoire {

    public Champ(Coordonnees coordonnees) {
        super(coordonnees);
        // TODO Auto-generated constructor stub
    }

    private Joueur joueur;


    public void AfficherTypeTerritoire() {
        System.out.print('C');

    }

    public Type getType() {
        return Type.champs;
    }
}
