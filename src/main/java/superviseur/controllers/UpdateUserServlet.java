package superviseur.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dao.LoginDao;
import superviseur.dao.UtilisateurDao;
import superviseur.models.Utilisateur;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/Modifier_Les_informations")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UtilisateurDao u_dao = new UtilisateurDao();
    private LoginDao lg_dao = new LoginDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(lg_dao.athentifie(request.getSession(false), "Superviseur")){
			String id_user = request.getParameter("id_user");
			try {
				Utilisateur user = u_dao.getUtilisateurParId(id_user);
				request.setAttribute("user", user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("utilisateur_views/updateuser.jsp").forward(request, response);
		}
		else
			response.sendRedirect(request.getContextPath()+"/Se_connecter");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_user = request.getParameter("id_user");
		Utilisateur u;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();

		String Nom_user = request.getParameter("nom");
		String Prenom_user = request.getParameter("prenom");
		String Tele = request.getParameter("tele");
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String Motpass = request.getParameter("motPass");
		String type_user = request.getParameter("type_user");
		String updated_at = format.format(date);
		try {
			u = u_dao.getUtilisateurParId(id_user);
			u.setNom_user(Nom_user);
			u.setPrenom_user(Prenom_user);
			u.setEmail(email);
			u.setTele(Tele);
			u.setLogin(login);
			u.setMotpass(Motpass);
			u.setMotpassConfirmation(Motpass);
			u.setType_user(type_user);
			u.setUpdated_at(updated_at);
			u_dao.ModifierUtilisateur(u);
			response.sendRedirect(request.getContextPath()+"/Liste_Utilisateurs?success=Utilisateur modifier avec success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
