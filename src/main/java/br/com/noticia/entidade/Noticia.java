package br.com.noticia.entidade;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Noticia {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String titulo;
	private String subtitulo;
	private String categoria;
	@Column(length=5000) @NotNull
	private String descricao;
	private String imagem;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNoticia;
	
	public Date getDataNoticia() {
		return dataNoticia;
	}
	public void setDataNoticia(Date dataNoticia) {
		this.dataNoticia = dataNoticia;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSubtitulo() {
		return subtitulo;
	}
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	
}
