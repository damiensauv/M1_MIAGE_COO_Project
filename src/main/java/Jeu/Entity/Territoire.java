package Jeu.Entity;

public abstract class Territoire {

    private Coordonnees coordonnees;

    private Type type;

    public Territoire(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    public abstract void AfficherTypeTerritoire();

    public abstract Type getType();

    public void setType(Type type) {
        this.type = type;
    }

}
