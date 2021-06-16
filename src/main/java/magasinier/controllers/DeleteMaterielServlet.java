package magasinier.controllers;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dao.LoginDao;
import magasinier.dao.Enter_StockDao;
import magasinier.dao.MaterielDao;
import magasinier.dao.TypeMaterielDao;


/**
 * Servlet implementation class DeleteMaterielServlet
 */
@WebServlet("/Delete_Materiel")
public class DeleteMaterielServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 TypeMaterielDao tm_dao = new TypeMaterielDao();
	    MaterielDao m_dao = new MaterielDao();
	    Enter_StockDao e_dao = new Enter_StockDao();
		private LoginDao lg_dao = new LoginDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMaterielServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(lg_dao.athentifie(request.getSession(false), "Magasinier")){
			int id = Integer.parseInt(request.getParameter("id_mat"));
			m_dao.DeletMatteriel(id);
			response.sendRedirect(request.getContextPath()+"/List_Materiel");
			}else
				response.sendRedirect(request.getContextPath()+"/Se_connecter");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
