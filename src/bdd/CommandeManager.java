package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by valen_000 on 07/02/14.
 */
public class CommandeManager {

    public int create(Connection conn, Commande commande){
        PreparedStatement pstm = null;
        int n = 0;
        try {
            String sql = "insert into commande(id, iduser, idpanier, date, validated) values('',?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            int i = 1;

            pstm.setInt(i++, commande.getIduser());
            pstm.setInt(i++, commande.getIdpanier());
            pstm.setString(i++, commande.getDate());
            pstm.setBoolean(i++, commande.getValidated());

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

    public Commande read(Connection conn, int id){
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Commande commande = null;
        try {
            String sql = "select * from commande where id=?";
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            int i = 1;

            pstm.setInt(i++, id);
            commande = new Commande();

            while(rset.next()){
                commande.setIduser(rset.getInt("iduser"));
                commande.setIdpanier(rset.getInt("idpanier"));
                commande.setDate(rset.getString("date"));
                commande.setValidated(rset.getBoolean("validated"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch(Exception ignore) {}
            try {rset.close();} catch(Exception ignore) {}
        }
        return commande;
    }

    public List<Commande> read_all(Connection conn){
        PreparedStatement pstm = null;
        ResultSet rset = null;
        List<Commande> lst = null;
        Commande commande = null;
        try {
            String sql = "select * from panier";
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while(rset.next()){
                commande = new Commande();
                commande.setIduser(rset.getInt("iduser"));
                commande.setIdpanier(rset.getInt("idpanier"));
                commande.setDate(rset.getString("date"));
                commande.setValidated(rset.getBoolean("validated"));
                lst.add(commande);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch(Exception ignore) {}
            try {rset.close();} catch(Exception ignore) {}
        }
        return lst;
    }

    public int delete(Connection conn, int id){
        PreparedStatement pstm = null;
        int n =0;
        try {
            String sql = "delete from commande where id=?";
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

    public int update(Connection conn, Commande commande){
        PreparedStatement pstm = null;
        int n = 0;
        try {
            String sql = "update commande set iduser=?, idpanier=?, date=?, validated=? where id=?";
            pstm = conn.prepareStatement(sql);

            int i = 1;

            pstm.setInt(i++, commande.getIduser());
            pstm.setInt(i++, commande.getIdpanier());
            pstm.setString(i++, commande.getDate());
            pstm.setBoolean(i++, commande.getValidated());
            pstm.setInt(i++, commande.getId());

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
}
