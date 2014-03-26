package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by valen_000 on 05/02/14.
 */
public class PanierManager {

    public int create(Connection conn, Panier panier, User user){
        PreparedStatement pstm = null;
        List<Integer> lstart = null;
        List<Integer> lstqte = null;
        int n = 0;
        try {
            String sql = "insert into \"panier\"(idart, qte, idpanier, iduser) values(?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            int i = 1;
            lstart = panier.getLstidart();
            lstqte = panier.getLstqte();
            int nbPanier = user.getNbPanier() + 1;
            for (int z : lstart){

                pstm.setInt(i++, lstart.get(z));
                pstm.setInt(i++, lstqte.get(z));
                pstm.setInt(i++, nbPanier);
                pstm.setInt(i++, user.getId());


                if (1!= (n = pstm.executeUpdate())) {
                    System.out.println("Erreur requete");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch(Exception ignore) {}
        }
        return n;
    }

    public Panier read(Connection conn, int id, User user){
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Panier panier = null;
        try {
            String sql = "select * from \"panier\" where idpanier=? and iduser=?";
            pstm = conn.prepareStatement(sql);
            int i = 1;

            pstm.setInt(i++, id);
            pstm.setInt(i++, user.getId());
            rset = pstm.executeQuery();
            panier = new Panier();

            while(rset.next()){
                panier.setIdpanier(rset.getInt("idpanier"));
                panier.addarticle(rset.getInt("idarticle"),rset.getInt("quantite"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch(Exception ignore) {}
            try {rset.close();} catch(Exception ignore) {}
        }
        return panier;
    }

    public List<Panier> read_all(Connection conn){
        PreparedStatement pstm = null;
        ResultSet rset = null;
        List<Panier> lst = null;
        Panier panier = null;
        try {
            String sql = "select * from \"panier\"";
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while(rset.next()){
                if(rset.first()){
                    panier = new Panier(rset.getInt("idpanier"));
                    panier.addarticle(rset.getInt("idarticle"),rset.getInt("quantite"));
                }
                else {
                    if(panier.getIdpanier() != rset.getInt("idpanier")){
                        panier = new Panier(rset.getInt("idpanier"));
                        panier.addarticle(rset.getInt("idarticle"),rset.getInt("quantite"));
                    }
                    else {
                        panier.addarticle(rset.getInt("idpanier"),rset.getInt("quantite"));
                    }
                }
                lst.add(panier);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch(Exception ignore) {}
            try {rset.close();} catch(Exception ignore) {}
        }
        return lst;
    }

    public int delete(Connection conn, int idpanier){
        PreparedStatement pstm = null;
        int n =0;
        try {
            String sql = "delete from panier where idpanier=?";
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, idpanier);

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

    public int update(Connection conn, Panier panier, User user){
        PreparedStatement pstm = null;
        List<Integer> lstart = null;
        List<Integer> lstqte = null;
        int n = 0;
        try {
            String sql = "update \"panier\" set qte=? where idpanier=? and iduser=?";
            pstm = conn.prepareStatement(sql);
            int i = 1;

            lstart = panier.getLstidart();
            lstqte = panier.getLstqte();
            int nbPanier = user.getNbPanier();
            for (int z : lstart){
                pstm.setInt(i++, lstqte.get(z));
                pstm.setInt(i++, nbPanier);
                pstm.setInt(i++, user.getId());
                if (1!= (n = pstm.executeUpdate())) {
                    System.out.println("Erreur requete");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch(Exception ignore) {}
        }
        return n;
    }
}

