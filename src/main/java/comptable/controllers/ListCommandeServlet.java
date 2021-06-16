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
 * Servlet implementation class ListCommandeServlet
 */
@WebServlet("/Liste_Commande")
public class ListCommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao lg_dao = new LoginDao();
	CommandeDao c_dao = new CommandeDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCommandeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (lg_dao.athentifie(request.getSession(false), "Comptable")) {
			request.setAttribute("listCmd", c_dao.SelectCommande());
			request.setAttribute("listNumCmd", c_dao.getCommandes());
			request.getRequestDispatcher("Comp_views/Liste_Commande.jsp").forward(request, response);
		} else
			response.sendRedirect(request.getContextPath() + "/Se_connecter");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("value");
		request.setAttribute("listCmd", c_dao.SelectCommande());
		if(value == "")
			request.setAttribute("listNumCmd",c_dao.getCommandes());
		else
			request.setAttribute("listNumCmd", c_dao.getCommandes(Integer.parseInt(value)));
		request.getRequestDispatcher("Comp_views/Liste_Commande.jsp").forward(request, response);
	}

}
