package magasinier.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dao.LoginDao;
import magasinier.dao.Enter_StockDao;
import magasinier.dao.MaterielDao;

import magasinier.dao.Sortie_stockDao;
import magasinier.dao.TypeMaterielDao;
import magasinier.models.Entrer_Stock;
import magasinier.models.Materiel;
import magasinier.models.Sortie_stock;

/**
 * Servlet implementation class PreteMaterielServlet
 */
@WebServlet(urlPatterns = { "/Prete_Materiel", "/Prete" })
public class PreteMaterielServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao lg_dao = new LoginDao();
	Sortie_stockDao ss_dao = new Sortie_stockDao();
	Enter_StockDao es_dao = new Enter_StockDao();
	MaterielDao m_dao = new MaterielDao();
	TypeMaterielDao tm_dao = new TypeMaterielDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PreteMaterielServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (lg_dao.athentifie(request.getSession(false), "Magasinier")) {
			if (request.getServletPath().equals("/Prete")) {
				String id = request.getParameter("id_m");
				
				Date d = new Date();
				int id_m = Integer.parseInt(id);
				int id_ss = 1 + ss_dao.maxid();
				Sortie_stock ss = new Sortie_stock();
				ss.setId_mat(id_m);
				ss.setId_sortie(id_ss);
				ss.setDate_sorie(new java.sql.Date(d.getTime()));
				ss_dao.AjoutSortie_stock(ss);

				es_dao.SuppEntrer_StockParidMat(id_m);
				response.sendRedirect(request.getContextPath() + "/Prete_Materiel");

			} else if (request.getServletPath().equals("/Prete_Materiel")) {
				List<Entrer_Stock> eslist = es_dao.SelectEntrer_Stock();
				List<Materiel> mats = new ArrayList<Materiel>();
				for (Entrer_Stock es : eslist) {
					Materiel m = m_dao.getMateriels(es.getId_Mat());
					mats.add(m);
				}
				request.setAttribute("listmat", mats);
				request.setAttribute("tm_dao", tm_dao);
				
				request.getRequestDispatcher("Mag_views/Prete_Materiel.jsp").forward(request, response);

			}
		} else
			response.sendRedirect(request.getContextPath() + "/Se_connecter");
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if (request.getServletPath().equals("/Prete_Materiel")) {

		String value = request.getParameter("value");
		List<Entrer_Stock> eslist = es_dao.SelectEntrer_Stock();
		List<Materiel> matslist = m_dao.SearchMateriel(value);
		List<Materiel> mats = new ArrayList<Materiel>();
		for (Materiel m : matslist) {
			for (Entrer_Stock es : eslist) {
				if(es.getId_Mat() == m.getId_mat()) {
					mats.add(m);
					break;
				}
					
			}
		}
		request.setAttribute("listmat", mats);
		request.setAttribute("tm_dao", tm_dao);
		request.getRequestDispatcher("Mag_views/Prete_Materiel.jsp").forward(request, response);

	}

	}

}
