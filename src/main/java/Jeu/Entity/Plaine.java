package Jeu.Entity;

public class Plaine extends Territoire {

    public Plaine(Coordonnees coordonnees) {
        super(coordonnees);
    }

    public void AfficherTypeTerritoire() {
        System.out.print('P');
    }

    public Type getType() {
        return Type.plaine;
    }
}
