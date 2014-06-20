package br.ufg.inf.mobile2014.projetoufg;

public class Notificacao {
	private boolean foiLido;
	private String remetente;
	private String titulo;
	private String mensagem;
	
	public Notificacao(String remetente, String titulo, String mensagem) {
		this.remetente = remetente;
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.foiLido = false;
	}
	
	public String getRementente() {
		return this.remetente;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getMensagem() {
		return this.mensagem;
	}
	
	public boolean getFoiLido() {
		return this.foiLido;
	}
	
	public void setFoiLido(boolean foiLido) {
		this.foiLido = foiLido;
	}
}
