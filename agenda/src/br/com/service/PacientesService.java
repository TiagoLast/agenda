package br.com.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dao.PacientesDao;
import br.com.entity.Pacientes;
import br.com.interfaces.AssinaturaHttp;

public class PacientesService extends HttpServlet implements AssinaturaHttp {
	private static final long serialVersionUID = 1L;
       
	private PacientesDao dao = new PacientesDao();	
	
	public void getTelefones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("pnome");
		List<Pacientes> telefones = dao.getTelefones(nome);
		request.setAttribute("telefones", telefones);
	}
	
	public void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Pacientes> pacientes = dao.getAll();
		request.setAttribute("pacientes", pacientes);
	}
	
	
}
