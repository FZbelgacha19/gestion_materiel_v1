package superviseur.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dao.LoginDao;
import superviseur.dao.UtilisateurDao;


/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/Supprime_utilisateur")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao lg_dao = new LoginDao();
	private UtilisateurDao ut_dao = new UtilisateurDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
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
				ut_dao.SuppUtilisateur(id_user);
				response.sendRedirect(request.getContextPath()+"/Liste_Utilisateurs?success=Utilisateur supprime avec success");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		else
			response.sendRedirect(request.getContextPath()+"/Se_connecter");
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
