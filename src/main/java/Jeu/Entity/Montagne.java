package Jeu.Entity;

public class Montagne extends Territoire {

    public Montagne(Coordonnees coordonnees) {
        super(coordonnees);
    }

    public void AfficherTypeTerritoire() {
        System.out.print('M');
    }

    public Type getType() {
        return Type.montagne;
    }
}
