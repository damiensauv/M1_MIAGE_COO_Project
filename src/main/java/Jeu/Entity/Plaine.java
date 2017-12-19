package Jeu.Entity;

import Jeu.Interface.IUser;
import Jeu.Interface.IVille;

public class Plaine extends Territoire {

    public Plaine(Coordonnees coordonnees, IVille ville, IUser user) {
        super(coordonnees);
        this.villes = ville;
        this.owner = user;
    }

    public void AfficherTypeTerritoire() {
        System.out.print('P');
    }

    public Type getType() {
        return Type.plaine;
    }
}
