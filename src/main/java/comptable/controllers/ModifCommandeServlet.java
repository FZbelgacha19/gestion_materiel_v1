package comptable.controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comptable.dao.CommandeDao;
import comptable.models.Commande;
import login.dao.LoginDao;

/**
 * Servlet implementation class ModifCommandeServlet
 */
@WebServlet("/Modifier_Commande")
public class ModifCommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao lg_dao = new LoginDao();
	CommandeDao c_dao = new CommandeDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifCommandeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (lg_dao.athentifie(request.getSession(false), "Comptable")) {
			int id = Integer.parseInt(request.getParameter("id_c"));
			request.setAttribute("c", c_dao.SelectCommande(id));
			request.getRequestDispatcher("Comp_views/Modifier_Commande.jsp").forward(request, response);
		} else
			response.sendRedirect(request.getContextPath() + "/Se_connecter");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date Date_cmd = new Date();
		String typeMat = request.getParameter("typeMat");
		String Description = request.getParameter("Description");
		String Qte = request.getParameter("Qte");
		int id = Integer.parseInt(request.getParameter("id_c"));
		
		
			Commande c = c_dao.SelectCommande(id);
			c.setDate_cmd(new java.sql.Date(Date_cmd.getTime()));
			c.setDescription(Description);
			c.setQte(Integer.parseInt(Qte));
			c.setTypeMat(typeMat);
			c_dao.ModifeCommande(c);
			response.sendRedirect(request.getContextPath() + "/Liste_Commande");

		}
	}


