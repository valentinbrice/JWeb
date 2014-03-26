package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by valen_000 on 05/02/14.
 */
public class CategoryManager {

    public int create(Connection conn, Category category){
        PreparedStatement pstm = null;
        int n = 0;
        try {
            String sql = "insert into \"Category\" (id, nom) values('',?)";
            pstm = conn.prepareStatement(sql);
            int i = 1;

            pstm.setInt(i++, category.getId());
            pstm.setString(i++, category.getCat());

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

    public Category read(Connection conn, int id){
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Category category = null;
        try {
            String sql = "select from \"Category\" where id=?";
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            int i = 1;

            pstm.setInt(i++, id);

            while(rset.next()){
                category = new Category();
                category.setId(rset.getInt("id"));
                category.setCat(rset.getString("nom"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch(Exception ignore) {}
            try {rset.close();} catch(Exception ignore) {}
        }
        return category;
    }

    public List<Category> read_all(Connection conn){
        PreparedStatement pstm = null;
        ResultSet rset = null;
        List<Category> lst = null;
        Category category = null;
        try {
            String sql = "select * from \"Category\"";
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            lst = new ArrayList<Category>();

            while(rset.next()){
                category = new Category();
                category.setId(rset.getInt("id"));
                category.setCat(rset.getString("nom"));
                lst.add(category);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch(Exception ignore) {}
            try {rset.close();} catch(Exception ignore) {}
        }
        return lst;
    }

    public int update(Connection conn, Category category){
        PreparedStatement pstm = null;
        int n = 0;
        try {
            String sql = "update \"Category\" set id=?, nom=? where id=?";
            pstm = conn.prepareStatement(sql);

            int i = 1;

            pstm.setInt(i++, category.getId());
            pstm.setString(i++, category.getCat());

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
            String sql = "delete from \"Category\" where id=?";
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
}
