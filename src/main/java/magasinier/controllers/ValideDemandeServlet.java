package magasinier.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dao.LoginDao;
import magasinier.dao.MaterielDao;
import magasinier.dao.TypeMaterielDao;

import professeur.dao.DemandeDao;
import professeur.dao.FiliereDao;
import professeur.dao.SalleDao;

/**
 * Servlet implementation class ValideCommandeServlet
 */
@WebServlet(urlPatterns = {"/Valide_Commande", "/Valider"})
public class ValideDemandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao lg_dao = new LoginDao();
	MaterielDao m_dao = new MaterielDao();
	FiliereDao f_fao = new FiliereDao();
	SalleDao s_dao = new SalleDao();
	DemandeDao d_dao = new DemandeDao();
	TypeMaterielDao tp_dao = new TypeMaterielDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValideDemandeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(lg_dao.athentifie(request.getSession(false), "Magasinier")){
			if(request.getServletPath().equals("/Valide_Commande")) {
			request.setAttribute("tp", tp_dao);
			request.setAttribute("s", s_dao);
			request.setAttribute("f", f_fao);
			request.setAttribute("ListDmd", d_dao.SelectDemande());
			request.getRequestDispatcher("Mag_views/Valide_Commande.jsp").forward(request, response);
		}else if(request.getServletPath().equals("/Valider")) {
			int id = Integer.parseInt(request.getParameter("id_d"));
			d_dao.validerDemande(id);
			response.sendRedirect(request.getContextPath()+"/Valide_Commande");

		}
		}else
			response.sendRedirect(request.getContextPath()+"/Se_connecter");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletPath().equals("/Valide_Commande")) {
		String value = request.getParameter("value");
		request.setAttribute("tp", tp_dao);
		request.setAttribute("s", s_dao);
		request.setAttribute("f", f_fao);
		request.setAttribute("ListDmd", d_dao.SelectDemande(value));
		request.getRequestDispatcher("Mag_views/Valide_Commande.jsp").forward(request, response);
	}
	}

}
