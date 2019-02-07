package br.com.logic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Tiago S Lima
 * @version 1.1
 * @since 1.8
 */
public class Logic {

	private final String TIMEBR = "HH:mm"; 
	private final String DATEBR = "dd-MM-yyyy"; 
	
	/**
	 * Esse metodo formata data.
	 * @param date  e uma string com o data passado para ser formatado para o formato BR.
	 * @exception formato seja passado errado.
	 * @return retorna data com formato BR
	 * obrigatorio passar o  formato BR exemplo: ano / mes / dia
	 */
	public Date formataDate(String date) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(DATEBR);
		Date dft = sdf.parse(date);
		return dft;
	}

	
	/**
	 * Esse metodo formata do tipo string para date <br>
	 * formato para ser passado: 00:00 hora:minuto
	 * @param horario e uma string com formato de hora BR
	 * @return hora formata para formato BR
	 * @throws Exception caso for passado o formato errado
	 */
	public Date formataHora(String horario) throws Exception {
		SimpleDateFormat hsdf = new SimpleDateFormat(TIMEBR);
		Date hora = hsdf.parse(horario);
		return hora;
	}


	/**
	 * Esse metodo faz calculo entre hora do tipo string para date <br>
	 * formato para ser passado: 00:00 hora:minuto
	 * @param inicio e fim, e uma string com formato de hora.
	 * @return calculo entre hora passada
	 * @throws Exception caso o formato esteja passado errado.
	 */
	public Date calculoEntreHoras(String inicio, String fim) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(TIMEBR);

		Calendar hinicio = Calendar.getInstance();
		Calendar hfim = Calendar.getInstance();

		hinicio.setTime(sdf.parse(inicio));
		hfim.setTime(sdf.parse(fim));

		long minutos = ((hfim.getTimeInMillis() - hinicio.getTimeInMillis())) / 60000;
		long resto = minutos % 60;
		long horas = minutos / 60;

		String diferenca = horas + ":" + resto;
		Date hora = sdf.parse(diferenca);

		return hora;

	}

}
