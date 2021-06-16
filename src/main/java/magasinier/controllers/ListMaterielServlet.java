package magasinier.controllers;

import java.io.IOException;
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
import magasinier.dao.TypeMaterielDao;
import magasinier.models.Materiel;

/**
 * Servlet implementation class ListMaterielServlet
 */
@WebServlet("/List_Materiel")
public class ListMaterielServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TypeMaterielDao tm_dao = new TypeMaterielDao();
	MaterielDao m_dao = new MaterielDao();
	private LoginDao lg_dao = new LoginDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListMaterielServlet() {
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

			List<Materiel> mats = m_dao.getAllMateriels();
			request.setAttribute("listmat", mats);
			request.setAttribute("tm_dao", tm_dao);
			request.setAttribute("es_dao", new Enter_StockDao());
			request.setAttribute("rm_dao", new Retour_MaterielDao());
			
			request.getRequestDispatcher("Mag_views/List_Materiel.jsp").forward(request, response);
		} else
			response.sendRedirect(request.getContextPath() + "/Se_connecter");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String value = request.getParameter("value");
		List<Materiel> mats = m_dao.SearchMateriel(value);
		request.setAttribute("tm_dao", tm_dao);
		request.setAttribute("listmat", mats);
		request.setAttribute("es_dao", new Enter_StockDao());
		request.getRequestDispatcher("Mag_views/List_Materiel.jsp").forward(request, response);
	}

}
