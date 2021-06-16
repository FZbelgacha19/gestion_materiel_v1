package professeur.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dao.LoginDao;
import professeur.dao.SalleDao;
import professeur.models.Salle;

/**
 * Servlet implementation class ModifierSalleServlet
 */
@WebServlet("/Modifier_Salle")
public class ModifierSalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao lg_dao = new LoginDao();
	SalleDao s_dao = new SalleDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierSalleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (lg_dao.athentifie(request.getSession(false), "Professeur")) {
			int id = Integer.parseInt(request.getParameter("id_s"));
			Salle s = s_dao.SelectSalle(id);
			request.setAttribute("s",s);
			request.getRequestDispatcher("prof_views/Modifier_Salle.jsp").forward(request, response);
			} else 
				response.sendRedirect(request.getContextPath() + "/Se_connecter");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_s"));
		Salle s = s_dao.SelectSalle(id);
		int num = Integer.parseInt(request.getParameter("Num_salle"));
		String bloc = request.getParameter("Bloc");
		s.setNum_salle(num);
		s.setBloc(bloc);
		s_dao.ModifeSalle(s);
		response.sendRedirect(request.getContextPath()+"/List_Salle");

	}

}
