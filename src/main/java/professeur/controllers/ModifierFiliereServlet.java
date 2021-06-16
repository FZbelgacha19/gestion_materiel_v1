package professeur.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dao.LoginDao;
import professeur.dao.FiliereDao;
import professeur.models.Filiere;

/**
 * Servlet implementation class ModifierFiliereServlet
 */
@WebServlet("/Modifier_Filiere")
public class ModifierFiliereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao lg_dao = new LoginDao();  
	FiliereDao f_dao = new FiliereDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierFiliereServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (lg_dao.athentifie(request.getSession(false), "Professeur")) {
			int id = Integer.parseInt(request.getParameter("id_f"));
			Filiere f = f_dao.SelectFiliere(id);
			request.setAttribute("f",f);
			request.getRequestDispatcher("prof_views/Modifier_Filiere.jsp").forward(request, response);
			} else 
				response.sendRedirect(request.getContextPath() + "/Se_connecter");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_f"));
		Filiere f = f_dao.SelectFiliere(id);
		int Nbr_etudiant = Integer.parseInt(request.getParameter("Nbr_etudiant"));
		String Nom_fil = request.getParameter("Nom_fil");

		f.setNbr_etudiant(Nbr_etudiant);
		f.setNom_fil(Nom_fil);
		f_dao.ModifeFiliere(f);
		response.sendRedirect(request.getContextPath()+"/List_Filiere");

	}

}
