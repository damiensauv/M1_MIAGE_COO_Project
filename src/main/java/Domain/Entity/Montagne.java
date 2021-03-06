package Domain.Entity;

import Domain.Interface.IUser;
import Domain.Interface.IVille;

public class Montagne extends Territoire {

    public Montagne(Coordonnees coordonnees, IVille ville, IUser user, int idx) {
        super(coordonnees);
        this.villes = ville;
        this.owner = user;
        this.setId(idx);
    }

    public Montagne(Coordonnees coord, IVille ville, IUser user) {
        super(coord);
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
