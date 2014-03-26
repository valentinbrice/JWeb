package bdd;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by valen_000 on 04/02/14.
 */
public class ArticleManager {

    public int create(Connection conn, Article article){
        PreparedStatement pstm = null;
        int n = 0;
        try {
            String sql = "insert into article(id, nom, prix, stock) values(?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            int i = 1;

            pstm.setInt(i++, article.getId());
            pstm.setString(i++, article.getNom());
            pstm.setBigDecimal(i++, BigDecimal.valueOf(article.getPrix()));
            pstm.setInt(i++, article.getStock());
            pstm.setString(i++, article.getDesc());
            pstm.setString(i++, article.getPhoto());

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

    public Article read(Connection conn, int id){
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Article article = null;
        try {
            String sql = "select from user where id=?";
            pstm = conn.prepareStatement(sql);
            int i = 1;
            pstm.setInt(i++, id);
            rset = pstm.executeQuery();

            while(rset.next()){
                article = new Article(rset.getInt("id"),rset.getString("nom"),rset.getDouble("prix"),rset.getInt("stock"),rset.getInt("category"),rset.getString("description"),rset.getString("photo"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch(Exception ignore) {}
            try {rset.close();} catch(Exception ignore) {}
        }
        return article;
    }

    public List<Article> read_all(Connection conn){
        PreparedStatement pstm = null;
        ResultSet rset = null;
        List<Article> lst = null;
        Article article = null;
        try {
            String sql = "select * from article";
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            lst = new ArrayList<Article>();

            while(rset.next()){
                article = new Article(rset.getInt("id"),rset.getString("nom"),rset.getDouble("prix"),rset.getInt("stock"),rset.getInt("category"),rset.getString("description"),rset.getString("photo"));
                lst.add(article);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch(Exception ignore) {}
            try {rset.close();} catch(Exception ignore) {}
        }
        return lst;
    }

    public List<Article> read_all_by_cat(Connection conn, int cat){
        PreparedStatement pstm = null;
        ResultSet rset = null;
        List<Article> lst = null;
        Article article = null;
        try {
            String sql = "select * from article where \"category\"=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, cat);
            rset = pstm.executeQuery();
            lst = new ArrayList<Article>();

            while(rset.next()){
                article = new Article(rset.getInt("id"),rset.getString("nom"),rset.getDouble("prix"),rset.getInt("stock"),rset.getInt("category"),rset.getString("description"),rset.getString("photo"));
                lst.add(article);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch(Exception ignore) {}
            try {rset.close();} catch(Exception ignore) {}
        }
        return lst;
    }

    public int update(Connection conn, int id, Article article){
        PreparedStatement pstm = null;
        int n = 0;
        try {
            String sql = "update article set id=?, nom=?, prix=?, stock=?, category=?, description=?, photo=? where id=?";
            pstm = conn.prepareStatement(sql);

            int i = 1;

            pstm.setInt(i++, article.getId());
            pstm.setString(i++, article.getNom());
            pstm.setBigDecimal(i++, BigDecimal.valueOf(article.getPrix()));
            pstm.setInt(i++, article.getStock());
            pstm.setString(i++, article.getDesc());
            pstm.setString(i++, article.getPhoto());
            pstm.setInt(i++, article.getCategory());

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
            String sql = "delete from article where id=?";
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

