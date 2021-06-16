package technicien.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dao.LoginDao;
import magasinier.dao.MaterielDao;
import superviseur.models.Utilisateur;
import technicien.dao.InterventionDao;


/**
 * Servlet implementation class ListeInterventionServlet
 */
@WebServlet("/Liste_Intervention")
public class ListeInterventionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao lg_dao = new LoginDao();
	InterventionDao i_dao = new InterventionDao();     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeInterventionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(lg_dao.athentifie(request.getSession(false), "Technicien")){
			Utilisateur u = (Utilisateur) request.getSession(false).getAttribute("Utilisateur");
			request.setAttribute("listintv", i_dao.SelectIntervention(u.getId_user()));
			request.setAttribute("m_dao", new MaterielDao());
			request.getRequestDispatcher("tech_views/Liste_Intervention.jsp").forward(request, response);

		}else {
			response.sendRedirect(request.getContextPath()+"/Se_connecter");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("value");
		request.setAttribute("listintv", i_dao.SelectInterventionParMateriel(value));
		request.setAttribute("m_dao", new MaterielDao());
		request.getRequestDispatcher("tech_views/Liste_Intervention.jsp").forward(request, response);
	}

}
