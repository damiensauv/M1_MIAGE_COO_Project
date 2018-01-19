package Persistance.DataMapper;

import Domain.Interface.IArmee;

import java.sql.SQLException;

public class ArmeeMapper extends DataMapper<IArmee> {

    private static ArmeeMapper instance = null;

    public static ArmeeMapper getInstance() {
        if (instance == null) {
            instance = new ArmeeMapper();
        }
        return instance;
    }

    private ArmeeMapper() {

    }

    @Override
    public IArmee find(Object id) {
        return null;
    }

    @Override
    Object insert(IArmee o) throws SQLException {
        return null;
    }

    @Override
    void delete(IArmee o) {

    }

    @Override
    void update(IArmee o) throws SQLException {

    }
}
