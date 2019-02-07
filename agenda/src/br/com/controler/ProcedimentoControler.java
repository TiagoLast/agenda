package br.com.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.service.ProcedimentoService;

@WebServlet("/procedimentos")
public class ProcedimentoControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProcedimentoService procedimento = new ProcedimentoService();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		executa(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		executa(request, response);
	}
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = request.getContextPath();


		if (uri.equals(path + "/procedimentos")) {
			procedimento.getAll(request, response);
			request.getRequestDispatcher("/procedimentos.jsp").forward(request, response);
		}
		
	}
}
