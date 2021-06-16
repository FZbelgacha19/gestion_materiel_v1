package professeur.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dao.LoginDao;
import professeur.dao.FiliereDao;

/**
 * Servlet implementation class ListFiliereServlet
 */
@WebServlet("/List_Filiere")
public class ListFiliereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao lg_dao = new LoginDao();
	FiliereDao f_dao = new FiliereDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListFiliereServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (lg_dao.athentifie(request.getSession(false), "Professeur")) {
			request.setAttribute("Listfil", f_dao.SelectFiliere());
			request.getRequestDispatcher("prof_views/List_Filiere.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath() + "/Se_connecter");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
