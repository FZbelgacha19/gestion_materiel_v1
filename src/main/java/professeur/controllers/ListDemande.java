package professeur.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dao.LoginDao;
import magasinier.dao.TypeMaterielDao;
import professeur.dao.DemandeDao;
import professeur.dao.FiliereDao;
import professeur.dao.SalleDao;
import superviseur.models.Utilisateur;

/**
 * Servlet implementation class ListDemande
 */
@WebServlet("/List_Demande")
public class ListDemande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao lg_dao = new LoginDao();
	TypeMaterielDao tp_dao = new TypeMaterielDao();
	FiliereDao f_fao = new FiliereDao();
	SalleDao s_dao = new SalleDao();
	DemandeDao d_dao = new DemandeDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListDemande() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (lg_dao.athentifie(request.getSession(false), "Professeur")) {
			request.setAttribute("tp", tp_dao);
			request.setAttribute("s", s_dao);
			request.setAttribute("f", f_fao);
			Utilisateur u = (Utilisateur) request.getSession(false).getAttribute("Utilisateur");
			request.setAttribute("ListDmd", d_dao.SelectDemandeByProf(u.getId_user()));
			request.getRequestDispatcher("prof_views/List_Demande.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/Se_connecter");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String value = request.getParameter("value");
		Utilisateur u = (Utilisateur) request.getSession(false).getAttribute("Utilisateur");
		request.setAttribute("tp", tp_dao);
		request.setAttribute("s", s_dao);
		request.setAttribute("f", f_fao);
		request.setAttribute("ListDmd", d_dao.SelectDemande(value, u.getId_user()));
		request.getRequestDispatcher("prof_views/List_Demande.jsp").forward(request, response);
	}

}
