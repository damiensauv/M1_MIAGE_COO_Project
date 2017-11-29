package Persistance.DataMapper;

import Jeu.Entity.User;
import Jeu.Interface.IUser;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDataMapper extends DataMapper<IUser> {

    private static UserDataMapper instance = null;

    public static UserDataMapper getInstance() {
        if (instance == null) {
            instance = new UserDataMapper();
        }
        return instance;
    }

    private UserDataMapper() {
    }

    private User createUser(ResultSet rs) throws SQLException {
        User p = new User();
        p.setId(rs.getInt(1));
        p.setUsername(rs.getString(2));
        p.setPassword(rs.getString(3));
        return p;
    }

    public IUser find(Integer id) {
        User p;

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
            return p;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public IUser findByUsername(String username) {
        User p;

        String req = "SELECT id, username, password FROM user WHERE username=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) { // TODO : LEVER une exception
                System.out.println("not in bd " + username);
                return null;
            }
            p = this.createUser(rs);
            return p;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    void insert(IUser o) {

    }

    void delete(IUser o) {

    }

    void update(IUser o) {

    }

}
