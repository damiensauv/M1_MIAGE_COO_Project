package Persistance.Factory;

import Domain.Interface.IArmee;
import Persistance.DataMapper.ArmeeMapper;

public class ArmeeFactory implements Factory<IArmee> {

    private Integer id;

    public ArmeeFactory(Integer id) {
        this.id = id;
    }

    public IArmee create() {
        IArmee armee = ArmeeMapper.getInstance().find(this.id);
        return armee;
    }
}