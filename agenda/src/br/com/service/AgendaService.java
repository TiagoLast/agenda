package br.com.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dao.AgendasDao;
import br.com.dao.PacientesDao;
import br.com.dao.ProcedimentosDao;
import br.com.entity.Agendas;
import br.com.entity.Pacientes;
import br.com.entity.Procedimentos;
import br.com.entity.Status;
import br.com.interfaces.AssinaturaHttp;
import br.com.logic.Logic;

public class AgendaService extends HttpServlet implements AssinaturaHttp {
	private static final long serialVersionUID = 1L;

	private AgendasDao dao = new AgendasDao();
	
	private PacientesDao pacientedao = new PacientesDao();
	
	private ProcedimentosDao pdao = new ProcedimentosDao();
	private Logic logic = new Logic();

	
	
	@Override
	public void adiciona(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Agendas agenda = new Agendas();
		String strpaciente = request.getParameter("paciente");
		String strprocedimento = request.getParameter("procedimento");
		String data = request.getParameter("data");
		String horario = request.getParameter("horario");
		
		
		Pacientes paciente = pacientedao.buscaPorId(Long.parseLong(strpaciente));
		Procedimentos procedimento = pdao.buscaPorId(Long.parseLong(strprocedimento));
		
		try {
			agenda.setPacientes(paciente);
			agenda.setProcedimento(procedimento);
			agenda.setData(logic.formataDate(data));
			agenda.setHorario(logic.formataHora(horario));
			dao.adiciona(agenda);
			HttpSession session = request.getSession();
			session.setAttribute("sucesso", "Agenda salva com sucesso!");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public void finalizaAgenda(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String id = request.getParameter("id");
		Agendas agenda = new Agendas();
		Status statu = new Status();
		agenda.setStatus(statu);
		agenda.setIdagenda(Long.parseLong(id));
		dao.finalizaAgenda(agenda);
	}
	
//	
//	@Override
//	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Agendas agenda = new Agendas();
//		String idagenda = request.getParameter("id");
//		String strcliente = request.getParameter("cliente");
//		String strprocedimento = request.getParameter("procedimento");
//		String data = request.getParameter("data");
//		String horario = request.getParameter("horario");
//		String status = request.getParameter("status");
//		
//		
//		Clientes cliente = cdao.buscaPorId(Long.parseLong(strcliente));
//		Procedimentos procedimento = pdao.buscaPorId(Long.parseLong(strprocedimento));
//		
//		try {
//			agenda.setIdagenda(Long.parseLong(idagenda));
//			agenda.setCliente(cliente);
//			agenda.setProcedimento(procedimento);
//			agenda.setData(logic.formataDate(data));
//			agenda.setHorario(logic.formataHora(horario));
//			agenda.setStatus(status);
//			dao.update(agenda);
//			HttpSession session = request.getSession();
//			session.setAttribute("sucesso", "Agenda salva com sucesso!");
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//
//	}
	
	
//	@Override
//	public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String id = request.getParameter("id");
//		Agendas agenda = new Agendas();
//		agenda.setIdagenda(Long.parseLong(id));
//		dao.remove(agenda);
//		
//	}
//	
	
	@Override
	public void buscaPorId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Agendas agenda = dao.buscaPorId(Long.parseLong(id));
		request.setAttribute("agenda", agenda);
	}
	
	
	public void getAgendasFinalizada(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Agendas> agendasfinalizadas = dao.getAgendasFinalizada();
	    request.setAttribute("agendasfinalizadas", agendasfinalizadas);
	}
	
	public void getAgendasNaoFinalizada(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	List<Agendas> agendasnaofinalizadas = dao.getAgendasNaoFinalizada();
		request.setAttribute("agendasnaofinalizadas", agendasnaofinalizadas);
	}
}









