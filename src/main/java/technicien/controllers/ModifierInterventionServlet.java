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
import technicien.dao.InterventionDao;
import technicien.models.Intervention;

/**
 * Servlet implementation class ModifierInterventionServlet
 */
@WebServlet("/Modifier_Intervention")
public class ModifierInterventionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao lg_dao = new LoginDao();
	InterventionDao i_dao = new InterventionDao();
	MaterielDao m_dao = new MaterielDao();	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierInterventionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(lg_dao.athentifie(request.getSession(false), "Technicien")){
			int id = Integer.parseInt(request.getParameter("id_i"));
			request.setAttribute("i", i_dao.getIntervention(id));
			request.setAttribute("m_dao", new MaterielDao());
			request.getRequestDispatcher("tech_views/Modifier_Intervention.jsp").forward(request, response);

		}else {
			response.sendRedirect(request.getContextPath()+"/Se_connecter");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_i"));
		Intervention i = i_dao.getIntervention(id);
		Materiel m = m_dao.getMateriels(request.getParameter("Num_Serie"));
		if( m != null) {
		
		Date Date_intervention = new Date();
		String Traitement = request.getParameter("Traitement");
		int Id_mat = m.getId_mat();
		
		if(Traitement.equals("...") == false) {
			m.setEtat_mat("remise_neuf");
			m_dao.ModifMateriel(m);
		}
		i.setDate_intervention(new java.sql.Date(Date_intervention.getTime()));
		i.setId_mat(Id_mat);
		i.setTraitement(Traitement);
		i_dao.ModifeIntervention(i);
		response.sendRedirect(request.getContextPath()+"/Liste_Intervention?msg=1");
		}else
			response.sendRedirect(request.getContextPath()+"/Liste_Intervention?msg=0");
		

	}

}
