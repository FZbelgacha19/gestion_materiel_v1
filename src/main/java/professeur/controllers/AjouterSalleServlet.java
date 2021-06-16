package professeur.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dao.LoginDao;
import professeur.dao.SalleDao;
import professeur.models.Salle;

/**
 * Servlet implementation class AjouterSalleServlet
 */
@WebServlet("/nouvel_salle")
public class AjouterSalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  SalleDao s_dao = new SalleDao();
		private LoginDao lg_dao = new LoginDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterSalleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(lg_dao.athentifie(request.getSession(false), "Professeur")){
		request.getRequestDispatcher("prof_views/nouvel_salle.jsp").forward(request, response);
		}else
			response.sendRedirect(request.getContextPath()+"/Se_connecter");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("Num_salle"));
		String bloc = request.getParameter("Bloc");
		int id = 1+s_dao.maxid();
		Salle s = new Salle();
		s.setId_salle(id);
		s.setNum_salle(num);
		s.setBloc(bloc);
		s_dao.AjoutSalle(s);
		response.sendRedirect(request.getContextPath()+"/nouvel_salle");

	}

}
