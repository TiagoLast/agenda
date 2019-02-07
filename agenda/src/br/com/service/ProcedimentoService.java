package br.com.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dao.ProcedimentosDao;
import br.com.entity.Procedimentos;
import br.com.interfaces.AssinaturaHttp;

public class ProcedimentoService extends HttpServlet implements AssinaturaHttp {
	private static final long serialVersionUID = 1L;
       
	private ProcedimentosDao dao = new ProcedimentosDao();
	
	
	@Override
	public void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Procedimentos> procedimentos = dao.getAll();
		request.setAttribute("procedimentos", procedimentos);
		
	}
	

}
