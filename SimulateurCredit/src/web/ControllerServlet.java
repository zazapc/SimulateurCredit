package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CreditMetier;
//@WebServlet(name="cs", urlPatterns={"/Controller", "*.php"})
public class ControllerServlet extends HttpServlet {
	private CreditMetier metier;

	@Override
	public void init() throws ServletException {
    metier=new CreditMetier();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("model", new CreditModel());
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double montant=Double.parseDouble(request.getParameter("montant"));
		double taux=Double.parseDouble(request.getParameter("taux"));
		int duree=Integer.parseInt(request.getParameter("duree"));
		CreditModel model=new CreditModel();
		model.setMontant(montant);
		model.setTaux(taux);
		model.setDuree(duree);
		double res=metier.calculMonsualite(montant, duree, taux);
		model.setMensualite(res);
		request.setAttribute("model", model);
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
	}
	
}
