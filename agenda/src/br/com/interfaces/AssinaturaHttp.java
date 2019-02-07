package br.com.interfaces;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AssinaturaHttp {

	default void adiciona(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

	}

	default void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	default void remove(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

	}

	default void buscaPorId(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

	}

	default void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
