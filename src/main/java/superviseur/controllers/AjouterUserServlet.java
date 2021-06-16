package superviseur.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * Servlet implementation class AjouterUserServlet
 */
@WebServlet("/Ajouter_utilisateur")
public class AjouterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurDao ut_dao = new UtilisateurDao();
	private LoginDao lg_dao = new LoginDao();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjouterUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(lg_dao.athentifie(request.getSession(false), "Superviseur")){
			request.getRequestDispatcher("utilisateur_views/adduser.jsp").forward(request, response);
		}else
			response.sendRedirect(request.getContextPath()+"/Se_connecter");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();

			String Nom_user = request.getParameter("nom");
			String Prenom_user = request.getParameter("prenom");
			String Tele = request.getParameter("tele");
			String email = request.getParameter("email");
			String login = request.getParameter("login");
			String Motpass = request.getParameter("motPass");
			String type_user = request.getParameter("type_user");
			String created_at = format.format(date);
			List<Utilisateur> users = ut_dao.getUtilisateurParType(type_user);
			int i = users.size()+1;
			String id_user = type_user.substring(0, 1)+"_"+i;

			Utilisateur u = new Utilisateur();
			u.setId_user(id_user);
			u.setNom_user(Nom_user);
			u.setPrenom_user(Prenom_user);
			u.setEmail(email);
			u.setTele(Tele);
			u.setLogin(login);
			u.setMotpass(Motpass);
			u.setMotpassConfirmation(Motpass);
			u.setType_user(type_user);
			u.setCreated_at(created_at);
			u.setUpdated_at(created_at);

			ut_dao.AjouterUtilisateur(u);
			request.setAttribute("success", "utilisateur ajouté avec success");
		} catch (Exception e) {
			request.setAttribute("erreur", e.getMessage());
		}
		doGet(request, response);
	}

}
