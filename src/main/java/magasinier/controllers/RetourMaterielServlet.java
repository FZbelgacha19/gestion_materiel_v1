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
import magasinier.dao.Retour_MaterielDao;
import magasinier.dao.Sortie_stockDao;
import magasinier.dao.TypeMaterielDao;
import magasinier.models.Entrer_Stock;
import magasinier.models.Materiel;
import magasinier.models.Retour_Materiel;
import magasinier.models.Sortie_stock;

/**
 * Servlet implementation class RetourMaterielServlet
 */
@WebServlet(urlPatterns = {"/Materiels_preter", "/Retour_Materiel"})
public class RetourMaterielServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao lg_dao = new LoginDao();
	Sortie_stockDao ss_dao = new Sortie_stockDao();
	MaterielDao m_dao = new MaterielDao();
	TypeMaterielDao tm_dao = new TypeMaterielDao();
	Retour_MaterielDao rm_dao = new Retour_MaterielDao();
	Enter_StockDao es_dao = new Enter_StockDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetourMaterielServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(lg_dao.athentifie(request.getSession(false), "Magasinier")){
			if(request.getServletPath().equals("/Materiels_preter")) {
				List<Sortie_stock> lss = ss_dao.SelectSortie_stock();
				List<Materiel> mats = new ArrayList<Materiel>();
				for (Sortie_stock s : lss) {
					Materiel m = m_dao.getMateriels(s.getId_mat());
					mats.add(m);
				}
				request.setAttribute("tm_dao", tm_dao);
				request.setAttribute("listmat",mats);
				request.setAttribute("rm_dao", rm_dao);
				request.getRequestDispatcher("Mag_views/List_Materiels_preter.jsp").forward(request, response);

			}else if(request.getServletPath().equals("/Retour_Materiel")) {
				String id = request.getParameter("id_m");
				Date d = new Date();
				int id_m = Integer.parseInt(id);
				
				//Add Materiel to enter_stock
				Entrer_Stock e = new Entrer_Stock();
				e.setDate_entrer(new java.sql.Date(d.getTime()));
				int id_es = 1+es_dao.maxid();
				e.setId_entrer(id_es);
				e.setId_Mat(id_m);
				es_dao.AjoutEntrer_Stock(e);
				
				//Delete from sortie stock
				ss_dao.SuppSortie_stockParMateriel(id_m);
				
				//Add to retour materiel
				int id_rm = 1+rm_dao.maxid();
				Retour_Materiel rm = new Retour_Materiel();
				rm.setId_mat(id_m);
				rm.setId_retour(id_rm);
				rm.setDate_retour(new java.sql.Date(d.getTime()));
				rm_dao.AjoutRetour_Materiel(rm);
				
				response.sendRedirect(request.getContextPath()+"/Materiels_preter");
			}
			
			
		}else
			response.sendRedirect(request.getContextPath()+"/Se_connecter");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getServletPath().equals("/Materiels_preter")) {

			String value = request.getParameter("value");
			List<Sortie_stock> lss = ss_dao.SelectSortie_stock();
			List<Materiel> matslist = m_dao.SearchMateriel(value);
			List<Materiel> mats = new ArrayList<Materiel>();
			for (Materiel m : matslist) {
				for (Sortie_stock s : lss) {
					if(s.getId_mat() == m.getId_mat()) {
						mats.add(m);
						break;
					}
						
				}
			}
			request.setAttribute("listmat", mats);
			request.setAttribute("tm_dao", tm_dao);
			request.getRequestDispatcher("Mag_views/List_Materiels_preter.jsp").forward(request, response);

		}
	}

}
