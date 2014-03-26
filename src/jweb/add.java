package jweb;

import bdd.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by valen_000 on 24/03/14.
 */
@WebServlet
public class add extends HttpServlet {
    private  static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Panier panier;
        if (request.getSession().getAttribute("panier") == null){
            PanierManager panierManager = new PanierManager();
            panier = new Panier();

        } else {
            panier = (Panier) request.getSession().getAttribute(("panier"));
        }
        ArticleManager articleManager = new ArticleManager();
        Article article = articleManager.read(Singleton.CONNECTION, Integer.parseInt(request.getParameter("idart")));
        if (article.getStock() > 0){
            
        } else {

        }

    }
}

