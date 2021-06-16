package technicien.controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dao.LoginDao;
import magasinier.dao.MaterielDao;
import magasinier.models.Materiel;
import superviseur.models.Utilisateur;
import technicien.dao.InterventionDao;
import technicien.models.Intervention;

/**
 * Servlet implementation class AjouterInterventionServlet
 */
@WebServlet("/Ajouter_Intervention")
public class AjouterInterventionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao lg_dao = new LoginDao();
	InterventionDao i_dao = new InterventionDao();
	MaterielDao m_dao = new MaterielDao();	
			
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterInterventionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(lg_dao.athentifie(request.getSession(false), "Technicien")){
			request.getRequestDispatcher("tech_views/Ajouter_Intervention.jsp").forward(request, response);

		}else {
			response.sendRedirect(request.getContextPath()+"/Se_connecter");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int Id_intervention = 1+i_dao.maxid();
			Utilisateur u = (Utilisateur) request.getSession(false).getAttribute("Utilisateur");
			String Inventaire = u.getId_user();
			Materiel m = m_dao.getMateriels(request.getParameter("Num_Serie"));
			int Id_mat = m.getId_mat();
			String Traitement = request.getParameter("Traitement");
			Date Date_intervention = new Date();
			
			Intervention i = new Intervention();
			i.setId_intervention(Id_intervention);
			i.setInventaire(Inventaire);
			i.setId_mat(Id_mat);
			i.setTraitement(Traitement);
			i.setDate_intervention(new java.sql.Date(Date_intervention.getTime()));
			
			i_dao.AjoutIntervention(i);
			response.sendRedirect(request.getContextPath()+"/Ajouter_Intervention");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
