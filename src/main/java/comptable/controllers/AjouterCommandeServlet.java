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
 * Servlet implementation class AjouterCommandeServlet
 */
@WebServlet("/Ajouter_Commande")
public class AjouterCommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao lg_dao = new LoginDao();
	CommandeDao c_dao = new CommandeDao();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjouterCommandeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (lg_dao.athentifie(request.getSession(false), "Comptable")) {
			request.getRequestDispatcher("Comp_views/Ajouter_Commande.jsp").forward(request, response);
		} else
			response.sendRedirect(request.getContextPath() + "/Se_connecter");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int Num_cmd = 1+c_dao.maxNum_cmd();
		
		Date Date_cmd = new Date();
		String[] typeMat = request.getParameterValues("typeMat");
		String[] Description = request.getParameterValues("Description");
		String[] Qte = request.getParameterValues("Qte");
		
		for(int i=0; i<typeMat.length;i++) {
			int id = 1+c_dao.maxid();
			Commande c = new Commande();
			c.setId_cmd(id);
			c.setNum_cmd(Num_cmd);
			c.setDate_cmd(new java.sql.Date(Date_cmd.getTime()));
			c.setTypeMat(typeMat[i]);
			c.setEtat_cmd("no_paye");
			c.setDescription(Description[i]);
			c.setQte(Integer.parseInt(Qte[i]));
			c.setValider("no_valide");
			c_dao.AjoutCommande(c);
		}
		response.sendRedirect(request.getContextPath()+"/Imprimer_Commande?num_c="+Num_cmd);

	}

}
