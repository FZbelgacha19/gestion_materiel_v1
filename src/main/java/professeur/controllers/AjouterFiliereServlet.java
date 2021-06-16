package professeur.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dao.LoginDao;
import professeur.dao.FiliereDao;
import professeur.models.Filiere;
import superviseur.models.Utilisateur;

/**
 * Servlet implementation class AjouterFiliereServlet
 */
@WebServlet("/nouvel_filier")
public class AjouterFiliereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FiliereDao f_dao = new FiliereDao();
	private LoginDao lg_dao = new LoginDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterFiliereServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(lg_dao.athentifie(request.getSession(false), "Professeur")){
		request.getRequestDispatcher("prof_views/nouvel_filier.jsp").forward(request, response);
		}else
			response.sendRedirect(request.getContextPath()+"/Se_connecter");
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int Nbr_etudiant = Integer.parseInt(request.getParameter("Nbr_etudiant"));
		String Nom_fil = request.getParameter("Nom_fil");
		int id = 1+f_dao.maxid();
		Utilisateur u = (Utilisateur) request.getSession(false).getAttribute("Utilisateur");
		String id_prof = u.getId_user();
		Filiere f = new Filiere();
		f.setId_fil(id);
		f.setId_prof(id_prof);
		f.setNbr_etudiant(Nbr_etudiant);
		f.setNom_fil(Nom_fil);
		f_dao.AjoutFiliere(f);
		response.sendRedirect(request.getContextPath()+"/nouvel_filier");
	}

}
