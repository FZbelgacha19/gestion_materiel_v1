package comptable.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comptable.dao.CommandeDao;
import login.dao.LoginDao;

/**
 * Servlet implementation class ImprimerCommandeServlet
 */
@WebServlet("/Imprimer_Commande")
public class ImprimerCommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao lg_dao = new LoginDao();
	CommandeDao c_dao = new CommandeDao();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImprimerCommandeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (lg_dao.athentifie(request.getSession(false), "Comptable")) {
			int num_c = Integer.parseInt(request.getParameter("num_c"));
			request.setAttribute("listCmd", c_dao.SelectCommandeParNumCmd(num_c));
			request.setAttribute("NumCmd", num_c);
			request.getRequestDispatcher("Comp_views/Imprimer_Commande.jsp").forward(request, response);
		} else
			response.sendRedirect(request.getContextPath() + "/Se_connecter");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
