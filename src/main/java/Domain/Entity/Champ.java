package Domain.Entity;

import Domain.Interface.IUser;
import Domain.Interface.IVille;

public class Champ extends Territoire {

    public Champ(Coordonnees coordonnees, IVille ville, IUser user, int idx) {
        super(coordonnees);
        this.villes = ville;
        this.owner = user;
        this.setId(idx);
    }

    public Champ(Coordonnees coord, IVille ville, IUser user) {
        super(coord);
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
