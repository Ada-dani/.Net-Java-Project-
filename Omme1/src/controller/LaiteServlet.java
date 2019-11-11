package controller;

import java.io.IOException;

import model.Laite;
import model.ejb.LaiteDAO;

/**
 * 
 * @author bagnes
 */
@WebServlet(name = "LaiteServlet", urlPatterns = { "/LaiteServlet" })
public class LaiteServlet extends HttpServlet {

	@EJB
	private LaiteDAO laiteDAO;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String laitteenID = request.getParameter("id");
		String nimi = request.getParameter("nimi");
		String kuvaus = request.getParameter("kuvaus");
		Double hinta = request.getParameter("hinta");
		int ostop‰iv‰m‰‰r‰ = request.getParameter("ostop‰iv‰m‰‰r‰");
		int takuu = request.getParameter("takuu");
		String operation = request.getParameter("operation");

		Laite laite = new Laite(laitteenID, nimi, kuvaus, ostop‰iv‰m‰‰r‰, takuu);

		if (operation.equalsIgnoreCase("Add")) {
			laiteDAO.addlaite(laite);
			request.setAttribute("laite", laite);

		} else if (operation.equalsIgnoreCase("Edit")) {
			laiteDAO.editlaite(laite);
			Laite searchedlaite = laiteDAO.getLaite(laitteenID);
			request.setAttribute("laite", searchedLaite);

		} else if (operation.equalsIgnoreCase("Delete")) {
			laiteDAO.deleteLaite(laitteenID);

		} else if (operation.equalsIgnoreCase("Search")) {
			Laite searchedLaite = laiteDAO.getLaite(laitteenID);
			request.setAttribute("laite", searchedLaite);
		}
		request.getRequestDispatcher("laitetiedot.jsp").forward(request,
				response);
	}

	// <editor-fold defaultstate="collapsed"
	// desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 * 
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}
}
