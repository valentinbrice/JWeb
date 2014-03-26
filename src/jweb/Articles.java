package jweb;

import bdd.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

/**
 * Created by valen_000 on 24/03/14.
 */
@WebServlet
public class Articles extends HttpServlet {
    private  static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           System.out.println(request.getParameter("cat"));
        if (request.getParameter("cat") == null){
            this.getServletContext().getRequestDispatcher("/WEB-INF/SQLError.jsp").forward(request, response);
        } else {
            Connection conn;
            conn = Singleton.CONNECTION;
            int cat = Integer.parseInt(request.getParameter("cat"));
            ArticleManager articleManager = new ArticleManager();
            List<Article> lst = articleManager.read_all_by_cat(conn, cat);
            lst.toString();
            if (null == lst){
                request.setAttribute("error", "La BDD est HS");
                this.getServletContext().getRequestDispatcher("/WEB-INF/SQLError.jsp").forward(request, response);
            } else {
                request.setAttribute("articles", lst);
                this.getServletContext().getRequestDispatcher("/WEB-INF/Articles.jsp").forward(request, response);
            }
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

