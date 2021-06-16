package technicien.controllers;

import java.io.IOException;
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
 * Servlet implementation class ValideInterventionServlet
 */
@WebServlet("/Valide_Intervention")
public class ValideInterventionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao lg_dao = new LoginDao();
	InterventionDao i_dao = new InterventionDao(); 
	MaterielDao m_dao = new MaterielDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValideInterventionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(lg_dao.athentifie(request.getSession(false), "Technicien")){
			int id = Integer.parseInt(request.getParameter("id_i"));
			Intervention i = i_dao.getIntervention(id);
			i_dao.valideIntervention(id);
			Materiel m = m_dao.getMateriels(i.getId_mat());
			m.setEtat_mat("remise_neuf");
			m_dao.ModifMateriel(m);
			response.sendRedirect(request.getContextPath()+"/Liste_Intervention");
		}else {
			response.sendRedirect(request.getContextPath()+"/Se_connecter");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
