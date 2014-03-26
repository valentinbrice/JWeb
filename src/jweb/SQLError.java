package jweb;

import bdd.Category;
import bdd.CategoryManager;
import bdd.Singleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


@WebServlet
public class SQLError extends HttpServlet {
    private  static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                request.setAttribute("error", "Base de données HS");
                this.getServletContext().getRequestDispatcher("/WEB_INF/SQLError.jsp").forward(request, response);
            }
            //request.setAttribute("category", lst);
            //this.getServletContext().getRequestDispatcher("/WEB_INF/index.jsp").forward(request, response);

        /*Futur Affichage des Meilleurs Ventes
        /ArticleManager articleManager = new ArticleManager();
        /List<Article> lstbest = articleManager.readBestSell(conn)
        /request.setAttribute("bestsell", lstbest);
        */
}