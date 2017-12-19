package Jeu.Entity;

import Jeu.Interface.IUser;
import Jeu.Interface.IVille;

public class Montagne extends Territoire {

    public Montagne(Coordonnees coordonnees, IVille ville, IUser user) {
        super(coordonnees);
        this.villes = ville;
        this.owner = user;
    }

    public void AfficherTypeTerritoire() {
        System.out.print('M');
    }

    public Type getType() {
        return Type.montagne;
    }
}
