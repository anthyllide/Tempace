package controler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by gonzalal on 14/06/17.
 */
public class Controler extends HttpServlet {
    private String urlAuth;

    // INIT
    public void init() throws ServletException {
        urlAuth = getServletConfig().getInitParameter("urlAuth");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        // On récupère la méthode d'envoi de la requête
        String methode = request.getMethod().toLowerCase();

        // On récupère l'action à exécuter
        String action = request.getPathInfo();

        if (action == null) {
            action = "/auth";
            System.out.println("action == null");
        }

        // Exécution action
        if (methode.equals("get") && action.equals("/auth")) {
            doAuth(request, response);
        }
    }

    private void loadJSP(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher(url);
        rd.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // On récupère la méthode d'envoi de la requête
        String methode = request.getMethod().toLowerCase();

        // On récupère l'action à exécuter
        String action = request.getPathInfo();

        if (methode.equals("post") && action.equals("/validerAuth")){
            doValiderAuth(request, response);
        }
    }

    protected void doAuth(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        loadJSP(urlAuth, request, response);
    }

    protected void doValiderAuth(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("/tempace/api/login");

    }
}
