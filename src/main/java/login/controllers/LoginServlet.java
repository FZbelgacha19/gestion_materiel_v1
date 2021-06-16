package login.controllers;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.dao.LoginDao;
import superviseur.models.Utilisateur;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Se_connecter")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao log_dao = new LoginDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
			if( session.getAttribute("Utilisateur") != null)
				response.sendRedirect(request.getContextPath()+session.getAttribute("redirection"));
			else
				request.getRequestDispatcher("login_views/login.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("login_views/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String motPass = request.getParameter("motPass");
		try {
			Utilisateur Utilisateur = log_dao.login_valide(email, motPass);
			if (Utilisateur != null) {
				HttpSession session = request.getSession();
				session.setAttribute("Utilisateur", Utilisateur);

				switch (Utilisateur.getType_user()) {
				case "Superviseur":
					session.setAttribute("redirection", "/Superviseur");
					response.sendRedirect(request.getContextPath()+"/Superviseur");
					break;
					
				case "Magasinier":
					session.setAttribute("redirection", "/Magasinier");
					response.sendRedirect(request.getContextPath()+"/Magasinier");
					break;
				case "Professeur":
					session.setAttribute("redirection", "/Professeur");
					response.sendRedirect(request.getContextPath()+"/Professeur");
					break;
				case "Technicien":
					session.setAttribute("redirection", "/Technicien");
					response.sendRedirect(request.getContextPath()+"/Technicien");
					break;
				case "Comptable":
					session.setAttribute("redirection", "/Comptable");
					response.sendRedirect(request.getContextPath()+"/Comptable");
					break;
				default:
					break;
				}
				// rd.forward(request,response);
			}
		} catch (Exception e) {
//			request.setAttribute("erreur", e.getMessage());
		}

		// doGet(request, response);
	}

}
