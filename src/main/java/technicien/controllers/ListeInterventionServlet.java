package technicien.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dao.LoginDao;
import magasinier.dao.MaterielDao;
import superviseur.models.Utilisateur;
import technicien.dao.InterventionDao;
import technicien.models.Intervention;


/**
 * Servlet implementation class ListeInterventionServlet
 */
@WebServlet("/Liste_Intervention")
public class ListeInterventionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao lg_dao = new LoginDao();
	InterventionDao i_dao = new InterventionDao();     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeInterventionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(lg_dao.athentifie(request.getSession(false), "Technicien")){
			Utilisateur u = (Utilisateur) request.getSession(false).getAttribute("Utilisateur");
			request.setAttribute("listintv", i_dao.SelectIntervention(u.getId_user()));
			request.setAttribute("m_dao", new MaterielDao());
			/*
			if(request.getParameter("msg") == "erreur")
				request.setAttribute("erreur", "Materiel n'existe pas");
			else if(request.getParameter("msg") == "success")
				request.setAttribute("success", "Modifier avec success");
			*/
			request.getRequestDispatcher("tech_views/Liste_Intervention.jsp").forward(request, response);

		}else {
			response.sendRedirect(request.getContextPath()+"/Se_connecter");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("value");
		List<Intervention> listintv = new ArrayList<Intervention>();
		Utilisateur u = (Utilisateur) request.getSession(false).getAttribute("Utilisateur");
		
		if(value == "")
			listintv = i_dao.SelectIntervention(u.getId_user());
		else {
			List<Intervention> listAllInt = i_dao.SelectIntervention(u.getId_user());
			List<Intervention> listAllIntSearch = i_dao.SelectInterventionParMateriel(value);
			for (Intervention las : listAllIntSearch) {
				for (Intervention la : listAllInt) {
					if(las.getId_intervention() == la.getId_intervention())
						listintv.add(las);
				}
			}
		}
		request.setAttribute("listintv", listintv);
		request.setAttribute("m_dao", new MaterielDao());
		request.getRequestDispatcher("tech_views/Liste_Intervention.jsp").forward(request, response);
		
	}

}
