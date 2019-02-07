package br.com.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.service.PacientesService;

@WebServlet({ "/telefones", "/pacientes"})
public class PacienteControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PacientesService pacientes = new PacientesService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		executa(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		executa(request, response);
	}

	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = request.getContextPath();

		if (uri.equals(path + "/telefones")) {
			pacientes.getTelefones(request, response);
			request.getRequestDispatcher("/telefones.jsp").forward(request, response);
			return;
		}
		
		if (uri.equals(path + "/pacientes")) {
			pacientes.getAll(request, response);
			request.getRequestDispatcher("/pacientes.jsp").forward(request, response);
			return;
		}

	}

}
