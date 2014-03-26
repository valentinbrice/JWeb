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
public class Index extends HttpServlet {
    private  static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null){
            this.getServletContext().getRequestDispatcher("/WEB-INF/connect.jsp").forward(request, response);
        } else {
            if(request.getParameter("param") != null){
                String param = request.getParameter("param");
            } else {
                Connection conn;
                conn = Singleton.CONNECTION;
                CategoryManager categoryManager = new CategoryManager();
                List<Category> lst = categoryManager.read_all(conn);
                if (lst == null){
                    request.setAttribute("error", "Base de données HS");
                    this.getServletContext().getRequestDispatcher("/WEB-INF/SQLError.jsp").forward(request, response);
                } else {
                    request.setAttribute("category", lst);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                }
                /*Futur Affichage des Meilleurs Ventes
                /ArticleManager articleManager = new ArticleManager();
                /List<Article> lstbest = articleManager.readBestSell(conn)
                /request.setAttribute("bestsell", lstbest);
                */
            }
        }
    }
}