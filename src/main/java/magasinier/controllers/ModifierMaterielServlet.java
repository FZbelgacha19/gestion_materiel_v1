package magasinier.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import magasinier.dao.TypeMaterielDao;
//import magasinier.models.Entrer_Stock;
import magasinier.models.Materiel;
import magasinier.models.TypeMateriel;

/**
 * Servlet implementation class ModifierMaterielServlet
 */
@WebServlet("/Modifier_Materiel")
public class ModifierMaterielServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 TypeMaterielDao tm_dao = new TypeMaterielDao();
	    MaterielDao m_dao = new MaterielDao();
	    Enter_StockDao e_dao = new Enter_StockDao();
		private LoginDao lg_dao = new LoginDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierMaterielServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(lg_dao.athentifie(request.getSession(false), "Magasinier")){
			int id = Integer.parseInt(request.getParameter("id_mat"));
			Materiel mat = m_dao.getMateriels(id);
			List<TypeMateriel> type_m= tm_dao.SelectTypeMateriel();
			request.setAttribute("listtype", type_m);
			request.setAttribute("mat", mat);
			request.setAttribute("es_dao", e_dao);
			request.getRequestDispatcher("Mag_views/edit_materiel.jsp").forward(request, response);
			}else
				response.sendRedirect(request.getContextPath()+"/Se_connecter");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			int Designation;
			if(request.getParameter("newDesignation").equals("")) {
				Designation = Integer.parseInt(request.getParameter("Designation"));
				
			}else {
				String newDesignation = request.getParameter("newDesignation");
				TypeMateriel  t = new TypeMateriel();
				List<TypeMateriel> type_m= tm_dao.SelectTypeMateriel();
				t.setId_Typemat(1+type_m.size());
				t.setNom_mat(newDesignation);
				Designation = t.getId_Typemat();
				tm_dao.AjoutTypeMateriel(t);
			}
			
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			//Date d = new Date();
			
			String Num_Serie = request.getParameter("Num_Serie");
			Date Date_garantie= f.parse(request.getParameter("Date_garantie"));
			String Etat_mat= request.getParameter("Etat_mat");
			String Mark= request.getParameter("Mark");
			int Id_mat = Integer.parseInt(request.getParameter("id_mat"));
			Materiel mat = new Materiel();
			mat.setId_mat(Id_mat);
			mat.setDate_garantie(new java.sql.Date(Date_garantie.getTime()));
			mat.setDesignation(Designation);
			mat.setEtat_mat(Etat_mat);
			mat.setNum_Serie(Num_Serie);
			mat.setMark(Mark);
			m_dao.ModifMateriel(mat);
			
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/List_Materiel");
	}

}
