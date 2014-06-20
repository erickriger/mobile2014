package br.ufg.inf.mobile2014.projetoufg;

import java.util.ArrayList;
import java.util.List;

public class TituloNotificacoesExpandableList {

	public String titulo;
	public String remetente;
	public final List<String> children = new ArrayList<String>();
	
	public TituloNotificacoesExpandableList(String titulo, String remetente) {
		this.titulo = titulo;
		this.remetente = remetente;
	}
}
