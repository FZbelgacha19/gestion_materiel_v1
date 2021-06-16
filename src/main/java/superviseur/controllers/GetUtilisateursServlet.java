package superviseur.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dao.LoginDao;
import superviseur.dao.UtilisateurDao;
import superviseur.models.Utilisateur;

/**
 * Servlet implementation class GetUtilisateursServlet
 */
@WebServlet("/Liste_Utilisateurs")
public class GetUtilisateursServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurDao u_dao = new UtilisateurDao();
	private LoginDao lg_dao = new LoginDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetUtilisateursServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getParameter("success") != null)
			request.setAttribute("success", request.getParameter("success"));
		
		List<Utilisateur> users = new ArrayList<Utilisateur>();
		users = u_dao.getTsUtilisateur();
		request.setAttribute("users", users);
		if(lg_dao.athentifie(request.getSession(false), "Superviseur")){
		request.getRequestDispatcher("utilisateur_views/List_Users.jsp").forward(request, response);
		}else
			response.sendRedirect(request.getContextPath()+"/Se_connecter");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String value = request.getParameter("value");
		List<Utilisateur> users = new ArrayList<Utilisateur>();
		users = u_dao.chercherUtilisateur(value);
		request.setAttribute("users", users);
		request.getRequestDispatcher("utilisateur_views/List_Users.jsp").forward(request, response);
	}

}
