package br.com.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.service.AgendaService;
import br.com.service.PacientesService;
import br.com.service.ProcedimentoService;

@WebServlet({ "/agenda", "/agendas", "/add-agenda", "/agendas-nao-finalizada","/finaliza-agenda" })
public class AgendaControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AgendaService agenda = new AgendaService();
	private ProcedimentoService procedimento = new ProcedimentoService();
	private PacientesService paciente = new PacientesService();

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

		if (uri.equals(path + "/agenda")) {
			procedimento.getAll(request, response);
			paciente.getAll(request, response);
			request.getRequestDispatcher("/agenda.jsp").forward(request, response);
			return;
		}

		if (uri.equals(path + "/agendas")) {
			agenda.getAgendasFinalizada(request, response);
			request.getRequestDispatcher("/agendas.jsp").forward(request, response);
		}
		
		if (uri.equals(path + "/agendas-nao-finalizada")) {
			agenda.getAgendasNaoFinalizada(request, response);
			request.getRequestDispatcher("/agendas-nao-finalizada.jsp").forward(request, response);
		}

		
		if (uri.equals(path + "/add-agenda")) {
			agenda.adiciona(request, response);
			response.sendRedirect(path+"/agenda");
			return;
		}
		if (uri.equals(path + "/finaliza-agenda")) {
			agenda.finalizaAgenda(request, response);
			agenda.getAgendasFinalizada(request, response);
			response.sendRedirect(path+"/agendas");
			return;
		}
	}

}
