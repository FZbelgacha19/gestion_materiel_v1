package professeur.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dao.LoginDao;
import professeur.dao.SalleDao;

/**
 * Servlet implementation class ListSalleServlet
 */
@WebServlet("/List_Salle")
public class ListSalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao lg_dao = new LoginDao(); 
	SalleDao s_dao = new SalleDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListSalleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (lg_dao.athentifie(request.getSession(false), "Professeur")) {
			request.setAttribute("Listsall", s_dao.SelectSalle());
			request.getRequestDispatcher("prof_views/List_Salle.jsp").forward(request, response);
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
