package superviseur.controllers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import login.dao.LoginDao;
import superviseur.dao.UtilisateurDao;
import superviseur.models.Utilisateur;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/Modifier_Les_informations")
@MultipartConfig
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UtilisateurDao u_dao = new UtilisateurDao();
    private LoginDao lg_dao = new LoginDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(lg_dao.athentifie(request.getSession(false), "Superviseur")){
			String id_user = request.getParameter("id_user");
			try {
				Utilisateur user = u_dao.getUtilisateurParId(id_user);
				request.setAttribute("user", user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("utilisateur_views/updateuser.jsp").forward(request, response);
		}
		else
			response.sendRedirect(request.getContextPath()+"/Se_connecter");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_user = request.getParameter("id_user");
		Utilisateur u;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date date = new Date();

		String Nom_user = request.getParameter("nom");
		String Prenom_user = request.getParameter("prenom");
		String Tele = request.getParameter("tele");
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String Motpass = request.getParameter("motPass");
		String type_user = request.getParameter("type_user");
		String updated_at = format.format(date);
		
		try {
			u = u_dao.getUtilisateurParId(id_user);
			// photo
						String ImageName = u.getPhoto();
						Part ImagePart = request.getPart("photo");
						if (ImagePart.getSize() > 0) {
							String photoname = ImagePart.getSubmittedFileName();
							String date_photo = f.format(date);
							int index = photoname.lastIndexOf('.');
							ImageName = email + '_' + date_photo + "." + photoname.substring(index + 1);
							String appPath = getServletContext().getRealPath("");
							String met = ".metadata";
							String wtp = "wtpwebapps";
							int index1 = appPath.indexOf(met);
							int index2 = appPath.indexOf(wtp);
							String workspace = appPath.substring(0, index1 - 1);
							String projectName = appPath.substring(index2 + wtp.length(), appPath.length());
							
							String imgpath = workspace + projectName + "src\\main\\webapp\\login_views\\img" + File.separator
									+ ImageName;
							System.out.println(imgpath);
							ImagePart.write(imgpath);

						}
			
			u.setNom_user(Nom_user);
			u.setPrenom_user(Prenom_user);
			u.setEmail(email);
			u.setTele(Tele);
			u.setLogin(login);
			u.setMotpass(Motpass);
			u.setMotpassConfirmation(Motpass);
			u.setType_user(type_user);
			u.setUpdated_at(updated_at);
			u.setPhoto(ImageName);
			u_dao.ModifierUtilisateur(u);
			response.sendRedirect(request.getContextPath()+"/Liste_Utilisateurs?success=Utilisateur modifier avec success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
