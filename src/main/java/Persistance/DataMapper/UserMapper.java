package Persistance.DataMapper;

import Jeu.Entity.User;
import Jeu.Interface.IUser;
import Util.UnitOfWork;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper extends DataMapper<IUser> {

    private static UserMapper instance = null;

    public static UserMapper getInstance() {
        if (instance == null) {
            instance = new UserMapper();
        }
        return instance;
    }

    private UserMapper() {
    }

    private User createUser(ResultSet rs) throws SQLException {
        User p = new User();
        p.setId(rs.getInt(1));
        p.setUsername(rs.getString(2));
        p.setPassword(rs.getString(3));
        return p;
    }

    public IUser find(Object idx) {

        Integer id = (Integer) idx;

        IUser p = idMap.get(id);
        if (p != null) {
            System.out.println("Get From IDMAP");
            return p;
        }

        String req = "SELECT id, username, password FROM user WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) { // TODO : LEVER une exception
                System.out.println("not in bd " + id);
                return null;
            }
            p = this.createUser(rs);
            idMap.put(id, p);
            p.add(UnitOfWork.getInstance());
            return p;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public IUser findByUsername(String username) {
        IUser p;

        String req = "SELECT id, username, password FROM user WHERE username=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) { // TODO : LEVER une exception
                System.out.println("not in bd " + username);
                return null;
            }
            p = idMap.get(rs.getInt(1));
            if (p != null) {
                System.out.println("Get From IDMAP");
                return p;
            }
            p = this.createUser(rs);
            idMap.put(rs.getInt(1), p);
            p.add(UnitOfWork.getInstance());
            return p;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer insert(IUser o) {
        return 0;
    }

    void delete(IUser o) {

    }

    public void update(IUser o) {
        System.out.println("Update USER");
    }

}
