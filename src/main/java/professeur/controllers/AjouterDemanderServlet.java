package professeur.controllers;

import java.io.IOException;
import java.util.Date;

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
import professeur.models.Demande;
import superviseur.models.Utilisateur;

/**
 * Servlet implementation class AjouterDemanderServlet
 */
@WebServlet("/Ajouter_Demande")
public class AjouterDemanderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 LoginDao lg_dao = new LoginDao();
    TypeMaterielDao tp_dao = new TypeMaterielDao();
    FiliereDao f_fao = new FiliereDao();
    SalleDao s_dao = new SalleDao();
    DemandeDao d_dao = new DemandeDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterDemanderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(lg_dao.athentifie(request.getSession(false), "Professeur")){
		request.setAttribute("listtype", tp_dao.SelectTypeMateriel());
		request.setAttribute("Salles", s_dao.SelectSalle());
		request.setAttribute("filiere", f_fao.SelectFiliere());
		request.getRequestDispatcher("prof_views/Ajouter_Demande.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/Se_connecter");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur u = (Utilisateur) request.getSession(false).getAttribute("Utilisateur");
		
		int Id_dmd = 1 + d_dao.maxid();
		String Id_Prof = u.getId_user() ;
		int type = Integer.parseInt(request.getParameter("Designation"));
		Date Date_dmd = new Date();
		int Qte = Integer.parseInt(request.getParameter("Qte"));
		int Salle = Integer.parseInt(request.getParameter("Salle"));
		int filiere = Integer.parseInt(request.getParameter("filiere"));
		String valide = "no_valide";
		
		Demande d = new Demande();
		d.setId_dmd(Id_dmd);
		d.setFiliere(filiere);
		d.setDate_dmd(new java.sql.Date(Date_dmd.getTime()));
		d.setId_Prof(Id_Prof);
		d.setQte(Qte);
		d.setSalle(Salle);
		d.setType(type);
		d.setValide(valide);
		
		d_dao.AjoutDemande(d);
		response.sendRedirect(request.getContextPath()+"/Ajouter_Demande");
	}

}
