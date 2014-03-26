package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserManager {

    public int create(Connection conn, String login, String mdp){
        PreparedStatement pstm = null;
        int n = 0;
        try {
            String sql = "insert into \"user\"(login, pwd) values(?,?)";
            pstm = conn.prepareStatement(sql);
            int i = 1;

            pstm.setString(i++, login);
            pstm.setString(i, mdp);

            if (1!= (n = pstm.executeUpdate())) {
                System.out.println("Erreur requete");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch(Exception ignore) {}
        }
        return n;
    }

    public User read(Connection conn, int id){
        PreparedStatement pstm = null;
        ResultSet rset = null;
        User user = null;
        try {
            String sql = "select * from \"user\" where id=?";
            pstm = conn.prepareStatement(sql);

            int i = 1;

            pstm.setInt(i++, id);
            rset = pstm.executeQuery();
            while(rset.next()){
                user = new User(rset.getInt("id"),rset.getString("login"),rset.getString("pwd"),rset.getInt("nbPanier"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch(Exception ignore) {}
            try {rset.close();} catch(Exception ignore) {}
        }
        return user;
    }

    public List<User> read_all(Connection conn){
        PreparedStatement pstm = null;
        ResultSet rset = null;
        List<User> lst = null;
        User user = null;
        try {
            String sql = "select * from \"user\"";
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while(rset.next()){
                user = new User(rset.getInt("id"),rset.getString("login"),rset.getString("pwd"),rset.getInt("nbPanier"));
                lst.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch(Exception ignore) {}
            try {rset.close();} catch(Exception ignore) {}
        }
        return lst;
    }

    public int update(Connection conn, int id, User user){
        PreparedStatement pstm = null;
        int n = 0;
        try {
            String sql = "update \"user\" set id=?, login=?, pwd=?, nbPanier=? where id=?";
            pstm = conn.prepareStatement(sql);
            int i = 1;

            pstm.setInt(i++, user.getId());
            pstm.setString(i++,user.getLogin());
            pstm.setString(i++, user.getPwd());
            pstm.setInt(i++, user.getNbPanier());

            pstm.setInt(i++, id);

            if (1!= (n = pstm.executeUpdate())) {
                System.out.println("Erreur requete");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch(Exception ignore) {}
        }
        return n;
    }

    public int delete(Connection conn, int id){
        PreparedStatement pstm = null;
        int n =0;
        try {
            String sql = "delete from \"user\" where id=?";
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            if (1!= (n = pstm.executeUpdate())){
                System.out.println("Erreur requete");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch(Exception ignore) {}
        }
        return n;
    }
    public int connect(Connection conn, String login, String mdp){
        PreparedStatement pstm = null;
        ResultSet rset = null;
        int user = -1;
        try {
            String sql = "select id from \"user\" where login=? and pwd=?";
            pstm = conn.prepareStatement(sql);
            int i = 1;

            pstm.setString(i++, login);
            pstm.setString(i++, mdp);
            rset = pstm.executeQuery();
            while(rset.next()){
                user = rset.getInt("id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch(Exception ignore) {}
            try {rset.close();} catch(Exception ignore) {}
        }
        return user;
    }
}
