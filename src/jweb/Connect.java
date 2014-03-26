package jweb;

import bdd.*;
import sun.util.logging.resources.logging_it;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

/**
 * Created by valen_000 on 24/03/14.
 */
@WebServlet
public class Connect extends HttpServlet {
    private  static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("but").equals(null)){
            response.sendRedirect("http://localhost:8080/");
        } else {
            HttpSession session = request.getSession();
            UserManager userManager = new UserManager();
            Connection conn = Singleton.CONNECTION;
            User user = null;
            if (request.getParameter("but").equals("Connexion")){
                user = userManager.read(conn, userManager.connect(conn, request.getParameter("pseudo"), request.getParameter("pass")));
            }
            if (request.getParameter("but").equals("Inscription")){
                userManager.create(conn, request.getParameter("pseudo"), request.getParameter("pass"));
                user = userManager.read(conn, userManager.connect(conn, request.getParameter("pseudo"), request.getParameter("pass")));
            }

            session.setAttribute("user", user);
            response.sendRedirect("http://localhost:8080/");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

