package Jeu.Entity;

import Jeu.Interface.IUser;
import Jeu.Interface.IVille;

public class Champ extends Territoire {

    public Champ(Coordonnees coordonnees, IVille ville, IUser user) {
        super(coordonnees);
        this.villes = ville;
        this.owner = user;
    }

    public void AfficherTypeTerritoire() {
        System.out.print('C');
    }

    public Type getType() {
        return Type.champs;
    }
}
